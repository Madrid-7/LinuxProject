package com.zxf.demo01;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 10:07
 */

public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
