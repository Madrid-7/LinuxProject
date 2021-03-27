package com.zxf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author ：ZXF
 * @program: Servlet-BOKE
 * @description:
 * @date ：2021-03-25 00:24
 */

@WebServlet("/publish")
public class PublishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        Part imagePart = req.getPart("image");
        long imageSize = imagePart.getSize();
    }
}
