import com.zxf.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-27 22:52
 */

public class Test {
    @org.junit.Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Person people = context.getBean("people", Person.class);
        people.getCat().woof();
        people.getDog().woof();
    }
}
