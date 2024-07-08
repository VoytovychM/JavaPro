package lesson20240320.cards.sets;

import java.util.*;

public class Tasks {
    public static void main(String[] args) {

        // 1. Set<String> names ------> Set<Integer> длины имен
        Set<String> names = Set.of("Ivan", "Peter", "William", "Mary");
        Set<Integer> integerSet = new TreeSet<>();
        for (String s : names) {
            integerSet.add(s.length());
        }
        System.out.println(integerSet);

        // 2. Имеется текст "Hello world!!!". Вывести уникальный набор символов
        String text = "Hello world!!!";
        char[] chars = text.toCharArray();
        Set<Character> characterSet = new TreeSet<>();
        for (char c : chars) {
            characterSet.add(c);
        }
        System.out.println(characterSet);

        // 3. Имеется список Integer, отсортировать его через set
        List<Integer> list = new ArrayList<>(List.of(2, 4, 1, 6));
        sortWithSet(list);
        System.out.println(list);
    }

    public static void sortWithSet(List<Integer> list) {
        SortedSet<Integer> set = new TreeSet<>(list);
        int i = 0;
        for(Integer value : set){
            list.set(i++, value);
        }
    }


}

