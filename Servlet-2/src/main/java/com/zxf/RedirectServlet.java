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
 * @date ：2021-03-21 17:51
 */

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(302);
        resp.setHeader("Location", "/success");

    }
}
