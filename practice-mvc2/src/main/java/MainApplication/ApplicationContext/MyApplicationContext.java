package MainApplication.ApplicationContext;
import org.springframework.context.ApplicationContext;
public class MyApplicationContext {
    static ApplicationContext context;
    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        MyApplicationContext.context = context;
    }
}
