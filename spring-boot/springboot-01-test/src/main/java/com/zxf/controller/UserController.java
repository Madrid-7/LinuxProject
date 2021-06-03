package com.zxf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxf.pojo.Person;
import com.zxf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-04-13 18:51
 */

@Controller
public class UserController {


    @Autowired
    Person person = new Person();


    @RequestMapping("/json1")
    @ResponseBody   // 加这个注解就不走视图解析器， 会直接返回字符串
    public String json1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        User user = new User("张心飞1", 12, "男");
        String str = mapper.writeValueAsString(user);

        System.out.println(person.toString());

        return user.toString();
    }
}
