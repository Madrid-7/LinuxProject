package com.zxf.webapps.dictionary;

import com.zxf.standard.ServletException;
import com.zxf.standard.http.HttpServlet;
import com.zxf.standard.http.HttpServletRequest;
import com.zxf.standard.http.HttpServletResponse;
import com.zxf.standard.http.HttpSession;

import java.io.IOException;

public class ProfileActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.html");
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().println(user.toString());
        }
    }
}
