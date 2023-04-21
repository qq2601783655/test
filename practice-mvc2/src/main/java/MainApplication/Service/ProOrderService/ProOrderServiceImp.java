package MainApplication.Service.ProOrderService;
import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProCarMapper;
import MainApplication.Mapper.ProOrderItemMapper;
import MainApplication.Mapper.ProOrderMapper;
import MainApplication.Mapper.ProimgMapper;
import MainApplication.PoJo.ProCar;
import MainApplication.PoJo.ProCarExample;
import MainApplication.PoJo.ProOrder;
import MainApplication.PoJo.ProOrderItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

@Component
public class ProOrderServiceImp implements ProOrderService{
    SqlSession session = MybatisInitial.getSqlSessionFactory().openSession();
    @Autowired
    ProOrderItem proOrderItem;
    @Override
    public void deleteItem(int[] pro_id) {
//        ProCarMapper mapper = session.getMapper(ProimgMapper.class);
//        ProCarExample proCarExample = new ProCarExample();
//        ProCarExample.Criteria criteria = proCarExample.createCriteria();
//        for (int i : pro_id) {
//            criteria.andPIdEqualTo(i);
//        }
//
//        int i =mapper.deleteByExample(proCarExample);
//        session.commit();
    }
//    提交订单
    @Override
    public void OrderItemGenerate(int[] pro_num,int[] pro_id,ProOrder proOrder) {
        ProOrderMapper mapper = session.getMapper(ProOrderMapper.class);
        ProOrderItemMapper mapper1 = session.getMapper(ProOrderItemMapper.class);
        ProCarMapper mapper2 = session.getMapper(ProCarMapper.class);

        Date date = new Date();
        String uuid = UUID.randomUUID().toString();
        proOrder.setOrdercode(uuid);
        proOrder.setDeliverydate(date);
        mapper.insert(proOrder);


        proOrderItem.setCusId(proOrder.getCusId());
        proOrderItem.setOrdercode(uuid);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < pro_id.length; i++) {
            proOrderItem.setNum(pro_num[i]);
            proOrderItem.setpId(pro_id[i]);
            mapper1.insert(proOrderItem);
            list.add(pro_id[i]);
        }
        ProCarExample proCarExample = new ProCarExample();
        ProCarExample.Criteria criteria = proCarExample.createCriteria();
        criteria.andCusIdEqualTo(proOrder.getCusId());
        criteria.andPIdIn(list);
        int i = mapper2.deleteByExample(proCarExample);
        session.commit();
        session.close();
        session=MybatisInitial.getSqlSessionFactory().openSession();

    }
}
