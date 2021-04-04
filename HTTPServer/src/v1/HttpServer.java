package v1;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：ZXF
 * @program: HTTPServer
 * @description:
 * @date ：2021-03-31 16:24
 */

public class HttpServer {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8080);
//
//        while (true) {
//
//            Socket socket = serverSocket.accept();
//
//            new Thread(new RequestResponseTesk(socket)).start();
//        }
//    }

    static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {

            Socket socket = serverSocket.accept();

            Runnable task = new RequestResponseTesk(socket);
            threadPool.execute(task);
        }
    }
}
