package lesson20240515;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TasksRegularExpressions {

    public static void main(String[] args) {

        //Напишите регулярное выражение, которое соответствует пин-коду из 4 чисел.
        String text = "0000";
        String regex = "\\d{4}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();
        System.out.println(matches);

        // Напишите регулярное выражение, которое соответствует именам клавиш F1-F12.

        String regexF = "F([1-9])|(F1[0-2])";
        System.out.println(Pattern.matches(regexF, "F10"));
        System.out.println(Pattern.matches(regexF, "F13"));

        // Напишите регулярное выражение, которое соответствует URL-адресу сайта вида https://someaddress.someending

        String regex2 = "https://[a-zA-Z]+\\.[a-zA-Z]+"; // "https://[a-z]+\\.[a-z]+"
        String text2 = "https://someaddress.someending";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern.matcher(text2);
        boolean matches2 = matcher.matches();
        System.out.println(matches2);
        System.out.println(Pattern.matches("https://[a-zA-Z]+\\.[a-zA-Z]+", "https://someaddress.someending"));



    }

}
