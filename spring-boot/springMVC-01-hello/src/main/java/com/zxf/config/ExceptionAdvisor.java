package com.zxf.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-29 00:56
 */

// Controller 中，所有客户端处理请求的方法 抛出的异常，都会进入异常处理逻辑
    //  动态代理实现
@ControllerAdvice
public class ExceptionAdvisor {

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Object handle(Exception e) {  // Controller 方法抛出 的异常，会自动注入到请求参数
//        Map<String, String> map = new HashMap<>();
//        map.put("error", e.getMessage());
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        e.printStackTrace(pw);
//        map.put("stackTrace", sw.toString());
//        return map;
//    }

    @ExceptionHandler(Exception.class)
    public Object handle(HttpServletResponse response) {  // Controller 方法抛出 的异常，会自动注入到请求参数

        try {
            response.sendRedirect("/error.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
