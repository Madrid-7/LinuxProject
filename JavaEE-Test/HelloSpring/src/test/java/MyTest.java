import com.zxf.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author ：ZXF
 * @program: JavaEE
 * @description:
 * @date ：2021-03-27 00:12
 */

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Hello hello = (Hello) context.getBean("hello");

        System.out.println(hello.getStr());
    }
}
