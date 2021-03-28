package com.zxf.demo04;

import com.zxf.demo02.UserService;
import com.zxf.demo02.UserServiceImpl;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 11:31
 */

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();

        proxy.add();
    }
}
