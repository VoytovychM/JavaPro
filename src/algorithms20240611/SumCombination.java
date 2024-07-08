package algorithms20240611;

import java.util.ArrayList;
import java.util.List;

public class SumCombination {

    public static void genCombinations(int[] values, int sum) {
     List<Integer> combination  = new ArrayList<>();
     findCombinations (values, sum, combination);

    }

    private static void findCombinations(int[] values, int sum, List<Integer> combination) {

        if(sum == 0){
            System.out.println(combination);
            return;
        }
        for(int value : values){
            if(value <= sum){
                List<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add(value);
                findCombinations(values, sum - value, newCombination);
            }

            }
        }


    public static void main(String[] args) {
        int[] values = {2,3,5};
      int sum = 7;
        genCombinations(values,sum);
    }

}