package test;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String srcPath = "xx.jpg";
        String destPath = "madrid.jpg";

        // 1. 判断原文件是否存在
        File srcFile = new File(srcPath);
        if (!srcFile.exists()) {
            System.out.println("原文件不存在，" + srcPath);
            return;
        }

        if (srcFile.isDirectory()) {
            System.out.println("原文件是目录，" + srcPath);
        }

        // 2. 判断目标文件
        File destFile = new File(destPath);
        if (destFile.exists()) {
            System.out.println("目标文件已存在，" + destPath);
            return;
        }

        // 3. 准备复制 - 以二进制形式复制
        // 一次读 4K 数据，把 4K 数据写入到目标文件中
        try (InputStream is = new FileInputStream(srcFile)) {
            try (OutputStream os = new FileOutputStream(destFile)) {
                byte[] buffer = new byte[4096];

                int len;
                while ((len = is.read(buffer, 0, 4096)) != -1) {
                    os.write(buffer, 0, len);
                }
                os.flush();
            }
        }
    }
}
