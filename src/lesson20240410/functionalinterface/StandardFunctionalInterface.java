package lesson20240410.functionalinterface;

import java.util.Random;
import java.util.function.*;

public class StandardFunctionalInterface {
    public static void main(String[] args) {

        // data1 -> data2 --- Function --- UnaryOperator ---- apply()
        Function<String, String> upperCaseFunction = (s) -> s.toUpperCase();
        String result =upperCaseFunction.apply("String data");
        System.out.println(result);

        UnaryOperator<String> upperCaseOperator = (s) -> s.toUpperCase();
        result = upperCaseOperator.apply("String data");
        System.out.println(result);

        // void -> data --- Supplier ----- get()
        Supplier<Integer> randomIntGenerator = () -> new Random().nextInt();
        System.out.println(randomIntGenerator.get());
        System.out.println(randomIntGenerator.get());
        System.out.println(randomIntGenerator.get());

        // data -> void --- Consumer --- accept()
        Consumer<String> printData = (data) -> System.out.println(data);
        printData.accept("Data to consumer 1");
        printData.accept("Data to consumer 2");

        // data -> boolean --- Predicate --- test()
        Predicate<String> isLongEnough = (s) -> s.length() > 3;
        System.out.println(isLongEnough.test("Test string"));
        System.out.println(isLongEnough.test("abc"));

        // (data1, data2) -> data3 --- BiFunction --- BinaryOperator --- apply()
        BinaryOperator<Integer> sum = (int1, int2) -> int1 + int2;
        System.out.println(sum.apply(10, 20));

        BiFunction<String, Integer, String> prepareData = (string, integer) -> string + ": " + integer;
        String preparedData = prepareData.apply("Number", 10);
        System.out.println(preparedData);
        preparedData = prepareData.apply("Number", 20);
        System.out.println(preparedData);
    }

}