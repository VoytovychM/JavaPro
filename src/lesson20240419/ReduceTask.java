package lesson20240419;

import java.util.Arrays;
import java.util.List;

/// 1. a^2 + b^2 + c^2
//// 2. Дан список слов "Specific" "Measurable" "Achievable" "Relevant" "Time-bound".
//// С помощью стримов вывести его аббревиатуру в виде S.M.A.R.T
public class ReduceTask {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,20,30,40,50);
        Integer sumOFSquare = list.stream().reduce(0, (acc, a) -> acc + a * a);
        System.out.println(sumOFSquare);

        List<String> strings = Arrays.asList("Specific", "Measurable", "Achievable", "Relevant", "Time-bound");
        String cutOFstring = strings.stream().map(string -> string.substring(0,1)).reduce("", (str,str1) -> str + str1 + ".");
        System.out.println(cutOFstring);

        System.out.println(list.stream().reduce((i, j) -> Math.max(i, j)).get());


    }
    }

