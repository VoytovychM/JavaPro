package algorithms20240618;

import java.util.Arrays;

public class ArrayTask {

    public static int[] squares(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        int breakPoint = 0;
        while (breakPoint < n && arr[breakPoint] < 0) {
            breakPoint++;
        }
        System.out.println(breakPoint);
        int left = breakPoint -1;
        int right = breakPoint;
        int index = 0;

        while(left >= 0 && right < n){
            if(arr[left] * arr[left] < arr[right] * arr[right]){
                newArr[index++] = arr[left] * arr[left];
                left--;
            }else{
                newArr[index++] = arr[right] * arr[right];
                right++;

            }
        }
        while (left >=0){
            newArr[index++] = arr[left] * arr[left];
            left --;
        }
        while (right<n){
            newArr[index++] = arr[right] * arr[right];
            right++;
        }
        return newArr;
    }
    public static void main(String[] args) {
        int[] arr = {-5, -2, -1, 2, 3, 4, 5, 7, 10};
        int[] squaredSortedArray = squares(arr);
        System.out.println(Arrays.toString(squaredSortedArray));

            }

        }

