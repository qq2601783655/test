package MainApplication.Service.ProShowService;
import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.ProductionMapper;
import MainApplication.Mapper.ProimgMapper;
import MainApplication.PoJo.Production;
import MainApplication.PoJo.ProductionExample;
import MainApplication.PoJo.Proimg;
import MainApplication.PoJo.ProimgExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProShowServiceImp implements ProShowService {
    SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    @Override
    public List<Production> readProduction() {

        ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
        ProductionExample productionExample = new ProductionExample();
        ProductionExample.Criteria criteria = productionExample.createCriteria();
        criteria.andBIdIsNotNull();
        List<Production> list = mapper.selectByExample(productionExample);
        return list;
    }

    @Override
    public Production readProDataById(int id) {

        ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
        Production production = mapper.selectByPrimaryKey(id);
        return production;
    }

    @Override
    public List<Proimg> readProImgByPid(int pid) {

        ProimgMapper mapper = sqlSession.getMapper(ProimgMapper.class);
        ProimgExample proimgExample = new ProimgExample();
        ProimgExample.Criteria criteria = proimgExample.createCriteria();
        criteria.andPIdEqualTo(pid);
        List<Proimg> proimgs = mapper.selectByExample(proimgExample);
        return proimgs;
    }
}
