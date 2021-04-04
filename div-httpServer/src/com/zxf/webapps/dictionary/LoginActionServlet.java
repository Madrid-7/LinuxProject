package com.zxf.webapps.dictionary;

import com.zxf.standard.ServletException;
import com.zxf.standard.http.HttpServlet;
import com.zxf.standard.http.HttpServletRequest;
import com.zxf.standard.http.HttpServletResponse;
import com.zxf.standard.http.HttpSession;

import java.io.IOException;

public class LoginActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("ZXF") && password.equals("123")) {
            User user = new User(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("profile-action");
        } else {
            resp.sendRedirect("login.html");
        }
    }
}
