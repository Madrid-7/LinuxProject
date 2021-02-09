package test;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DirectoryCopy {
    // 利用线程池提交任务的形式提升速度
    private static class CopyFileTesk implements Runnable {
        private final String srcPath;
        private final String destPath;

        CopyFileTesk(String srcPath, String destPath) {
            this.srcPath = srcPath;
            this.destPath = destPath;
        }

        @Override
        public void run() {
            try {
                copyFile(srcPath, destPath);
                System.out.println(destPath + "--> file copy successful");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String srcAbsPath;
    private static String destAbsPath;
    private static ExecutorService theadPool;

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("请在使用时附带如下参数：");
            System.out.println("DirectoryCopy 源目录 目标目录");
            return;
        }

        theadPool = Executors.newFixedThreadPool(20);

        String srcPath = args[0];
        String destPath = args[1];
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        srcAbsPath = srcFile.getAbsolutePath();
        destAbsPath = destFile.getAbsolutePath();

        // TODO: 检查源文件是否存在，是否是目录
        // TODO: 检查目标文件是否不存在
        // TODO: 检查目标文件的上一级目录是否存在

        directoryCopy(srcPath, destPath);

        theadPool.shutdown();
    }

    /**
     * 遍历所有的目录结构
     * 如果是目录，我也随着创建目录
     * 如果是文件，调用复制文件的方式进行复制
     * @param srcPath
     * @param destPath
     * @throws IOException
     */
    private static void directoryCopy(String srcPath, String destPath) throws IOException {
        File srcRoot = new File(srcPath);
        dfsDir(srcRoot);
    }

    private static void doDir(File dir) {
        String srcPath = dir.getAbsolutePath();
        String relativePath = srcPath.substring(srcAbsPath.length());
        String destPath = destAbsPath + relativePath;

        File destDir = new File(destPath);
        destDir.mkdir();         // 因为文件树从上往下遍历，所以，上一级的目录一定被创建了
        System.out.println(destPath + "--> dir create successful");
    }

    private static void doFile(File file) throws IOException {
        String srcPath = file.getAbsolutePath();
        String relativePath = srcPath.substring(srcAbsPath.length());
        String destPath = destAbsPath + relativePath;

        theadPool.execute(new CopyFileTesk(srcPath, destPath));
//        copyFile(file.getAbsolutePath(), destPath);
//        System.out.println(destPath + "--> file copy successful");
    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        try (InputStream is = new FileInputStream(srcPath)) {
            try (OutputStream os = new FileOutputStream(destPath)) {
                byte[] buffer = new byte[4096];
                int len;

                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer, 0, len);
                }
                os.flush();
            }
        }
    }

    private static void doNode(File node) throws IOException {
        if (node.isDirectory()) {
            doDir(node);
        } else {
            doFile(node);
        }
    }

    private static void dfsDir(File root) throws IOException {
        doNode(root);  //被遍历的每个节点，都需要被调用

        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File f : files) {
                    dfsDir(f);
                }
            }
        }
    }
}
