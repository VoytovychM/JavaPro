package start.summary;

import java.math.BigDecimal;

public class Money {
    public static void main(String[] args) {
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            sum +=0.1;
        }
        System.out.println(sum == 1.0);
        System.out.println(sum);
        BigDecimal bigDecimal = new BigDecimal(0);
        for (int i = 0; i < 10_000; i++) {
            bigDecimal= bigDecimal.add(new BigDecimal("0.1"));
            

        }
        System.out.println(bigDecimal.equals(BigDecimal.valueOf(1000)));
        System.out.println(bigDecimal.compareTo(BigDecimal.valueOf(1000)));
        System.out.println(bigDecimal);

        String string = "Hello World";

    }

}
