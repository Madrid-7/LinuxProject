package com.zxf.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 00:24
 */

// Component 组件的意思
@Component
public class User {

    @Value("ZXF")
    private String name;

    @Value("21")
    private int age;

}
