package lesson20240415.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GenerateStreamExamples {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        Integer[] array = {1,2,3,4,5};
        Stream<Integer> streamFromArray = Arrays.stream(array);
        System.out.println("list creation");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        System.out.println("stream creation");
        Stream<Integer> integerStream = list.stream(); // stream generation
        System.out.println("stream modification");
        Stream<Integer> integerStream2 = integerStream.filter(integer -> integer % 2==0); //intermediate operation
        Stream<Integer> integerStream3 = integerStream2.filter(integer -> integer % 3==0); //intermediate operation
        Stream<Integer> integerStream4 = integerStream3.peek(integer -> System.out.println("Looking up: " + integer));
        // some code....
        System.out.println("Some other actions");
        System.out.println("Terminal operation");
        List<Integer> resultList = integerStream4.toList();// terminal operation

        System.out.println(resultList);


//        resultList = list.stream().filter(integer -> integer % 2 == 0).toList();
        resultList = list.stream().filter(integer -> integer % 2 == 0)
                .filter(integer -> integer % 3 ==0)
                .peek(integer -> System.out.println("Looking up: " + integer))
                .toList();
        System.out.println(resultList);

    }
}
