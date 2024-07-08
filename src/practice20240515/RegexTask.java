package practice20240515;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//  Написать регулярное выражение для проверка email (например my_25@domen-38.de).
public class RegexTask {
    public static void main(String[] args) {

       // 1-й вариант
        Pattern emailPattern = Pattern.compile("^[^_[.]-][\\w-]+([.][\\w-]+)*@[-\\w&&[^_]]{3,20}([.][a-zA-Z]{2,7})?[.][a-zA-Z]{2,}$");
        Matcher emailMatcher = emailPattern.matcher("my_25@domen-38.de");
        boolean emailMatch = emailMatcher.matches();
        System.out.println("Your e-mail matches requirements: " + emailMatch);

//  2-й вариант
        boolean emailMatch1 = Pattern.matches("^[^_[.]-][\\w-]+([.][\\w-]+)*@[-\\w&&[^_]]{3,20}([.][a-zA-Z]{2,7})?[.][a-zA-Z]{2,}$", "my_25@domen-38.de");
        System.out.println("Your e-mail matches requirements: " + emailMatch1);

//  3-й вариант
        String email = "my_25@domen-38.de";
        boolean emailMatch2 = email.matches("^[^_[.]-][\\w-]+([.][\\w-]+)*@[-\\w&&[^_]]{3,20}([.][a-zA-Z]{2,7})?[.][a-zA-Z]{2,}$");
        System.out.println("Your e-mail matches requirements: " + emailMatch2);




    }
}
