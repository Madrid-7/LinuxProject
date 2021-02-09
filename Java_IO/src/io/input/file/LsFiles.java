package io.input.file;

import java.io.File;

public class LsFiles {
    public static void main(String[] args) {

        File file = new File(".");
        File[] files = file.listFiles();
        if (files == null){
            System.out.println("error, This is not a dir.");
        }
        if (files.length == 0) {
            System.out.println("This dir is empty.");
        }

        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
