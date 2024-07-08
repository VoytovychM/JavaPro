package start.summary20240315;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVSLinkedList {
    public static void main(String[] args) {

        int capacity = 200_000;
        List<Integer> list = new ArrayList<>(capacity);
        fill(list, capacity);

        System.out.println("ArrayList, fori loop");
        long sum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("Time spent: " + (end - start));

        System.out.println("ArrayList, iterator loop");
        sum = 0;
        start = System.currentTimeMillis();
        for (Integer integer : list) {
            sum += integer;
        }
        end = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("Time spent: " + (end - start));

        list = new LinkedList<>();
        fill(list, capacity);

        System.out.println("LinkedList, iterator loop");
        sum = 0;
        start = System.currentTimeMillis();
        for (Integer integer : list) {
            sum += integer;
        }
        end = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("Time spent: " + (end - start));

        System.out.println("LinkedList, fori loop");
        sum = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("Time spent: " + (end - start));
    }

    private static void fill(List<Integer> list, int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }


}
