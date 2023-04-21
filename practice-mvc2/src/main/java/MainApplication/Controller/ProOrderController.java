package MainApplication.Controller;
import MainApplication.Bean.Identify;
import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProOrderMapper;
import MainApplication.PoJo.ProOrder;
import MainApplication.Service.ProOrderService.ProOrderServiceImp;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.chart.PieChart;
import javafx.scene.input.DataFormat;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProOrderController {

    @Autowired
    ProOrderServiceImp proOrderServiceImp;
    @Autowired
    Identify identify;
    //    提交订单
    @RequestMapping("/order")
    public String OrderItemGenerate(int[] pro_num, int[] pro_id , ProOrder proOrder, HttpServletRequest request, Model model) throws ParseException {
        int slat_id= identify.getSlatIdFromCookie(request.getCookies());
        int cus_id = identify.getCusIdFromCookie(request.getCookies());

        if (pro_id==null){
            model.addAttribute("message","没有选择商品");
            return "error/5xx";
        }
        if (slat_id==0){
            model.addAttribute("message","没有登录");
            return "login";
        }

        proOrder.setCusId(cus_id);
        proOrderServiceImp.OrderItemGenerate(pro_num,pro_id,proOrder);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String date1 = simpleDateFormat.format(date);
        model.addAttribute("message","提交成功");
        return "success";

    }

//    付款
    @RequestMapping("/pay")
    public String pay(ProOrder proOrder,Model model){
        Date deliverydate = proOrder.getDeliverydate();
        System.out.println(deliverydate);
        SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
        proOrder.setStatus("已付款");
        proOrder.setDeliverydate(new Date());
        proOrder.setPaydate(new Date());
        model.addAttribute("message","付款成功");
        ProOrderMapper mapper = sqlSession.getMapper(ProOrderMapper.class);
        System.out.println(proOrder);
        mapper.updateByPrimaryKey(proOrder);
        sqlSession.commit();
        model.addAttribute("message","付款成功");
        return "success";
    }




}
