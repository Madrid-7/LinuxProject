package com.zxf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-cookie-by-api")
public class SetCookieByAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("nickname", "rongzhou");
        resp.addCookie(cookie);
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().println("Cookie 已种下");
    }

}
