package com.zxf.demo03;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 11:25
 */

public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setRent(host);

        Rent rent = (Rent) pih.getProxy();

        rent.rent();

    }
}
