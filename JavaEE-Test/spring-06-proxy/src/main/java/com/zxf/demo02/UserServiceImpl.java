package com.zxf.demo02;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 10:39
 */

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void query() {
        System.out.println("query");
    }
}
