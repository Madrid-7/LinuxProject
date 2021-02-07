package io.file;

import java.io.File;
import java.util.Scanner;

public class MakeDirectory {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        File file = new File("NewDir");
        System.out.println("创建对象");
        sc.nextLine();
        file.mkdir();
//        file.mkdirs();   创建多级目录
        System.out.println("文件夹创建成功");
        sc.nextLine();
        System.out.println("文件夹删除");
        delete();
        sc.nextLine();
    }

    public static void delete() {
        File file = new File("NewDir");
        file.delete();
    }
}
