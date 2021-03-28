package com.zxf.diy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author ：ZXF
 * @program: spring-03-Autowired
 * @description:
 * @date ：2021-03-28 14:45
 */

@Aspect  // 标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.zxf.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("-----执行前-----");
    }
}
