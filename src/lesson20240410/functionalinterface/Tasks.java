package lesson20240410.functionalinterface;

import start.comparableExamples.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//1. Создать Supplier generateBot, который выдает пользователю экземпляр класса Bot.
//        2. Создать Consumer, который принимает числа и печатает их в формате "---123---".
//        3. Создать Predicate isAdultEmployee, который проверяет, что возраст Employee больше 18.
//        4. Создать Function, которая вычисляет сумму чисел от 1 до n включительно.
public class Tasks {

    static class Bot{

    }
    public static void main(String[] args) {

        // 1. Создать Supplier generateBot, который выдает пользователю экземпляр класса Bot.
        Supplier<Bot> generateBot = () -> new Bot();
        Supplier<Bot> generateBot2 = Bot::new;
        Bot bot1 = generateBot.get();
        Bot bot2 = generateBot.get();
        Bot bot3 = generateBot.get();

        // 2. Создать Consumer, который принимает числа и печатает их в формате "---123---".
        Consumer<Integer> printNumber = (integer -> System.out.println("---" + integer + "---"));
        printNumber.accept(123);

        // 3. Создать Predicate isAdultEmployee, который проверяет, что возраст Employee больше 18.
        Employee employee = new Employee("John", "Smith", 23, true, 40, "Legal", 2500);
        Predicate<Employee> isAdultEmployee = e -> e.getAge() >= 18;
        System.out.println(isAdultEmployee.test(employee));

        // 4. Создать Function, которая вычисляет сумму чисел от 1 до n включительно.
        int n = 5;
        UnaryOperator<Integer> sum = (number) -> {
            int count = 0;
            for (int i = 1; i <= number ; i++) {
                count += i;
            }
            return count;
        };
        System.out.println(sum.apply(n));
    }

}
