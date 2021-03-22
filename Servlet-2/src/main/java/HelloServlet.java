/**
 * @author ：ZXF
 * @program: Servlet-1
 * @description: test
 * @date ：2021-03-17 19:25
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
// 扩展 HttpServlet 类

public class HelloServlet extends HttpServlet {
    // 处理 GET 方法请求的方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置刷新自动加载时间为 1 秒
        response.setIntHeader("Refresh", 1); //设置一个带有给定的名称和整数值的响应报头。
        // 设置响应内容类型
        response.setContentType("text/html");
        // Get current time
        Calendar calendar = new GregorianCalendar();//获取当前系统时间
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);//获得时
        int minute = calendar.get(Calendar.MINUTE);//获得分
        int second = calendar.get(Calendar.SECOND);//获得秒
        if(calendar.get(Calendar.AM_PM) == 0) //判定是否是上午和下午
            am_pm = "AM";
        else
            am_pm = "PM";
        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
        PrintWriter out = response.getWriter();
        String title = "auto refresh Header set";
        String docType = "<!doctype html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body>\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>current time: " + CT + "</p>\n");
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
