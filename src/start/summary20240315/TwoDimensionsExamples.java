package start.summary20240315;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionsExamples {
    public static void main(String[] args) {

        String[][] stringsArray = new String[3][];
        stringsArray[0] = new String[2];
        stringsArray[1] = new String[3];
        stringsArray[2] = new String[4];
        stringsArray[0][0] = "A";
        stringsArray[0][1] = "A";
        stringsArray[1][0] = "B";
        stringsArray[1][1] = "B";
        stringsArray[1][2] = "B";
        stringsArray[2][0] = "C";
        stringsArray[2][1] = "C";
        stringsArray[2][2] = "C";
        stringsArray[2][3] = "C";

        print2DArray(stringsArray);
        String a1 = stringsArray[0][1];
        String a2 = stringsArray[2][3];

        List<List<String>> stringListOfLists = new ArrayList<>();
        stringListOfLists.add(new ArrayList<>());
        stringListOfLists.add(new ArrayList<>());
        stringListOfLists.add(new ArrayList<>());
        stringListOfLists.get(0).add("A");
        stringListOfLists.get(0).add("A");
        stringListOfLists.get(1).add("B");
        stringListOfLists.get(1).add("B");
        stringListOfLists.get(1).add("B");
        stringListOfLists.get(2).add("C");
        stringListOfLists.get(2).add("C");
        stringListOfLists.get(2).add("C");
        stringListOfLists.get(2).add("C");

        System.out.println(stringListOfLists);
        String e1 = stringListOfLists.get(0).get(1);
        String e2 = stringListOfLists.get(2).get(3);
    }


    public static void print2DArray(String[][] ints2DArray) {
        for (int i = 0; i < ints2DArray.length; i++) {
            for (int j = 0; j < ints2DArray[i].length; j++) {
                System.out.print(ints2DArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}

