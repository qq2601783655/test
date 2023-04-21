package MainApplication.Service.OrderShowService;

import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProOrderMapper;
import MainApplication.PoJo.ProOrder;
import MainApplication.PoJo.ProOrderExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderShowServiceImp implements OrderShowService{

    SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    @Override
    public List<ProOrder> orderShow(int cus_id) {
        ProOrderMapper mapper = sqlSession.getMapper(ProOrderMapper.class);
        ProOrderExample proOrderExample = new ProOrderExample();
        ProOrderExample.Criteria criteria = proOrderExample.createCriteria();
        List<Integer> cus_arg = new ArrayList<>();
        cus_arg.add(cus_id);
        criteria.andCusIdIn(cus_arg);
        long l = mapper.countByExample(proOrderExample);
        System.out.println(l);
        List<ProOrder> proOrders = mapper.selectByExample(proOrderExample);
        sqlSession.close();
        sqlSession=MybatisInitial.getSqlSessionFactory().openSession();
        return proOrders;
    }
}
