package lesson20240325;

import java.util.Stack;

public class PolishCalculator {
    // (2 + 3) * 4  -----> 2 3 + 4 *
    // 1 + 2 * 3 --------> 1 2 3 * +
    // (3 + 4) * (5 + 6) -----> 3 4 + 5 6 + *
    // (1 * 3 * 5 +  2 * (1 + 8 * 2)) -----> 1 3 5 * * 2 1 8 2 * + * +

    public static void main(String[] args) {
        int result = calculate ("2 3 + 4 *");
        System.out.println(result);

        System.out.println(calculate("1 2 3 * +"));
        System.out.println(calculate("3 4 + 5 6 + *"));
        System.out.println(calculate("1 3 5 * * 2 1 8 2 * + * +"));
    }

    public static int calculate(String string){
        String[] elements = string.split(" ");
        Stack<Integer> numbers = new Stack<>();
        for(String element: elements){
            if (element.equals("*")){
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                numbers.push(first * second);
            } else if (element.equals("+")){
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                numbers.push(first + second);
            } else {
                Integer number = Integer.valueOf(element);
                numbers.push(number);
            }
        }
        return numbers.pop();
    }
}
