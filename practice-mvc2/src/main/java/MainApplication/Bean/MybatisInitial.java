package MainApplication.Bean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
public class MybatisInitial {
    private static SqlSession sqlSession = null;
    private static SqlSessionFactory sqlSessionFactory = null;

    private MybatisInitial(){
        initial();
    }
    private void initial() {

    }
    public static SqlSessionFactory getSqlSessionFactory() {
        try {
            String resource ="mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSessionFactory = build;
        } catch (IOException e) {
            System.err.println("mybatis初始化失败");
            throw new RuntimeException(e);
        }
        return sqlSessionFactory;
    }

}
