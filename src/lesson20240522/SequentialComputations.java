package lesson20240522;

public class SequentialComputations {
    public static void main(String[] args) {
//        int i = 0;
//        int j = 0;
//        i++;
//        j++;
//
//        someMethod1(i);
//        someMethod2(j);

        // count prime numbers
        long start = System.currentTimeMillis();
        int count = 0;

        for (int i = 2; i < 100_000; i++) {
            boolean isPrime = true;

            for (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                count++;
        }
        long end = System.currentTimeMillis();
        System.out.println("Total numbers of prime: " + count);
        System.out.println("TIme elapsed: " + (end - start) + ", ms");

    }

    public static void someMethod1(int i) {
        System.out.println(i);
    }

    public static void someMethod2(int j) {
        System.out.println(j);
    }


}
