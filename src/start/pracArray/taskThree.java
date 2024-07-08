package start.pracArray;



import java.util.ArrayList;
import java.util.List;
  //у вас есть список значений String, вы должны вернуть одну строку, которая представляет собой конкатенацию всех значений.

public class taskThree {
    public static String concatenateStrings(List<String> strings) {
        StringBuilder concatenated = new StringBuilder();
        for (String str : strings) {
            concatenated.append(str);
        }
        return concatenated.toString();
    }

    public static void main(String[] args) {
        List<String> strings  = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        String concatenatedString = concatenateStrings(strings);
        System.out.println("Concatenated string: " + concatenatedString);
    }
}

