package com.zxf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = UserTable.select(username, password);
        resp.setContentType("text/plain; charset=utf-8");
        if (user == null) {
            resp.getWriter().println("认证失败");
        } else {
            //设置Session信息
            //把用户对象直接保存到Session中
            //API提供的Session, 会自动种下Cookie
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.getWriter().println("认证成功");
        }
    }
}
