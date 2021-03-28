package com.zxf.diy;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 14:21
 */

public class DiyPointCut {

    public void before() {
        System.out.println("======执行前======");

    }

    public void after() {
        System.out.println("======执行后======");
    }
}
