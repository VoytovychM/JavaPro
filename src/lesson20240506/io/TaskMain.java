package lesson20240506.io;

import java.io.*;

public class TaskMain {
    public static void main(String[] args) {

        // Записать 3 бита '101' в файл, считать их.
        File file = new File("resources/binaryData");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        byte b = 5;
        byte b = 0b101;

        try (OutputStream stream = new FileOutputStream(file, true)) {
//            stream.write(new byte[]{b});
            stream.write((int) b);
        } catch (IOException ignore) {
        }


    }
}