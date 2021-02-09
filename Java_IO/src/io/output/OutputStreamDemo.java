package io.output;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        try (OutputStream os = new FileOutputStream("out.txt")) {

            //单字符写入
//            os.write('H');
//            os.write('e');
//            os.write('l');
//            os.write('l');
//            os.write('o');
//            os.write(0x0A);
//
//            os.flush();

            //多字符写入
//            byte[] buffer = {'H','e','l','l','o','!',0x0A};
//            os.write(buffer, 0, buffer.length);
//            os.flush();

            //String写入
//            String s = "怎么说吸血，怎么说？";
//            byte[] buffer = s.getBytes(StandardCharsets.UTF_8);
//            os.write(buffer, 0, buffer.length);
//            os.flush();

//            try (Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
//                writer.append("writer写入。");
//                writer.flush();
//            }


            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))) {
                for (int i = 0; i < 10; i++) {
                    writer.printf("%02d: 吸血怎么说，吸血\n", i);
                }
                writer.flush();
            }
        }
    }
}
