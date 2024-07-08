package lesson20240429;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleFileOutputStream {
    public static void main(String[] args) {
        String path = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/fileOUT.txt";
        String text = "Text to file";


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            char[] chars = text.toCharArray();
            for (char temp : chars){
                fileOutputStream.write(temp);
            }
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println("We have some problems with file " + exception.getMessage());

        }
    }
}
