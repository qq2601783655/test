package MainApplication.Controller;

import MainApplication.Bean.Identify;
import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProCarMapper;
import MainApplication.PoJo.ProCar;
import MainApplication.PoJo.ProCarExample;
import MainApplication.Service.ProCarService.ProCarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProCarController {

        @Autowired
        ProCarService proCarService;
        @Autowired
        ProCar proCar;
        @Autowired
        Identify identify;
    //提交商品到购物车
    @RequestMapping("/submit_pro")
    @ResponseBody
    public String subPro(HttpServletRequest request,Model model) throws JsonProcessingException {

        int cusId =identify.getCusIdFromCookie(request.getCookies());
        System.out.println(cusId);
        if (cusId==0){
            model.addAttribute("message","没有登陆");
            Map map = new HashMap();
            map.put("status","false");
            return new ObjectMapper().writeValueAsString(map);
        }

        proCar.setpId(Integer.parseInt(request.getParameter("pid")));
        proCar.setCusId(cusId);
        proCar.setNum(Integer.parseInt(request.getParameter("num")));
        proCarService.subPro(proCar);
        Map map = new HashMap();
        map.put("status","true");
        return new ObjectMapper().writeValueAsString(map);
    }
    //    读取购物车数据
    @RequestMapping("/read2")
    @ResponseBody
    public String readProByCookie(HttpServletRequest request) throws JsonProcessingException {

        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("cus_id")) {
                String value = cookie.getValue();
                int cus_id = Integer.parseInt(value);
                proCar.setCusId(cus_id);
                List<ProCar> proCars = proCarService.readProByCookie(proCar);
                Map map =new HashMap();
                map.put("list",proCars);
                return new ObjectMapper().writeValueAsString(map);
            }
        }
        return null;
    }
//删除购物车数据
    @RequestMapping("/deleteitem")
    public String deletePro(int[] pro_id, HttpServletRequest request, Model model){

        int cus_id = identify.getCusIdFromCookie(request.getCookies());
        if (cus_id==0){
            model.addAttribute("message","没有登录");
            return "login";
        }
        if (pro_id==null){
            model.addAttribute("message","没有选择商品");
            return "error/5xx";
        }



        proCarService.deletePro(pro_id);
        return "redirect:check_out";
    }


}
