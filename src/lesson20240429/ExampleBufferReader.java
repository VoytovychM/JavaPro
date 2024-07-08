package lesson20240429;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleBufferReader {
    public static void main(String[] args) {
        String pathFrom = "/Users/maria/IdeaProjects/JavaPro/src/lesson20240429/custom/fileFromCopy.txt";
        List<String > strings = new ArrayList<>();
        try{
//            BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom)));
            FileInputStream inputStream = new FileInputStream(pathFrom);
            // InputStreamReader - convert bytes to char
            Reader reader = new InputStreamReader(inputStream);
            //Buffered - read use buffer
            BufferedReader bufferedReader = new BufferedReader(reader);
            strings.add(bufferedReader.readLine());

            while(bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }

        } catch (IOException exception){
            System.out.println("Problem with file work " + exception.getMessage());
        }
    }
}
