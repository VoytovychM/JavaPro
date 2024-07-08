package lesson20240506.exception;

import java.io.*;

public class ExceptionExamples {
    public static void main(String[] args) {

        // unchecked
//        int value = 1 / 0;

        Object string = "value";
//        String string = null;
//        string.length();

//        Integer integer = (Integer) string; // ClassCastException

        // checked
        try {
            Reader reader = new FileReader("resources/somefile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            System.out.println(bufferedReader.readLine());
//            throw new IOException("file is corrupted");

        } catch (FileNotFoundException | NullPointerException expection) {
//            System.out.println("File not found");
//            System.out.println(expection);
//            System.out.println(expection.getMessage());
//            System.out.println(expection.getCause());
            expection.printStackTrace();
//            throw new RuntimeException("RuntimeException");
        } catch (IOException ex) {
            System.out.println("Problem with reading file: " + ex.getMessage());
        } finally {
            System.out.println("Actions in finally block");
        }


        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println("impossible operation");
            //
        }

        System.out.println("Some other actions");
    }


}

