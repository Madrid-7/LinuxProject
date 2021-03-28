package com.zxf.demo02;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 10:41
 */

public class UserServiceProxy {

    private UserServiceImpl proxy;

    public void setProxy(UserServiceImpl proxy) {
        this.proxy = proxy;
    }

    public void add(){
        log("add");
        proxy.add();
    }
    public void delete(){
        log("delete");
        proxy.delete();
    }
    public void update(){
        log("update");
        proxy.update();
    }
    public void query(){
        log("query");
        proxy.query();
    }

    private void log(String msg) {
        System.out.println("[debug] : " + msg);
    }
}
