package lessonalgorithm20240604;
// Определить, является ли массив возрастающим
//  Массив может содержать одинаковые элементы
public class ArraysAscDesc {

    public static boolean isIncreasing(int[] array) {
        boolean isIncreasing = true;
        if (array.length < 1) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                isIncreasing = false;
                break;
            }
        }

        return isIncreasing;
    }

    //Определить, является ли массив возрастающим, убывающим или неотсортированным (3 состояния):
    // 1 - возрастающий, -1 - убывающий, 0 - неотсортированный
    // Массив может содержать одинаковые элементы

    public static int checkSortMode(int[] array) {

        if (array.length < 2) {
            return 0;
        }

        int element1 = array[0];
        int element2 = array[1];
        int firstResult = 1;

        if (element1 > element2) {
            firstResult = -1;
        } else if (element1 == element2) {
            firstResult = 0;
        }

        for (int i = 1; i < array.length - 1; i++) {
            int value1 = array[i];
            int value2 = array[i + 1];
            int temp = 0;

            if (value1 < value2) {
                temp = 1;
            } else if (value1 > value2) {
                temp = -1;
            } else {
                continue;
            }
            if (temp != 0 && firstResult != 0 && temp != firstResult) {
                return 0;
            }

            if (firstResult == 0) {
                firstResult = temp;
            }
        }

        return firstResult;
    }


    // Найти максимальныю длину возрастающей последовательности в неотсортированном массиве
    //Input: [1, 5, 3, 4, 7, 2]
    // Output: 3 (3, 4, 7)
    public static int maxAcsendingLength(int[] array) {
     if(array == null || array.length == 0) {
         return 0;
     }
     int count = 1;
     int maxCount = 1;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < array[i+1] ) {
                count ++;
            if (maxCount<count){
                maxCount = count;

            }
            }else {
                count = 1;
            }
    }
        return maxCount;
    }


    public static void main(String[] args) {
        int[] array = {1,5,12,20};
        System.out.println(isIncreasing(array));

        int[] array2 = {1,5,4,20};
        System.out.println(isIncreasing(array2));

        int[] array3 = {4, 3, 2};
        System.out.println(checkSortMode(array3));

        int[] array1 = {1, 2, 0};
        System.out.println(checkSortMode(array1));

        int[] array4 = {1, 5, 3, 4, 2};
        System.out.println(maxAcsendingLength(array4));

    }
}

