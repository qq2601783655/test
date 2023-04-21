package MainApplication.Service.OrderShowService;

import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProOrderItemMapper;
import MainApplication.Mapper.ProductionMapper;
import MainApplication.PoJo.ProOrderItem;
import MainApplication.PoJo.ProOrderItemExample;
import MainApplication.PoJo.Production;
import MainApplication.PoJo.ProductionExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderItemShowServiceImp implements OrderItemShowService {
    SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    @Override
    public List<Production> proOrderItemShow(String ordercore,int cus_id) {
        ProOrderItemMapper mapper = sqlSession.getMapper(ProOrderItemMapper.class);
        ProOrderItemExample proOrderItemExample = new ProOrderItemExample();
        ProOrderItemExample.Criteria criteria = proOrderItemExample.createCriteria();
        criteria.andCusIdEqualTo(cus_id);
        criteria.andOrdercodeEqualTo(ordercore);
        List<ProOrderItem> proOrderItems = mapper.selectByExample(proOrderItemExample);
        ProductionMapper productionMapper = sqlSession.getMapper(ProductionMapper.class);
        ProductionExample productionExample = new ProductionExample();
        ProductionExample.Criteria criteria1 = productionExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (ProOrderItem proOrderItem : proOrderItems) {
            list.add(proOrderItem.getpId());
        }
        criteria1.andProIdIn(list);
        List<Production> list1 = productionMapper.selectByExample(productionExample);
        sqlSession.close();
        sqlSession=MybatisInitial.getSqlSessionFactory().openSession();
        return list1;
    }
}
