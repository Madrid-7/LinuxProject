package test;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class 遍历目录下的所有文件 {
    public static void main(String[] args) {
        String path = ".";
        File root = new File(path);

        DFS(root);
        System.out.println("======================================");
        BFS(root);
    }

    private static void BFS(File root) {
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            File file = queue.poll();
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f :
                            files) {
                        queue.offer(f);
                    }
                }
            }
        }
    }

    private static void DFS(File root) {
        System.out.println(root.getAbsolutePath());
        //root is not dir OR root is empty -> end
        if (root.isFile()) {
            return;
        }
        if (!root.isDirectory()) {
            return;
        }
        File[] files = root.listFiles();
        if (files == null) {
            return;
        }
        if (files.length == 0) {
            return;
        }
        for (File file : files) {
            DFS(file);
        }
    }
}
