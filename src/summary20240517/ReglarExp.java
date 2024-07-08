package summary20240517;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReglarExp {
    public static void main(String[] args) {
        String text = "one cat hello world\n" +
                "one cat two three\n" +
                "four five\n" +
                "world one hello";

        Pattern pattern = Pattern.compile("^one[a-z\\s]+hello$");
//        Pattern pattern = Pattern.compile("\\Aone/(\\n)one");
        Matcher matcher = pattern.matcher(text);
//        System.out.println(matcher.matches());

        matcher.results().forEach(matchResult -> System.out.println(matchResult.group()));

        text = "input: 123-123, input: 321-321, input: 444444-2522532";
        pattern = Pattern.compile("input: (\\d+)-(\\d+)");
        matcher = pattern.matcher(text);
//        matcher.group("name");

        matcher.results().forEach(matchResult -> System.out.println(matchResult.group(0) +
                ", group1: " +
                matchResult.group(1) +
                ", group2: " +
                matchResult.group(2)));

        text = "777 some text 777 dfbkad k sdk 545 lflel 888 dsglsfnlsll 55 888";
        pattern = Pattern.compile("(\\d{3})(.*)\\1");
        matcher = pattern.matcher(text);
        matcher.results().forEach(matchResult -> System.out.println(matchResult.group() + ", extracted text between: " + matchResult.group(2)));

    }




}



