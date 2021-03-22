package com.zxf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-21 17:55
 */

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    private void printMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().println(req.getMethod());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printMethod(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printMethod(req, resp);
    }
}
