import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-21 23:58
 */

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果不存在 session 会话,则创建一个 session 对象
        HttpSession session = request.getSession(true);
// 获取 session 创建时间
        Date createTime = new Date(session.getCreationTime());
// 获取该网页的最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String title = "欢迎回来";
        String visitCountKey = new String("visitCount");
        Integer visitCount = new Integer(0);
        String userIDKey = new String("userID");
        String userID = new String("abcd");
// 检查网页上是否是新的访问者
        if(session.isNew()){
            title = "欢迎来到我的网站";
            session.setAttribute(userIDKey, userID);
        }
        else{
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount++;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,visitCount);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String docType = "<!doctype html>\n";
        out.println(docType + "<html>\n" +
                "<head><title>" +title+ "</title></head>\n" +
                "<body>\n" +
                "<h1>" + title + "</h1>\n"+
                "<h2> Session 信息 </h2>" +
                "<p>" +
                "ID: " + session.getId() + "<hr/><br/>"+
                "Create Time: " + createTime + "<hr/><br/>"+
                "Time of Last Access: " + lastAccessTime + "<hr/><br/>"+"User ID: " + userID + "<hr/><br/>"+
                "Number of visits: " + visitCount + "<hr/><br/>"+
                "</p>"+ "</body>" +
                "</html>");
    }

    @Override
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}