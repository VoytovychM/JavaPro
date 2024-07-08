package lesson20240429;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ExampleIOStream {
    public static void main(String[] args) {
        // OutputStream, InputStream - byte stream (read, white, available)
        // Reader, Writer - char stream (read, white, available)

        // System.out
        System.out.println("Hello");
        PrintStream out = System.out;
        out.println("Hello again");
        System.out.println("");
        System.out.print("");
        System.out.printf("");
        int x = 100;
        System.out.printf("Print integer x = %d\n ", x);
        float y = 3.14f;
        float pi =(float) Math.PI;
        System.out.printf("Formatted float y = %.6f\n", y);

        Date date = new Date();
        System.out.printf("date");
        System.out.printf("Hours %tH: minutes %tM : seconds %tS \n", date, date, date);
        LocalDate now = LocalDate.now();
        System.out.printf("now \n");

        // System.in

        Scanner scanner = new Scanner(System.in);

        // System.err - stream for error
        PrintStream err = System.err;
        err.println("Hello error");

    }

}
