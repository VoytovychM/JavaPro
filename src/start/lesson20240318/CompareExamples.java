package start.lesson20240318;

import start.incapsulation.Cat;

public class CompareExamples {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;

        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a == b);

        char c1 = 'a';
        char c2 = 'b';
        char c3 = 'A';
        System.out.println(c1 < c2); // true
        System.out.println(c1 > c3); // true

        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Stepan");

        String string1 = "ABC";
        String string2 = "ABD";
        System.out.println(string1.compareTo(string2)); // negative, 0, positive // -1, 0, 1

        if (string1.compareTo(string2) < 0) {
            System.out.println("s1 is less than s2");
        } else if (string1.compareTo(string2) == 0) {
            System.out.println("s1 is equal than s2");
        } else {
            System.out.println("s1 is more than s2");
        }

        Integer integer1 = 0;
        Integer integer2 = 1;
        System.out.println(integer1.compareTo(integer2));

        Boolean b1 = true; // 1
        Boolean b2 = false; // 0

        var b3 = Boolean.TRUE;
        var b4 = true;

        System.out.println(b1.compareTo(b2));
    }



}

