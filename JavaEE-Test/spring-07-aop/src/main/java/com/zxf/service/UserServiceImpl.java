package com.zxf.service;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 13:16
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
    public void select() {
        System.out.println("select");
    }
}
