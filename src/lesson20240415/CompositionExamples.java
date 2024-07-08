package lesson20240415;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionExamples {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (integer -> System.out.println(integer));
        Consumer<Integer> compositeConsumer = consumer.andThen(integer -> System.out.println(integer+10));
        compositeConsumer.accept(10);

        Predicate<String> isLongEnough = (s) -> s.length() > 3;
        Predicate<String> startsWithS = (s) -> s.startsWith("S");
        Predicate<String> compositePredicate = isLongEnough.negate().and(startsWithS);
        System.out.println(compositePredicate.test("Hello"));
        System.out.println(compositePredicate.test("Summer"));
        System.out.println(compositePredicate.test("Sum"));

        Function<String,String > function1 = s -> s + " 1";
        Function<String,String > function2 = s -> s + " 2";
        Function<String,String > function3 = s -> s + " 3";
        Function<String, String > compositeFunction = function1.andThen(function2).andThen(function3);
        String result = compositeFunction.apply("Test data");
        System.out.println(result);

        compositeFunction = function1.compose(function2).compose(function3);
        result = compositeFunction.apply("Test data");
        System.out.println(result);

//        1.Создать три функции:
//- обрезает входную строку до 11 символов,
//- добавялет текст "Info: " перед
//- делает основной текст upper case
//Составить композитную функцию так, чтобы:
//Input:
//"Some random data"
//Output:
//"Info: SOME RANDOM


        Function<String, String> functionFirst = s -> s.substring(0, 11);
        Function<String, String> functionSecond = s -> "Info: " + s;
        Function<String, String> functionThird = s -> s.toUpperCase();

        Function<String, String> compositeFunction1 = functionFirst.andThen(functionThird).andThen(functionSecond);

        String input = "Some random data";
        String output = compositeFunction1.apply(input);

        System.out.println("Input: " + input);
        System.out.println(output);

        compositeFunction1 = function1.compose(function3).andThen(function2);
        System.out.println(output);
    }
}



