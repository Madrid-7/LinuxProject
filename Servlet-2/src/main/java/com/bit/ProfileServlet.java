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
 * @date ：2021-03-22 23:17
 */

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        resp.setContentType("text/plain; charset=utf-8");
        if (user == null) {
            //resp.sendRedirect("/login.html");
            resp.getWriter().println("用户没有认证。。。");
        } else {
            resp.getWriter().println(user.username);
            resp.getWriter().println(user.nickname);
            resp.getWriter().println(user.balance);
        }

    }
}
