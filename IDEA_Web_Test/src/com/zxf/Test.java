package com.zxf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            String method = req.getMethod();
            System.out.println("请求方法" + method + "getMethod()");
        }

        {
            String requestURI = req.getRequestURI();
            System.out.println("完整路径：" + requestURI);
            String servletPath = req.getServletPath();
            System.out.println("排除　ContextPath 的路径" + servletPath);
            String contextPath = req.getContextPath();
            System.out.println("Context Path" + contextPath );
        }

//        {
//            Enumeration<String> parameterNames = req.getParameterNames();
//            while (parameterNames.hasMoreElements()) {
//                String key = resp.getHeaderNames();
//                String value = resp.getHeader(key);
//                System.out.println(key + "+" + value);
//            }
//        }
    }
}
