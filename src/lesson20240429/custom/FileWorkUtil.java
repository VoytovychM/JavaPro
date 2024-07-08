package lesson20240429.custom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWorkUtil {
    public static void copy(String from, String to) {
        try {
            FileInputStream fileInputStream = new FileInputStream(from);
            FileOutputStream fileOutputStream = new FileOutputStream(to);
            while (fileInputStream.available() > 0) {
                fileOutputStream.write(fileInputStream.read());
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println("Problem with file work:" + exception.getMessage());
        }
    }
}