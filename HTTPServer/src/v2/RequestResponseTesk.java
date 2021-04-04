package v2;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: HTTPServer
 * @description:
 * @date ：2021-03-31 17:14
 */

public class RequestResponseTesk implements Runnable {

    private static final String DOC_BASE = "/home/distance/LinuxProject/HTTPServer/docBase";

    private final Socket socket;

    public RequestResponseTesk(Socket socket) {
        this.socket = socket;
    }

    // Map<suffix, contentType>
    private static final Map<String, String> mimeTypeMap = new HashMap<>();
    static {
        mimeTypeMap.put("txt", "text/plain");
        mimeTypeMap.put("html", "text/html");
        mimeTypeMap.put("js", "application/javascript");
        mimeTypeMap.put("jpg", "image/jpeg");
    }

    @Override
    public void run() {

        try {

            System.out.println("建立");
            //

            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            scanner.next();    // 读取出来的是方法

            String path = scanner.next();
            System.out.println(path);

            if (path.equals("/")) {
                // welcome-file
                path = "/index.html";
            }

            String filePath = DOC_BASE + path;    // 用户请求的静态资源对应的路径

            // 判断文件是否存在
            File resource = new File(filePath);
            if (resource.exists()) {
//                  读取文件内容，并写入 response body 中
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                String contentType = "text/plain";
                // 找到路径对应的后缀，（字符串处理）
                if (path.contains(".")) {
                    int i = path.lastIndexOf(".");
                    String suffix = path.substring(i + 1);
                    contentType = mimeTypeMap.getOrDefault(suffix, contentType);
                }
                // 如果 contentType 是 "text/...", 代表是文本
                // 我们都把字符集统一设定成 utf-8
                if (contentType.startsWith("text/")) {
                    contentType= contentType + "; charset=utf-8";
                }

                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: %s\r\n", contentType);
                printWriter.printf("\r\n");
                printWriter.flush();

                // 写入 response body 部分
                try (InputStream resourceInputStream = new FileInputStream(resource)) {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int len = resourceInputStream.read(buffer);
                        if (len == -1) {
                            break;
                        }
                        outputStream.write(buffer, 0, len);
                    }
                    outputStream.flush();
                }

            } else {
//                response 404
                Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                printWriter.printf("HTTP/1.0 404 Not Found\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1>%s 对应资源不存在</h1>", filePath);
                printWriter.flush();
            }


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
