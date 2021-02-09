package test;

import java.io.*;

public class IConv {
    public static void main(String[] args) throws IOException {

        if (args.length < 4) {
            System.out.println("请在使用时附带如下参数：");
            System.out.println("IConv 源字符集 目标字符集 源文件 目标文件");
            return;
        }

        String fromCharset = args[0];
        String toCharset = args[1];
        String fromPath = args[2];
        String toPath = args[3];

        try (Reader reader = new InputStreamReader(new FileInputStream(fromPath), fromCharset)) {
            try (Writer writer =new OutputStreamWriter(new FileOutputStream(toPath), toCharset)) {
                char[] buffer = new char[4096];
                int len;

                while ((len = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, len);
                }
                writer.flush();
            }
        }
    }
}
