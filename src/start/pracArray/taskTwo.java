package start.pracArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class taskTwo {
     //у вас есть список значений String, вы должны вернуть список этих значений без каких-либо дубликатов
    public static List<String> removeDuplicates(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String s: strings) {
            if(!result.contains(s)){
                result.add(s);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "apple", "orange", "banana", "grape");
        List<String> uniqueStrings = removeDuplicates(strings);
        System.out.println("Original strings: " + strings);
        System.out.println("Strings without duplicates: " + uniqueStrings);
    }
}


