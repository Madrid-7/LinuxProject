package com.zxf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
}
