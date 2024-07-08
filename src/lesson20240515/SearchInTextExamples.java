package lesson20240515;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchInTextExamples {
    public static void main(String[] args) {
        String text = "This is some text. Something other. Some other info";
        String regex = "\\b[Ss]ome[a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

//        while (matcher.find()) {
//            String searchResult = matcher.group();
//            System.out.println("Word found: " + searchResult + " start: " + matcher.start() + ", end: " + matcher.end());
//        }

        matcher.results().forEach(matchResult -> System.out.println(matchResult.group()));

        text = "The dog says meaow. All dogs say meaow!";
        regex = "meaow";
        String replacement = "gav";
//        regex = "dog says meaow";
//        String replacement = "dog says gav";
        String textReplaced = Pattern.compile(regex).matcher(text).replaceAll(replacement);
        System.out.println(textReplaced);

    }


}
