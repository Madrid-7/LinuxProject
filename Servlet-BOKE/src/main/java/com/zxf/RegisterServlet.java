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
 * @date ：2021-03-24 19:51
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 读取用户提交的信息
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. 验证用户提交信息的合法性
        if (username == null || username.equals("")) {
            System.out.println("用户名必须填写");
            resp.sendRedirect("/register.html");
            return;
        }

        // TODO: 其他验证，这步可以在前端页面限制输入

        // 3. 保存到 users 表中
        User user = User.insert(username, password);

        // TODO:插入失败的处理

        // 4. 利用 Session 进行用户登录
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        // 5. 跳转到发表文章页面
        resp.sendRedirect("/publish.jsp");
    }
}
