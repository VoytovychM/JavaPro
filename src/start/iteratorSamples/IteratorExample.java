package start.iteratorSamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//
//        for (String element : list) {
//            System.out.println(element);
//        }

//        Iterator<String> iterator = list.iterator();
//        String next = iterator.next();
//        System.out.println(next);
//        next = iterator.next();
//        System.out.println(next);
//        iterator.next();
//        iterator.next();
//        iterator.next();
//        System.out.println(iterator.hasNext());
//        if (iterator.hasNext()) {
//            iterator.next();
//        }


        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println(next);
//        }

        iterator = list.iterator();
        Iterator<String> secondIterator = list.iterator();

        iterator.next();
//        iterator.remove();
        iterator.next();
        iterator.next();
        secondIterator.next();

        System.out.println(iterator.next());
        System.out.println(secondIterator.next());

        list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        iterator = list.iterator();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();

        System.out.println(list);

        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.length() == 4) {
                iterator.remove();
            }
        }
        System.out.println(list);


    }


}

