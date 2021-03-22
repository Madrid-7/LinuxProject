/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-22 00:33
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/upload")
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        //具体上传上来的文件放在什么地方,由自己决定
        File path = new File("/home/distance");
        //获取文件,文件在html中的name是“file”
        Part img = request.getPart("file");
        //制作文件全路径
        String filePath = path.getPath() + File.separator + img.getSubmittedFileName();
        //获取成功之后,写入指定路径
        img.write(filePath);
        //显示到标准输出
        System.out.println("file Upload: " + filePath);
        //同样的信息,显示给用户浏览器
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("file Upload: " + filePath);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {//上传文件,不能用GET方法
        System.out.println("上传文件只能用POST方法!");
    }
}
