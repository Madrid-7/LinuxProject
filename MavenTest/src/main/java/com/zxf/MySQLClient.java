package com.zxf;

import java.sql.SQLOutput;
import java.util.Arrays;

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

    public static void main(String[] args) {

        if (args.length == 0) {
            printUsageAndExit();
        }

        parseArguments(args);


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
