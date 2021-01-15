package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先判断用户是否登录过
        //判断Session中是否可以查到指定用户对象
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        resp.setContentType("text/plain; charset=utf-8");
        if(user == null) {
            //未登陆过
            resp.sendRedirect("/login.html");
        } else {
            resp.getWriter().println(user.username);
            resp.getWriter().println(user.nickname);
            resp.getWriter().println(user.balance);
        }
    }
}
