package start.iteratorSamples;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        // Test 1
        int[] data = {1, 2, 3, 4, 5};
        reverseArray(data);
        System.out.println(Arrays.toString(data));

        // Test 2
        data = new int[]{1, 2, 3, 4, 5, 6};
        reverseArray(data);
        System.out.println(Arrays.toString(data));

        // Test 3
        data = new int[]{1};
        reverseArray(data);
        System.out.println(Arrays.toString(data));

        // Test 4
        data = new int[]{1, 2};
        reverseArray(data);
        System.out.println(Arrays.toString(data));
    }

    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }



}

