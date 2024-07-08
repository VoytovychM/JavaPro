package practice20240515;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// 3.* Разбить текст на слова с помощью шаблона регулярного выражения и расчитать
//словарь встречающихся слов для этого текста
//(подсчитать количество одинаковых слов, встречающихся в этом тексте).
public class DictionaryWithRegex {
    public static void main(String[] args) {

        String inputData =  "String text = \"A regular expression is a sequence of characters that forms a search pattern.\\n\" +\n" +
                "                \"When you search for data in a text, you can use this search pattern to describe what you are searching for.\\n\" +\n" +
                "                \"A regular expression can be a single character, or a more complicated pattern.\\n\" +\n" +
                "                \"Regular expressions can be used to perform all types of text search and text replace operations.\";";

        Pattern pattern = Pattern.compile("\\b\\w+\\b");

        Map<String, Long> wordCount = pattern.matcher(inputData)
                .results()
                .map(matchResult -> matchResult.group().toLowerCase())
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println("Words in the text :");
        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));



    }
}



