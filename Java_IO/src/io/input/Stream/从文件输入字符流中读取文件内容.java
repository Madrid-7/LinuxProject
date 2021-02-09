package io.input.Stream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class 从文件输入字符流中读取文件内容 {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("chinese.txt")) {
            try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                //单字符流
//                StringBuilder sb = new StringBuilder();
//                while (true) {
//                    int c = reader.read();
//                    if (c == -1) {
//                        break;
//                    }
//                    sb.append((char)c);
//                }
//                System.out.println(sb.toString());

                //多字符流
//                StringBuilder sb = new StringBuilder();
//                char[] buffer = new char[1024];
//                while (true){
//                    int len = reader.read(buffer);
//                    if (len == -1) {
//                        break;
//                    }
//                    sb.append(buffer, 0, len);
//                }
//                System.out.println(sb.toString());

                //利用 Scanner 封装的方法从流中读取
                try (Scanner sc = new Scanner(reader)) {
                    while (sc.hasNext()) {
                        System.out.println(sc.next());
                    }
                }
            }
        }
    }
}
