package com.zxf.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 08:55
 */

@Component
public class User {

    @Autowired
    @Qualifier("getDog")
    public Dog dog;

    private String name;

    public String getName() {
        return name;
    }

    @Value("ZXF")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
