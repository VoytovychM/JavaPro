package lesson20240410.maptasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompareArrays {
    // Проверьте, равны ли два массива или нет
    // (массивы считаются равными, если содержат одинаковые элементы, порядок не важен)
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 1};
        int[] array2 = {1, 1, 3, 2};

        System.out.println(isEqualDataBySort(array1, array2));
        System.out.println(isEqualDataWithHashTable(array1, array2));
    }

    public static boolean isEqualDataWithHashTable(int[] array1, int[] array2) { // O(n) Linear complexity
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int data : array1) { // O(n)
            Integer count = map1.getOrDefault(data, 0);
            map1.put(data, count + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int data : array2) { // O(n)
            Integer count = map2.getOrDefault(data, 0);
            map2.put(data, count + 1);
        }

//        Set<Map.Entry<Integer, Integer>> entries = map1.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            Integer value1 = entry.getValue();
//            Integer value2 = map2.get(entry.getKey());
//            if (!value1.equals(value2)) return false;
//        }
//        return true;
        return map1.equals(map2); // O(n)
    }

    public static boolean isEqualDataBySort(int[] array1, int[] array2) { // O (n log n) time complexity
        Arrays.sort(array1); // O(n log n)
        Arrays.sort(array2); // O(n log n)
        return Arrays.equals(array1, array2); // O(n)
    }


}

