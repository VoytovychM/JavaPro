package lesson20240327;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {
    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>(); // key should have compareTo(), Comparator
        Map<String, Integer> map = new HashMap<>(); // key should have equals(), hashCode()
        map.put("A", 5);
        map.put("B", 50);
        map.put("C", 10);
        map.put("D", 10);
        map.put("E", 70);

        // put(), get(), containsKey() ---- O(log n)

        System.out.println(map.get("C"));
        System.out.println(map.get("E"));

        System.out.println(map.get("A"));
        map.put("A", 70);
        System.out.println(map.get("A"));

        System.out.println(map.containsKey("D"));

        System.out.println(map.containsValue(50)); // slow --- O(n)

        // keys
        Set<String> keySet = map.keySet();
        System.out.println(keySet);
        // values
        Collection<Integer> values = map.values();
        System.out.println(values);

        // key-value pairs
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("entry key:" + entry.getKey() + ", entry value: " + entry.getValue());
        }


    }

}

