package com.zxf.demo01;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 10:08
 */

public class Client {
    public static void main(String[] args) {
        //房东要出租房子
        Host host = new Host();
        //代理，中介帮房东出租，但是代理还会有一些附属操作
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
