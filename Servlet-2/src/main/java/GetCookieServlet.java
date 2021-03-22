import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-21 23:41
 */

@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
// 获取与该域相关的 Cookies 的数组
        cookies = request.getCookies();
// 设置响应内容类型
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String title = "Reading Cookies Example";
        String docType =
                "<!doctype html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" );
        if( cookies != null ){
            out.println("<h2>查找 Cookies 名称和值</h2>");
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                out.print("名称:" + cookie.getName( ) + ",");
                out.print("值:" + cookie.getValue( )+" <br/>");
            }
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
