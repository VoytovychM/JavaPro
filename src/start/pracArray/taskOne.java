package start.pracArray;

import java.util.ArrayList;
import java.util.List;

public class taskOne {
 //У вас есть список значений int, вы должны вернуть список, каждое значение которого умножается на 2
    public static List<Integer> multiplyByTwo(List<Integer> numbers) {
        List<Integer> multipliedNumbers = new ArrayList<>();
        for (int num : numbers) {
            multipliedNumbers.add(num * 2);
        }
        return multipliedNumbers;
    }
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> multipliedNumbers = multiplyByTwo(numbers);
        System.out.println("Original numbers: " + numbers);
        System.out.println("Multiplied numbers: " + multipliedNumbers);
    }
}
