package io.input.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MoveFile {
    public static void main(String[] args) throws IOException {

        File file = new File("Test.txt");
        File dest = new File("out/Test.txt");
        file.createNewFile();
        new Scanner(System.in).nextLine();
        file.renameTo(dest);
    }
}
