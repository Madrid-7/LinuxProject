package com.zxf.config;

import com.zxf.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-28 22:49
 */

@Configuration
public class MyConfig implements WebMvcConfigurer {


    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  // **代表所有子路径，* 只匹配一级子路径  添加的路劲
                .excludePathPatterns("/login5", "/login.html");  // 排除的路径
    }

    @Bean
    public User user1() {
        User user = new User();
        user.setUsername("XFFFF");
        user.setPassword("654321");
        user.setBirthday(new Date());
        return user;
    }

    @Bean
    public User user2(@Qualifier("user1") User user1) {
        System.out.println(user1);
        User user = new User();
        user.setUsername("ZXF");
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }
}
