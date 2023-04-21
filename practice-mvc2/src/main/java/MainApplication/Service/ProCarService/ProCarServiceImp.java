package MainApplication.Service.ProCarService;
import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProCarMapper;
import MainApplication.PoJo.ProCar;
import MainApplication.PoJo.ProCarExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProCarServiceImp implements ProCarService{
    SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    @Override
    public boolean subPro(ProCar proCar) {
        ProCarMapper mapper = sqlSession.getMapper(ProCarMapper.class);

        ProCarExample proCarExample = new ProCarExample();
        ProCarExample.Criteria criteria = proCarExample.createCriteria();
        criteria.andPIdIn(Collections.singletonList(proCar.getpId()));
        List<ProCar> proCars = mapper.selectByExample(proCarExample);
        if (proCars.size()==0){
            mapper.insert(proCar);
        }else {
           int totalNum = proCars.get(0).getNum()+proCar.getNum();
           proCar.setNum(totalNum);
            mapper.updateByExample(proCar,proCarExample);
        }

        sqlSession.commit();
        sqlSession.close();
        sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
        return true;
    }
    @Override
    public List<ProCar> readProByCookie(ProCar proCar) {
        ProCarMapper mapper = sqlSession.getMapper(ProCarMapper.class);
        ProCarExample proCarExample = new ProCarExample();
        ProCarExample.Criteria criteria = proCarExample.createCriteria();
        criteria.andCusIdEqualTo(proCar.getCusId());
        List<ProCar> proCars = mapper.selectByExample(proCarExample);
        sqlSession.clearCache();
//        sqlSession.close();
//        sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
        return proCars;
    }

    @Override
    public void deletePro(int[] pro_id) {
        ProCarMapper proCarMapper = sqlSession.getMapper(ProCarMapper.class);
        ProCarExample proCarExample = new ProCarExample();
        ProCarExample.Criteria criteria = proCarExample.createCriteria();
        List<Integer> list = new ArrayList<>();
        for (int i : pro_id) {
            list.add(i);
        }
        criteria.andPIdIn(list);
        proCarMapper.deleteByExample(proCarExample);
        sqlSession.commit();
        sqlSession.close();
        sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    }
}
