package start.iteratorSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExamples {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list = List.of("One", "Two", "Three", "Four", "Five");
        System.out.println(list);
//        list.add("Six"); // exception
//        list.set(1, "TWO"); // exception
//        System.out.println(list);
        list = Arrays.asList("A", "B", "C", "D");
//        list.add("Six"); // exception
        list.set(1, "TWO");
        System.out.println(list);

        int[] ints1;
        Integer[] integers;
        List<Integer> ints = new ArrayList<>();
    }


}

