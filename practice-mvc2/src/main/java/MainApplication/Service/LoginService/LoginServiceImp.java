package MainApplication.Service.LoginService;

import MainApplication.Bean.MybatisInitial;
import MainApplication.Mapper.CustomerMapper;
import MainApplication.PoJo.Customer;
import MainApplication.PoJo.CustomerExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImp implements LoginService {
    SqlSession sqlSession = MybatisInitial.getSqlSessionFactory().openSession();
    public List loginProcedure(Customer customer){
                CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
                CustomerExample customerExample = new CustomerExample();
                CustomerExample.Criteria criteria = customerExample.createCriteria();
                criteria.andSlatEqualTo(customer.getSlat());
                List<Customer> customers = mapper.selectByExample(customerExample);
                return customers;
            }
        }

