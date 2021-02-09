package test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CharsetChange {
    public static void main(String[] args) throws IOException {
        String srcPath = "chinese.txt";
        String destPath = "chinese-gbk.txt";

        File srcFile = new File(srcPath);
        if (!srcFile.exists()) {
            System.out.println("文件不存在：" + srcPath);
            return;
        } else if (srcFile.isDirectory()) {
            System.out.println("该文件是目录：" + srcPath);
            return;
        }

        File destFile = new File(destPath);
        if (destFile.exists()) {
            System.out.println("目标文件已存在：" + destPath);
            return;
        }

        try (InputStream is = new FileInputStream(srcFile)) {
            try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                try (Scanner sc = new Scanner(reader)) {
                    try (OutputStream os = new FileOutputStream(destFile)) {
                        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "GBK"))) {
                            while (sc.hasNext()) {
                                String str = sc.nextLine();
                                writer.println(str);
                            }
                        }
                    }
                }
            }
        }
    }
}
