package lesson20240417;

import start.comparableExamples.Employee;
import start.incapsulation.A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five");
        List<String> result = stringList.stream().filter(string -> string.length() == 3).toList();
        System.out.println(result);
        List<String> wordStartingFromT = stringList.stream().filter(string -> string.startsWith("T")).toList();
        System.out.println(wordStartingFromT);

        stringList.stream().filter(string -> string.startsWith("F")).toList().stream().forEach(System.out::println);

        stringList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        result= stringStream.skip(2).limit(2).toList();
        System.out.println(result);

        List<Integer> integerList = Arrays.asList(23,33,34,35,33,2,1,0);
        integerList.stream().sorted().limit(3).forEach(System.out::println);
        List<Integer> distinctIntegers = integerList.stream().sorted().distinct().toList();
        System.out.println(distinctIntegers);

        System.out.println("peek()");
        List<Integer> integerResult = integerList.stream().filter(i -> i%2 ==0).peek(System.out::println).sorted().toList();
        System.out.println(integerResult);

        System.out.println("map()");
        List<Integer> lengths = stringList.stream().map(String::length).distinct().sorted().toList();
        System.out.println(lengths);



    }
}
