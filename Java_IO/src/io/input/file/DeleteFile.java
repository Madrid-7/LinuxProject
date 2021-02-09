package io.input.file;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("FileTest.txt");

        System.out.println("Create 对象");

        sc.nextLine();
        //file.delete();
        file.deleteOnExit(); //退出时删除

        System.out.println("文件删除成功");

        sc.nextLine();
    }
}
