package com.zxf.tomcat.servlets;

import com.zxf.standard.ServletException;
import com.zxf.standard.http.HttpServlet;
import com.zxf.standard.http.HttpServletRequest;
import com.zxf.standard.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class NotFoundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(404);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>该资源不存在</h1>");
    }
}
