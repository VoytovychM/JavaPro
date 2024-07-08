package summary20240426;

import java.io.RandomAccessFile;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//
public class TasksSummary {

    public static Map<Boolean, List<Integer>> getMap() {
        return IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i % 3 == 0, Collectors.toList()));
    }

    public static <T> T[] arrayFilter(T[] array, Filter<T> filter){
        // public static <T> T[] arrayFilter(T[] array, Predicate<? super T> predicate){
        int j= 0;
        for (int i = 0; i < array.length; i++) {
            //boolean isValid = predicate.test(array[i]); best option
            boolean isValid = filter.apply(array[i]);
            if(isValid){
                array[j++] = array[i];
        }

            }
        return Arrays.copyOf(array, j);
        }

    public static void main(String[] args) {
        Set<String> names = Set.of("Ivan", "Peter", "William", "Mary");
        //	Set<Integer> integerSet = new TreeSet<>();
        //	for (String s : names) {
        //		integerSet.add(s.length());
        //	}
        //	System.out.println(integerSet);


        Object TreeSet;
        Set<Integer> integerSet = names.stream()
                .map(String::length)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(integerSet);


        //public static Map<Boolean, List<Integer>> getMap() {
        //        Map<Boolean, List<Integer>> map = new TreeMap<>();
        //        for (int i = 0; i < 100; i++) {
        //            if (i % 3 == 0) {
        //                if (map.containsKey(true)) {
        //                    map.get(true).add(i);
        //                } else {
        //                    map.put(true, new ArrayList<>());
        //                    map.get(true).add(i);
        //                }
        //            } else {
        //                if (map.containsKey(false)) {
        //                    map.get(false).add(i);
        //                } else {
        //                    map.put(false, new ArrayList<>());
        //                    map.get(false).add(i);
        //                }
        //            }
        //        }
        //        return map;
        //    }

        Integer[] ints = new Integer[]{1,2,3,4,5,6};
        Integer[] filtered =  arrayFilter(ints, i-> i% 2 == 0);
        System.out.println(Arrays.toString(filtered));

        String[] strings = new String[]{"One", "Two", "Three"};
        String[] filteredString = arrayFilter(strings, s -> s.length() > 3);
        System.out.println(Arrays.toString(filteredString));

        }




    }



