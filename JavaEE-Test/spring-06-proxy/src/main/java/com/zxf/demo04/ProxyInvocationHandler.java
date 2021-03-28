package com.zxf.demo04;

import com.zxf.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 11:04
 */

// 用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        log(method.getName());

        // 动态代理的本质，就是反射实现
        return method.invoke(target, objects);

    }

    private void log(String msg) {
        System.out.println("[debug] : " + msg);
    }
}
