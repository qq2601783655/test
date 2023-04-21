package MainApplication.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController1 {
//index
    @RequestMapping("/")
    public String index(){
        return "index";
    }
//登录界面
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    产品页面
    @RequestMapping("/produce")
    public String production(){

        return "productions";

    }
//测试web
    @RequestMapping("/test")
    @ResponseBody
    public String test() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("key","test_Asynchronous");
        return new ObjectMapper().writeValueAsString(map);
    }
//    测试web1
    @RequestMapping("/test1")
    public String test1(HttpSession session){
        return "test";
    }
    @RequestMapping("/test2")
    public String test2(HttpSession session){
        return "test";
    }

//    产品详细界面
    @RequestMapping("/product_view")
    public String product_view(){

        return "product_view";
    }
//  测试异步请求
    @RequestMapping("/asynchronized")
    public String asynchronized(){

        return "asynchronized";
    }
//  付款页面
    @RequestMapping("/check_out")
    public String check_out(){

        return "checkout";
    }
//    单商品购买
    @RequestMapping("/checkout_single")
    public String check_out_single(){

        return "checkout_single";
    }

    @RequestMapping("/loginsuccess")
    public String success(){

        return "loginsuccess";
    }





}
