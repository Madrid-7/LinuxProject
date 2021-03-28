package com.zxf.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-28 23:13
 */

public class LoginInterceptor implements HandlerInterceptor {
    //  Controller 接收客户端请求，匹配到路径，并拦截到，进入方法之前的逻辑
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null) { //有登陆
            //权限校验
            //if(权限通过)
            return true;
            //else
//            response.setStatus(HttpStatus.FORBIDDEN.value());   //403
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());  //401

        response.sendRedirect("/login.html");
        return false;
    }

    // Controller 方法执行完，之后的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
