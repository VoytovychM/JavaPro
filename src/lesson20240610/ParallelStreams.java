package lesson20240610;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) throws InterruptedException {
        long start;
        long sum;
        long end;

//        start = System.currentTimeMillis();
//        sum = LongStream.rangeClosed(1, 500_000_000).parallel().sum();
//        end = System.currentTimeMillis();
//        System.out.println(sum);
//        System.out.println("Time elapsed parallel: " + (end - start));
//
//        start = System.currentTimeMillis();
//        sum = LongStream.rangeClosed(1, 500_000_000).sum();
//        end = System.currentTimeMillis();
//        System.out.println(sum);
//        System.out.println("Time elapsed sequentially: " + (end - start));

        // Составить все возможные тройки пифагоровых чисел от 1 до 1000
        //Пифагоровой тройкой называют три натуральных числа, из которых можно составить прямоугольный треугольник
        //a^2 + b^2 = c^2
        //[3, 4, 5]
        //[6, 8, 10]

        Thread.sleep(10000);

        int n = 15_000;
        start = System.currentTimeMillis();
        long count = IntStream.rangeClosed(1, n).boxed().flatMap(i -> IntStream.rangeClosed(i, n)
                        .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
                        .mapToObj(j -> new int[]{i, j, (int) Math.sqrt(i * i + j * j)}))
                .count();
        end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("Time elapsed sequentially: " + (end - start));

        start = System.currentTimeMillis();
        count = IntStream.rangeClosed(1, n).parallel().boxed().flatMap(i -> IntStream.rangeClosed(i, n)
                        .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
                        .mapToObj(j -> new int[]{i, j, (int) Math.sqrt(i * i + j * j)}))
                .count();
        end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("Time elapsed parallel: " + (end - start));

        Stream.of(1, 2, 3).map(i -> i * 2).parallel().peek(i -> System.out.println(i)).sequential().filter(i -> i % 2 == 0).toList();
    }




}

