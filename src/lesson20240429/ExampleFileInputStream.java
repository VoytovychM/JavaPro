package lesson20240429;

import java.io.FileInputStream;
import java.io.IOException;

public class ExampleFileInputStream {
    public static void main(String[] args) {
        String path = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/file.txt";
        // -> HELLO read
       // H -> ELLO read

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
//            int data = fileInputStream.read();
////            while(data != -1) {
////                System.out.print((char)data);
////                data = fileInputStream.read();
////
////            }

            while(fileInputStream.available() > 0){
                System.out.print((char)fileInputStream.read() + " ");

            }


//       } catch (FileNotFoundException exception) {
//           System.out.printf("File not found please try again", path);
//       } catch (IOException exception){
//           System.out.println("Problem with access to file " + exception.getMessage());
//       }
            fileInputStream.close();
        } catch (IOException exception) {
            System.out.println("We have problem with file " + exception.getMessage());
        }
        System.out.println("\nend of application");
    }
}