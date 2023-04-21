package MainApplication.Controller;

import MainApplication.Bean.Identify;
import MainApplication.PoJo.ProOrder;
import MainApplication.Service.OrderShowService.OrderShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderShowController {
    @Autowired
    Identify identify;
    @Autowired
    OrderShowService orderShowService;
    @RequestMapping("/order_show")
    public String orderShow(HttpServletRequest request, Model model){
        int cus_id = identify.getCusIdFromCookie(request.getCookies());
        if (cus_id==0){
            model.addAttribute("message","没有登陆");
            return "login";
        }
        List<ProOrder> proOrders = orderShowService.orderShow(cus_id);
        model.addAttribute("list",proOrders);
        return "order";
    }



}
