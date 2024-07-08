package summary20240524;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {
    public static List<String> findDuplicates(String text) {
        if (text == null || text.isEmpty()) {
            return Collections.emptyList();
        }

        // Split the text into words
        String[] words = text.split("\\s+");

        if (words.length < 2) {
            return Collections.emptyList();
        }

        // Use a stream to find consecutive duplicate words
        return Stream.iterate(0, n -> n + 1)
                .limit(words.length - 1)
                .filter(i -> words[i].equals(words[i + 1]))
                .map(i -> words[i])
                .distinct()
                .collect(Collectors.toList());
    }


    public static int findSecondMax(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num >= max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second maximum element in the array");
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 4, 5, 0, 2};
        System.out.println(findSecondMax(array1));

        int[] array2 = {10, 10, 10};
        try {
            System.out.println(findSecondMax(array2));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}



