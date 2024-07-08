package lesson20240415;

import java.util.Arrays;
import java.util.function.BinaryOperator;

//2. Написать метод, который на вход принимает два массива одинакового размера типа Integer и функцию.
//Метод возвращает массив, в котором хранятся результаты попарных вычислений согласно переданной функции.
public class MethodWithLambda {
    public static void main(String[] args) {
        Integer[] array1 = {1,2,3,4,5};
        Integer[] array2 = {6,7,8,9,10};
        Integer[] result = process(array1, array2, (i,j) -> i + j);
        System.out.println(Arrays.toString(result));
        result = process(array1, array2, (i,j) -> i * j);
        System.out.println(Arrays.toString(result));
        result = process(array1, array2, (i,j) -> (int) Math.pow(i, j));
        System.out.println(Arrays.toString(result));

    }

    private static Integer[] process(Integer[] array1, Integer[] array2, BinaryOperator<Integer> action) {
        if (array1.length != array2.length) throw new RuntimeException("Data is incorrect");
        Integer[] result = new Integer[array1.length];
        for (int i = 0; i < array1.length; i++) {
            Integer r = action.apply(array1[i], array2[i]);
            result[i] = r;

        }
       return result;

    }

}
