package com.zxf.standard.http;

import com.zxf.standard.ServletRequest;

public interface HttpServletRequest extends ServletRequest {
    Cookie[] getCookies();

    String getHeader(String name);

    String getMethod();

    String getContextPath();
    String getServletPath();
    String getRequestURI();

    HttpSession getSession();
}
