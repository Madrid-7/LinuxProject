package io.input.Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class 从文件输入字节流中读 {
    public static void main(String[] args) throws IOException {
        /*
        InputStream is = new FileInputStream("xx.jpg");
        System.out.println(is);
        is.close();
         */
        try (InputStream is = new FileInputStream("xx.jpg")) {
            // b 的意思有两个： 1.下一个字节   2.标志把文件读完了(End of Stream)
            //int b = is.read();

            byte[] buffer = new byte[1024];
            long len = 0;

            while (true) {
                int read = is.read(buffer);
                // 一次最对读取 1024 字节，把读到的数据，放到 buffer 数组
                // 返回的 read，代表真正读到多少字节

                if (read == -1) {
                    break;
                }
                len += read;
            }
            System.out.println(len);
        }
    }
}
