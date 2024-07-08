package lesson20240408;

import java.util.HashMap;
import java.util.Map;

public class FindElement {
    // Найти первый элемент, встречающийся k раз в массиве

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 1, 4, 2, 7, 8, 8, 8, 4, 5, 1, 8};
        int k = 1;

        System.out.println(findElementBruteForce(input, k));
        System.out.println(findElementWithHashTable(input, k));
    }

    public static Integer findElementWithHashTable(int[] input, int k) { // O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : input) { // O(n)
//            if (map.containsKey(data)) {
//                int count = map.get(data);
//                map.put(data, count + 1);
//            } else {
//                map.put(data, 1);
//            }
            int count = map.getOrDefault(data, 0);
            map.put(data, count + 1);
        }

        for (int data : input) { // O(n)
            Integer count = map.get(data);
            if (count == k) return data;
        }
        return null;
    }

    public static Integer findElementBruteForce(int[] input, int k) { // O(n^2)
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            int current = input[i];
            for (int j = 0; j < input.length; j++) {
                if (current == input[j]) {
                    count++;
                }
            }
            if (count == k) return current;
        }
        return null;
    }


}