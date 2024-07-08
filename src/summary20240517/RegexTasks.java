package summary20240517;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexTasks {

    ////3. Напишите программу на Java и тест для нее для поиска общих элементов между двумя массивами целых чисел
    //        //example input:
    //        //Array1: [1, 2, 5, 5, 8, 9, 7, 10]
    //        //Array2: [1, 0, 6, 15, 6, 4, 7, 0]
    //        //example expected:
    //        //[1,7]
    public static int[] find(int[] array1, int[] array2) {  // O(n)
        if (array1 == null || array2 == null) {
            return new int[0];
        }
        Set<Integer> set1 = Arrays.stream(array1).boxed().collect(Collectors.toCollection(HashSet::new));
        Set<Integer> result = new HashSet<>();
        for (int element : array2) {
            if (set1.contains(element)) {
                result.add(element);
            }
        }

        return result.stream().mapToInt(value -> value).toArray();
    }
    // 1. Разбить текст на список отдельных строк этого текста.
    public static void main(String[] args) {
        String text = "one cat hello world\n" +
                "one cat two three\n" +
                "login: admin password: sKb122 \n" +
                "password: sKb122 five\n" +
                "world one hello";

        String[] split = text.split("\\n");
        System.out.println(Arrays.toString(split));

        // Имеется текст с логинами и паролями. Найти в тексте выражения вида "login: admin",
        // "password: sKb122", составить из них Map<login, password>


        Pattern pattern;
        pattern = Pattern.compile("login:\\s([a-zA-Z]+)\\spassword:\\s(\\w+)");
        Map<String, String> collect = pattern.matcher(text).results()
                .collect(Collectors.toMap(s -> s.group(1), s -> s.group(2)));
        System.out.println(collect);






    }
                }







