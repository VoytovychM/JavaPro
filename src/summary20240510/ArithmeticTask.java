package summary20240510;

import java.util.Random;
import java.util.Scanner;

// User
//Task 1. Написать программу, которая
//дает пользователю арифметическую задачу со случайными числами и проверяет ответ
public class ArithmeticTask {
    public static void main(String[] args) {
        Random random = new Random();
       try(
        Scanner scanner = new Scanner(System.in))
        {
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int operation = random.nextInt(3);
        int correctResult;
        if(operation == 1){
            correctResult = a + b;
            System.out.println("Correct answer: " + a + "+" + b );
        } else {
            correctResult = a - b;
            System.out.println("Correct answer: " + a + "-" + b );
        }
        System.out.println("Enter result");

        int result = scanner.nextInt();
        System.out.println(result == correctResult);
    }
    }
}
