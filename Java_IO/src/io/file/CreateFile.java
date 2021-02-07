package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //创建的只是对象，没有创建文件
        File file = new File("FileTest.txt");

        System.out.println("File 对象创建成功，输入回车创建文件");
        sc.nextLine();

        file.createNewFile();;
        System.out.println("文件创建成功");
    }
}
