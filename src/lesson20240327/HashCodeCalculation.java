package lesson20240327;

import java.util.SortedSet;

public class HashCodeCalculation {
    public static void main(String[] args) {
        Integer i = 10;
        int hashI = i.hashCode();
        System.out.println(hashI);
        i++;
        System.out.println(i.hashCode());

        String string = "A";
        System.out.println(string.hashCode());
        Character c = 'A';
        System.out.println(c.hashCode());

        string = "ABC";
        System.out.println(string.hashCode());
        string = "ABD";
        System.out.println(string.hashCode());

    }
}
