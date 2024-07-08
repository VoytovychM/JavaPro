package lesson20240610;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchCollectionExamples {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("A"); // thread-safe
        vector.remove(0);

        List<String> list = new ArrayList<>();
//        list.add("A"); // not thread-safe

        List<String> synchronizedList = Collections.synchronizedList(list);
        synchronizedList.add("A"); // thread-safe
        synchronizedList.add("B");

        if (synchronizedList.size() == 2) { // not thread-safe
            synchronizedList.add("C");
        }

        synchronized (synchronizedList) { // thread-safe
            if (synchronizedList.size() == 2) {
                synchronizedList.add("C");
            }
        }

//        Collections.synchronizedSet()


//        for (String s : list){
//            System.out.println(s);
////            synchronizedList.add("New value"); // ConcurrentModificationException
////            synchronizedList.remove(0); // ConcurrentModificationException
//        }

        synchronized (synchronizedList) { // thread-safe
            Iterator<String> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                String data = iterator.next();
                System.out.println(data);
                if (data.equals("B")) iterator.remove();
            }
        }

        System.out.println(synchronizedList);


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16, 0.75f, 16);
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("A");
        copyOnWriteList.add("B");
        copyOnWriteList.add("C");

        // thread 1:
        for (String s : copyOnWriteList) {
            System.out.println(s);
        }

        // thread 2:
        copyOnWriteList.remove(0);
    }


}

