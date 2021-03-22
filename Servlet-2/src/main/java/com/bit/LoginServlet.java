package com.bit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-22 23:01
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = UserTable.select(username, password);
        resp.setContentType("text/plain; charset=utf-8");
        if (user == null) {
            resp.getWriter().println("用户认证失败。。。");
        } else {
            //设置 Session 信息
            //把用户对象直接保存到 Session
            //API 提供的 Session，会自动种下 Cookie
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.getWriter().println("用户认证成功。。");
        }
    }
}
