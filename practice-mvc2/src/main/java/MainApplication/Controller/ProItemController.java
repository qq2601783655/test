package MainApplication.Controller;

import MainApplication.Bean.Identify;
import MainApplication.PoJo.Production;
import MainApplication.Service.OrderShowService.OrderItemShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProItemController {
    @Autowired
    OrderItemShowService orderItemShowService;
    @Autowired
    Identify identify;
    @RequestMapping("/order_item")
    public String orderItemShow(Model model,String ordercode,HttpServletRequest request){

        int cus_id = identify.getCusIdFromCookie(request.getCookies());
        if (cus_id==0){
            return "login";
        }
        List<Production> list = orderItemShowService.proOrderItemShow(ordercode, cus_id);
        model.addAttribute("list",list);
        return "orderItem";
    }



}
