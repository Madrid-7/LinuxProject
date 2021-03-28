import com.zxf.config.con;
import com.zxf.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 09:01
 */

public class Test {

    public static void main(String[] args) {
//        使用了配置类的方式，就要用 AnnotationConfigApplicationContext 获取
        ApplicationContext context = new AnnotationConfigApplicationContext(con.class);

        User getUser = (User) context.getBean("getUser");
        System.out.println(getUser.getName());
    }
}
