package com.zxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-28 16:22
 */

@SpringBootApplication
@MapperScan(basePackages = "com.zxf.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
