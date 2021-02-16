package com.zxf;


import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MavenTest
 * @description: 模拟MySQL客户端
 * @date ：2021-02-14 15:39
 */

public class MySQLClient {
    private static String host = "127.0.0.1";
    private static int port = 3306;
    private static String user = null;
    private static String password = "";
    private static String defaultDatabaseName = "test";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        if (args.length == 0) {
            printUsageAndExit();
        }

        parseArguments(args);

        // 1. 连接
        Class.forName("com.mysql.jdbc.Driver");

        String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&charsetEncoding=utf8",
                host, port, defaultDatabaseName);

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            printWelcome();
            try (Scanner sc = new Scanner(System.in)) {

                while (true) {
                    System.out.print("mysql> ");
                    String shell = sc.nextLine();

                    if (shell.equalsIgnoreCase("quit")) {
                        System.out.println("Bye");
                        break;
                    }

                    if (shell.startsWith("select") || shell.startsWith("show")) {
                        executeQuery(connection, shell);
                    } else {
                        executeUpdate(connection, shell);
                    }

                }
            }

        }

    }

    private static void executeUpdate(Connection connection, String shell) {

    }

    private static void executeQuery(Connection connection, String shell) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(shell);
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {

            for (int i = 0; i < columnCount; i++) {
                String value = resultSet.getString(1 + i);
                System.out.print(value + ",");
                System.out.println();
            }
        }
    }

    private static void printWelcome() {
        System.out.println("Welcome to the MySQL monitor.  Commands end with ; or \\g.\n" +
                "Your MySQL connection id is 17\n" +
                "Server version: 8.0.23-0ubuntu0.20.04.1 (Ubuntu)\n" +
                "\n" +
                "Copyright (c) 2000, 2021, Oracle and/or its affiliates.\n" +
                "\n" +
                "Oracle is a registered trademark of Oracle Corporation and/or its\n" +
                "affiliates. Other names may be trademarks of their respective\n" +
                "owners.\n" +
                "\n" +
                "Type 'help;' or '\\h' for help. Type '\\c' to clear the current input statement.");
    }

    private static void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {

            String arg = args[i];
            switch (arg) {
                case "--help":
                    printUsageAndExit();
                    break;
                case "-h":
                case "--host":
                    host = args[++i];
                    break;
                case "-P":
                case "--port":
                    port = Integer.parseInt(args[++i]);
                    break;
                case "-u":
                case "--user":
                    user = args[++i];
                    break;
                case "-p":
                case "--password":
                    password = args[++i];
                    break;
                default:
                    printUsageAndExit("不认识的选项：" + arg);
            }
        }
    }

    private static void printUsageAndExit(String... messages) {
        System.out.println("Usage: mysql [OPTIONS] [database]");
        System.out.println(" --help 打印帮助信息");
        System.out.println(" -h, --host 连接主机，默认是 127.0.0.1");
        System.out.println(" -P, --port 连接端口，默认是 3306");
        System.out.println(" -u, --user mysql 用户名，必须设置");
        System.out.println(" -p, --password mysql 密码");

        // stream 的操作, 方法引用
        // 等于下面代码的简单版本
        //Arrays.stream(messages).peek(System.out::println);

        for (String s : messages) {
            System.out.println(s);
        }


    }
}
