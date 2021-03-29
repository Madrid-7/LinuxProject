package com.zxf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author ：ZXF
 * @program: JavaEE
 * @description:
 * @date ：2021-03-27 22:46
 */

public class Person {

    // 自动装配
    @Autowired
    @Qualifier(value = "cat")   //  这个用来指定对象
    private Cat cat;


//    // required == false 则说明这个对象可以为 null
//    // 默认是 byType ？？
//    @Autowired(required = false)
//    private Dog dog;

    // Java 原生注解类 ，功能相对更高级， 默认 byName 如果找不到则 byType
    @Resource(name = "dog")
    private Dog dog;

    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
