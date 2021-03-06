package com.zxf.tomcat;

import com.zxf.standard.Servlet;
import com.zxf.standard.ServletException;
import com.zxf.tomcat.ConfigReader;
import com.zxf.tomcat.Context;
import com.zxf.tomcat.RequestResponseTask;
import com.zxf.tomcat.servlets.DefaultServlet;
import com.zxf.tomcat.servlets.NotFoundServlet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    public static DefaultServlet defaultServlet = new DefaultServlet();
    public static NotFoundServlet notFoundServlet = new NotFoundServlet();


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        // 1. 找到所有的 Servlet 对象，进行初始化
        initServer();

        // 2. 处理服务器逻辑
        startServer();

        // 3. 找到所有的 Servlet 对象，进行销毁
        destroyServer();
    }

    private static void startServer() throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);

        // 2. 每次循环，处理一个请求
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable task = new RequestResponseTask(socket);
            threadPool.execute(task);
        }

    }

    private static void destroyServer() {
        defaultServlet.destroy();
        notFoundServlet.destroy();

        for (Context context : contextList) {
            context.destroyServlets();
        }
    }

    private static void initServer() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, ServletException {
        // 第一步：扫描出所有个 contexts
        scanContexts();
        // 第二步：解析每个 Context 下的配置文件
        parseContextConf();
        // 第三步：加载每个 Servlet 类
        loadServletClasses();
        // 第四步：实例化每个 servlet 对象
        instantiateServletObjects();
        // 第五步：执行每个 servlet 对象的初始化
        initializeServletObjects();
    }

    private static void initializeServletObjects() throws ServletException {
        System.out.println("第五步：执行每个 servlet 对象的初始化");
        for (Context context : contextList) {
            context.initServletObjects();
        }

        defaultServlet.init();
        notFoundServlet.init();
    }

    private static void instantiateServletObjects() throws InstantiationException, IllegalAccessException {
        System.out.println("第四步：实例化每个 servlet 对象");
        for (Context context : contextList) {
            context.instantiateServletObjects();
        }
    }

    private static void loadServletClasses() throws ClassNotFoundException {
        System.out.println("第三步：加载每个 Servlet 类");
        for (Context context : contextList) {
            context.loadServletClasses();
        }
    }

    private static void parseContextConf() throws IOException {
        System.out.println("第二步：解析每个 Context 下的配置文件");
        for (Context context : contextList) {
            context.readConfigFile();
        }
    }

    public static final String WEBAPPS_BASE = "/home/distance/LinuxProject/div-httpServer/webapps";
    public static final List<Context> contextList = new ArrayList<>();
    private static final ConfigReader configReader = new ConfigReader();
    public static final DefaultContext defaultContext = new DefaultContext(configReader);
    private static void scanContexts() {
        System.out.println("第一步：扫描出所有个 contexts");
        File webappsRoot = new File(WEBAPPS_BASE);
        File[] files = webappsRoot.listFiles();
        if (files == null) {
            throw new RuntimeException();
        }

        for (File file : files) {
            if (!file.isDirectory()) {
                // 不是目录，就不是 web 应用
                continue;
            }

            String contextName = file.getName();
            System.out.println(contextName);
            Context context = new Context(configReader, contextName);

            contextList.add(context);
        }
    }
}
