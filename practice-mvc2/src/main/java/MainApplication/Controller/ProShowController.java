package MainApplication.Controller;
import MainApplication.PoJo.Production;
import MainApplication.PoJo.Proimg;
import MainApplication.Service.ProShowService.ProShowService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProShowController {

    @Autowired
    ProShowService proShowService;
    //    商品展示请求
    @RequestMapping("/readproduction")
    @ResponseBody
    public String readProduction() throws IOException {
        List<Production> list = proShowService.readProduction();
        Map map = new HashMap();
        map.put("list", list);
        return new ObjectMapper().writeValueAsString(map);
    }
    //详细页面的数据请求
    @RequestMapping("/read")
    @ResponseBody
    public String readProDataById(int id) throws IOException {

        Production production = proShowService.readProDataById(id);
        Map map = new HashMap();
        map.put("production", production);
        return new ObjectMapper().writeValueAsString(map);
    }
    //详细页面的图片请求
    @RequestMapping("/read1")
    @ResponseBody
    public String readProImgByPid(int pid) throws IOException {
        List<Proimg> proimgs = proShowService.readProImgByPid(pid);
        Map map = new HashMap();
        map.put("list", proimgs);
        return new ObjectMapper().writeValueAsString(map);
    }

}
