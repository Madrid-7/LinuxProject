package com.zxf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：ZXF
 * @program: Servlet-BOKE
 * @description:
 * @date ：2021-03-25 00:04
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 读取用户提交的信息
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. 验证用户提交信息的合法性
        if (username == null) {
            System.out.println("用户名必须填写");
            resp.sendRedirect("/register.html");
            return;
        }

        // 3. 从 MySQL 中查询登录的用户
        User user = User.getByUsernameAndPassword(username, password);
        if (user == null) {
            resp.sendRedirect("/login.html");
            return;
        }

        // 4. 写入 Session 中，登陆成功
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        // 5. 登陆成功，跳转
        resp.sendRedirect("/publish.jsp");
    }
}
