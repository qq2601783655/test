package MainApplication.Controller;

import MainApplication.ApplicationContext.MyApplicationContext;
import MainApplication.Bean.MybatisInitial;
import MainApplication.PoJo.Customer;
import MainApplication.Service.LoginService.LoginService;
import MainApplication.Service.LoginService.LoginServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    Customer customer;
    Map map_cache;

    //    登录和cookie保存
    @RequestMapping("/loginCustomer")
    @ResponseBody
    public String loginCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        String phone_value = null;
        String password_value = null;
        String phone_value_hash = null;
        String password_value_hash = null;
        String phone_key_hash = null;
        String password_key_hash = null;
        Map map = new HashMap();
        for (
                Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(String.valueOf("phone".hashCode())) && !cookie.getValue().equals("0")) {
                phone_value_hash = cookie.getValue();
            } else if (cookie.getName().equals(String.valueOf("password".hashCode())) && !cookie.getValue().equals("0")) {
                password_value_hash = cookie.getValue();
            } else {
                phone_value = request.getParameter("phone");
                password_value = request.getParameter("password");
                if (phone_value.equals("") || password_value.equals("")) {
                    map.put("ok", false);
                    map.put("message", "账号或密码错误");
                    break;
                }
                customer.setSlat(phone_value);
                customer.setPassword(password_value);
                List<Customer> customers = loginService.loginProcedure(customer);

                if (customers.size() != 0) {
                    phone_key_hash = String.valueOf("phone".hashCode());
                    phone_value_hash = String.valueOf(phone_value.hashCode());
                    password_key_hash = String.valueOf("password".hashCode());
                    password_value_hash = String.valueOf(password_value.hashCode());

                    Cookie count = new Cookie(phone_key_hash, phone_value_hash);
                    Cookie passwd = new Cookie(password_key_hash, password_value_hash);
                    Cookie slat_id = new Cookie("slat_id", customers.get(0).getSlat());
                    Cookie cus_id = new Cookie("cus_id", String.valueOf(customers.get(0).getCusId()));
                    count.setMaxAge(24 * 60 * 60);
                    passwd.setMaxAge(24 * 60 * 60);
                    slat_id.setMaxAge(24 * 60 * 60);
                    response.addCookie(count);
                    response.addCookie(passwd);
                    response.addCookie(slat_id);
                    response.addCookie(cus_id);
                    map.put("ok", true);
                } else {
                    map.put("ok", false);
                    map.put("message", "账号或密码错误");
                }

            }

        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    //    检测用户是否登录
    @RequestMapping("/cookie_identified")
    @ResponseBody
    public String loginIdentified(HttpServletRequest request) throws JsonProcessingException {
        Map map = new HashMap();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("slat_id")){
                map.put("name",cookie.getValue());
            }
            if (cookie.getName().equals(String.valueOf("phone".hashCode()))&&!cookie.getValue().equals("0")){
                map.put("key","true");
            }
        }
        return new ObjectMapper().writeValueAsString(map);
    }

    // 用户注销和杀死cookie
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws JsonProcessingException, InterruptedException {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(String.valueOf("phone".hashCode()))||cookie.getName().equals(String.valueOf("password".hashCode()))
                    ||cookie.getName().equals("slat_id")||cookie.getName().equals("cus_id")){
                System.out.println(cookie.getName());
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        model.addAttribute("message","注销成功");
        return "success";
    }




}
