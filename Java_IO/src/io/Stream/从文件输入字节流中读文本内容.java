package io.Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class 从文件输入字节流中读文本内容 {
    public static void main1(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("test.txt")) {
            byte[] buffer = new byte[1024];

            int len = is.read(buffer);
//            for (int i = 0; i < len; i++) {
//                System.out.println((char)buffer[i]);
//            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append((char)buffer[i]);
            }
            String str = sb.toString();
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("chinese.txt")) {
            byte[] buffer = new byte[1024];

            int len = is.read(buffer);


            String str = new String(buffer, 0, len, StandardCharsets.UTF_8);
            System.out.println(str);
        }
    }
}
