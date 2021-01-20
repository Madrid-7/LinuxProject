package io;

import java.io.File;
import java.sql.SQLOutput;

public class FileDemo {
    public static void main(String[] args) {
        {
            //文件存在
            testFile("/home/distance/Project/LinuxProject/Java_IO/src/Test.java");

            //文件不存在
            testFile("/home/distance/Project/LinuxProject/Java_IO/src/NoSuchFile.java");

            //文件夹
            testFile("/home/distance");


        }
    }

    private static void testFile(String path) {
        File file = new File(path);
        System.out.println(file);

        //属性的方法
        System.out.println("路径的文件是否存在：" + file.exists());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("父节点：" + file.getParent());
        System.out.println("文件名称：" + file.getName());
        System.out.println("路径：" + file.getPath());

        //判断是否是文件夹
        System.out.println("是否为文件夹：" + file.isDirectory());
        System.out.println("是否为普通文件：" + file.isFile());

        //其他
        System.out.println("是否为隐藏文件:" + file.isHidden());
        System.out.println("是否绝对路径：" + file.isAbsolute());
        System.out.println("是否有权限读：" + file.canRead());
        System.out.println("是否有权限写：" + file.canWrite());
        System.out.println("是否可执行：" + file.canExecute());

    }
}
