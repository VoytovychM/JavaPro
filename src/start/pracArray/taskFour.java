package start.pracArray;

import java.util.ArrayList;
import java.util.List;

 //Напишите метод для объединения двух списков в один общий ArrayList
public class taskFour {
    public static void main(String[] args) {
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(4);
        integers2.add(5);

        List<Integer> united = unite(integers1, integers2);
        System.out.println(united);
    }

    public static List<Integer> unite(List<Integer> integers1, List<Integer> integers2) {
        List<Integer> result = new ArrayList<>();
        result.addAll(integers1);
        result.addAll(integers2);
        return result;
    }

    public static List<String> removeDuplicates(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}