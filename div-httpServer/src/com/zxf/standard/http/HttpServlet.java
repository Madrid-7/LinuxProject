package com.zxf.standard.http;

import com.zxf.standard.Servlet;
import com.zxf.standard.ServletException;
import com.zxf.standard.ServletRequest;
import com.zxf.standard.ServletResponse;

import java.io.IOException;


public abstract class HttpServlet implements Servlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        if (req instanceof HttpServletRequest && resp instanceof HttpServletResponse) {
            HttpServletRequest httpReq = (HttpServletRequest)req;
            HttpServletResponse httpResp = (HttpServletResponse)resp;

            service(httpReq, httpResp);
        } else {
            throw new ServletException("不支持非 HTTP 协议");
        }
    }

    @Override
    public void destroy() {

    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            doGet(req, resp);
        } else {
            resp.sendError(405);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(405);
    }
}

