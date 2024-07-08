package summary20240510;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ErrorLog {

    public static void whiteLogException(RuntimeException e){
        try (
                FileWriter fileWriter = new FileWriter("errors.log", true);
                PrintWriter printWriter = new PrintWriter(fileWriter);)
        {

           Date currentTime = new Date();
            printWriter.print("Error: " + currentTime + " ");
           e.printStackTrace(printWriter);


        } catch (IOException ignore) {

        }
    }
    public static void main(String[] args) {
        try {
            int result = 1 / 0;
        } catch (RuntimeException e){
            whiteLogException(e);
        }
    }
}
