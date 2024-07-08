package algrorithms20240528;
//1. написать функцию, колорая получает на вход опсормированный массие целых чисел //
// и созеращает максимальнуя разницу между соседними значениями.
//// Например:
//// Input: [2, 6, 7, 11, 14]
//1/ 0utput: 4（11-7）
public class MaxGap {
    public static int maxGapIter(int[] input){
        int maxD = 0;
        for (int i = 0; i < input.length -1; i++) {
            if ( input[i+1] - input[i] > maxD){
                maxD = input[i+1] - input[i];

            }

            }

        return maxD;
        }


    public static int maxGapRecursive(int[] input){
        return maxGapFrom(input, 0);
    }

    private static int maxGapFrom(int[] input, int i) { //int i -from
        if(i >= input.length -1){
            return 0;

        }else {
            int curGap = input[i+1] - input[i];
            int otherGap = maxGapFrom(input, i+1);
            if(curGap>otherGap){
                return curGap;
            }else {
                return otherGap;
            }

        }
    }

    public static void main(String[] args) {
        int[] input = {2, 6, 7, 11, 14};

        System.out.println(maxGapIter(input));
        System.out.println(maxGapRecursive(input));
    }

}
