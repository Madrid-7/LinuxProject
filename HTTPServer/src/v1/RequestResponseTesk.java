package v1;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @author ：ZXF
 * @program: HTTPServer
 * @description:
 * @date ：2021-03-31 17:14
 */

public class RequestResponseTesk implements Runnable {

    private final Socket socket;

    public RequestResponseTesk(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            System.out.println("建立");
            //

            // 直接写回响应
            Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            PrintWriter printWriter = new PrintWriter(writer);


            // 写响应
            // 响应行
            printWriter.printf("HTTP/1.0 200 OK\r\n");
            // 写响应头
            printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
            // 写入空行，代表响应头结束
            printWriter.printf("\r\n");
            // 写响应体回去，html 内容
            printWriter.printf("<h1>你好世界</h1>");

            printWriter.flush();
        } catch (IOException e) {
            // 因为单次的请求响应周期错误，不应该影响其他请求响应周期
            // 所以。我们只做打印，不终止进程
            e.printStackTrace(System.out);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
