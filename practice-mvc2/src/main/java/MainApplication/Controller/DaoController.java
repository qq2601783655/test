package MainApplication.Controller;
import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.CustomerMapper;
import MainApplication.PoJo.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DaoController {

    SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    @RequestMapping("/transaction")
    @ResponseBody
    public String test() throws InterruptedException {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCusId(13);
        customer.setName("cheng");
        customer.setSlat("12349");
        customer.setPassword("1234");
        customer.setAcount(0.0);
        customer.setAddress("广州从化");
        customer.setPhone("1234449");
        mapper.insert(customer);
        sqlSession.commit();
        return "success";
    }




}