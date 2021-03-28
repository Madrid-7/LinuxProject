import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：ZXF
 * @program: JavaEE
 * @description:
 * @date ：2021-03-27 19:27
 */

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user1 = (User) context.getBean("user1");

        User user2 = (User) context.getBean("user2");

        User user3 = (User) context.getBean("user3");

    }
}
