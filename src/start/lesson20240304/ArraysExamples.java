package start.lesson20240304;

import java.util.Arrays;

public class ArraysExamples {
    public static void main(String[] args) {

        // array init example
        Integer[] ints1 = new Integer[10];
        int ints2[] = new int[10];
        int[] ints3 = {1, 2, 3};
        int[] ints4 = new int[]{1, 2, 3};
        var ints5 = new int[10];
        var ints6 = new int[]{1, 2, 3};

        System.out.println(ints1.getClass().getSimpleName());

        // loop examples:
        for (int i = 0; i < ints6.length; i++) {
            System.out.println(ints6[i]);
        }

        for (int value : ints6) {
            System.out.println(value);
        }

        // 2 dimension array examples
        String[][] strings = new String[3][];
        strings[0] = new String[]{"A", "B"};
        strings[1] = new String[]{"C", "D", "E", "F"};
        strings[2] = new String[]{"G", "H", "K"};

        for (int i = 0; i < strings.length; i++) {
            System.out.println("Retrieving data from i = " + i);
            for (int j = 0; j < strings[i].length; j++) {
                System.out.println(strings[i][j]);
            }
        }

        int[][] ints2DArray = new int[5][7];
        print2DArray(ints2DArray);
        System.out.println("-------");
        ints2DArray[3][6] = 8;
        print2DArray(ints2DArray);

        String[] data = {"Hello", "World", "!!!", "Cat", "cat"};
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.deepToString(ints2DArray));

        int[] dataArray = {2, 6, 1, 0};
        int[] copied = Arrays.copyOf(dataArray, 10);
        System.out.println(Arrays.toString(copied));

        String[] newArray = new String[5];
        Arrays.fill(newArray, "Value");
        System.out.println(Arrays.toString(newArray));

        Arrays.sort(dataArray); // quick sort alg
        System.out.println(Arrays.toString(dataArray));

        Arrays.sort(data); // merge sort alg
        System.out.println(Arrays.toString(data));

    }

    public static void print2DArray(int[][] ints2DArray) {
        for (int i = 0; i < ints2DArray.length; i++) {
            for (int j = 0; j < ints2DArray[0].length; j++) {
                System.out.print(ints2DArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}