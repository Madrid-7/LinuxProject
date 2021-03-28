package com.zxf.config;

import com.zxf.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 08:56
 */

// 这个也会被 Spring 托管，注册到容器中，他本来就是一个@Component
//    @Configuration 就是代表一个配置类， 相当于 beans.xml
@Configuration
@ComponentScan("com.zxf.pojo")
@Import(con2.class)
public class con {

//    注册一个 bean
//    方法的名字就相当于 bean 标签中的 id 属性
//    这个方法的返回值，就相当于 bean 标签中的 class属性
    @Bean
    public User getUser() {
        return new User();
    }
}
