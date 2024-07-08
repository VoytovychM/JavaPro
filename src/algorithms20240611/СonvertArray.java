package algorithms20240611;

import java.util.Arrays;

public class СonvertArray {

    public static String convertArrayToRangesString (int [] array) {
        if (array == null || array.length == 0) {
            return "empty";
        }
        int[] copyOfArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyOfArray);
        StringBuilder result = new StringBuilder();
        int start = copyOfArray[0];
        int end = copyOfArray[0];
        for (int i = 1; i < copyOfArray.length; i++) {
            if (copyOfArray[i] == end + 1) {
                end ++;
            } else {
               result.append(rangeToString( start,end)).append(",");
               start = copyOfArray[i];
               end = copyOfArray[i];
            }
        }
        result.append(rangeToString( start,end));
            return result.toString();
        }

        public static String rangeToString (int start, int end){

        if (start == end){
           return String.valueOf(start);
        }else {
         return String.format("%d-%d", start, end);
        }

        }
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 7, 2, 15, 14, 16, 9, 8};
        String result = convertArrayToRangesString(array);
        System.out.println(result);
        int[] array1 = {1};
        String result1 = convertArrayToRangesString(array1);
        System.out.println(result1);
        }
    }

