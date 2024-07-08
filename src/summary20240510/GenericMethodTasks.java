package summary20240510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class GenericMethodTasks {
    public static void main(String[] args) {
        // Написать метод, который принимает список любого типа
        // и возвращает его в виде нового списка с элементами в обратном порядке.

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = reverseList(list);


        // Написать generic метод arrayFilter(array, filter), который принимает на вход массив array (любого типа)
        //и производит фильтрацию данных согласно реализации filter интерфейса Filter (например, через лямбда-выражение)
        //Интерфейс Filter имеет метод apply (T t), с помощью которого можно будет указывать способ фильтрации.
        //interface Filter {
        //   boolean apply(T t);
        //}
        //Проверьте как работает метод на строках или других объектах.

        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] filtered = arrayFilter(ints, i -> i % 2 == 0);
        System.out.println(Arrays.toString(filtered));

        String[] strings = new String[]{"One", "Two", "Three"};
        String[] filteredString = arrayFilter(strings, string -> string.length() > 3);
        System.out.println(Arrays.toString(filteredString));

    }

    public static <T> T[] arrayFilter(T[] array, Filter<T> filter) {
        int j = 0;
        for (int i = 0; i < array.length ; i++) {
            boolean isValid = filter.apply(array[i]);
            if (isValid) {
                array[j++] = array[i];
            }
        }
//        T[] a = new T[array.length];
//        T[] a = (T[]) Array.newInstance(array.getClass(), array.length); // possible solution
        T[] result = Arrays.copyOf(array, j);
        return result;
    }

    public static <T> T[] arrayFilter2(T[] array, Predicate<? super T> predicate) {
        int j = 0;
        for (int i = 0; i < array.length ; i++) {
            boolean isValid = predicate.test(array[i]);
            if (isValid) {
                array[j++] = array[i];
            }
        }
        return Arrays.copyOf(array, j);
    }

    public static <T> List<T> reverseList(List<T> list) {
        List<T> result = new ArrayList<>(list);
        Collections.reverse(result);
        return result;
    }

//    public static List<?> reverseList2(List<?> list) {
//        return null;
//    }

    public static void reverseList3(List<?> list) {
        Collections.reverse(list);
    }


}

