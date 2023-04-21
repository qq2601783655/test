package MainApplication;
import MainApplication.ApplicationContext.MyApplicationContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        MyApplicationContext.setContext(run);
//        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
//
//            System.out.println(beanDefinitionName);
//        }


    }



}
