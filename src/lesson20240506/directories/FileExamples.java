package lesson20240506.directories;

import java.io.File;

public class FileExamples {

    public static void main(String[] args) {
        File file = new File("resources/newFile.txt");

        File directory = new File("resources/dir");
        directory.mkdir();
        System.out.println(directory.exists());

        System.out.println(file.length());
    }
}
