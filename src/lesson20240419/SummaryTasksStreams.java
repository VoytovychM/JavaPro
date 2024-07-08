package lesson20240419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SummaryTasksStreams {

    public static class Cat {
        private String name;
        private boolean isHungry;

        public Cat(String name, boolean isHungry) {
            this.name = name;
            this.isHungry = isHungry;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHungry(boolean hungry) {
            isHungry = hungry;
        }

        public String getName() {
            return name;
        }

        public boolean isHungry() {
            return isHungry;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", isHungry=" + isHungry +
                    '}';
        }
    }
// 1.
    public static void feed(List<Cat> catList) {
        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).isHungry()) {
                catList.get(i).setHungry(false);
            }
        }
    }
    public static void feedWithStream(List<Cat> catList){
            catList.stream().filter(Cat::isHungry).forEach(cat -> cat.setHungry(false));
    }

    public static int getSum(List<Integer> integers) {
        int oddSum = 0;
        for(Integer i: integers) {
            if(i % 2 != 0) {
                oddSum += i;
            }
        }
        return oddSum;
    }

    public static int getSumWithStream(List<Integer> integers){
        int oddsum = integers.stream().filter(i-> i % 2 != 0).mapToInt(value -> value).sum();
        return oddsum;
    }

    public static int findIndex(String[] data, String element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexWithStream(String[] data, String element) {
        return IntStream.range(0, data.length).filter(i -> data[i].equals(element)).findFirst().orElse(-1);

    }


    public static void fill(List<Integer> list, int capacity){
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }
    public static void fillWithStream(List<Integer> list, int capacity){
        IntStream.range(0, capacity).forEach(i -> list.add(i));
    }
//    public static void fill(List<Integer> list, int capacity){
//        for (int i = 0; i < capacity; i++) {
//            list.add(i);
//        }
//    }


    public static void main(String[] args) {
        List<Cat> catList = List.of(new Cat ("Tom", true), new Cat ("Jack", false), new Cat("Jack", false), new Cat("Sugar", true), new Cat("Bobo", true));
       feedWithStream(catList);
        System.out.println(catList);


        List<Double> doubleList = Arrays.asList(12.1, 13.4, 15.5, 20.1, 55.0);
        List<Double> doubles = new ArrayList<>();
//        for (Double d : doubleList) {
//            if (d % 2 == 1) {
//                doubles.add(d);
//            }
//        }
//        System.out.println(doubles);

        doubles = doubleList.stream().filter(d -> d % 2 == 1).toList();
        System.out.println(doubles);

        List<String> stringList = List.of("Four", "Seven", "Six", "One");

//        String word = null;
//        for (String t : stringList){
//            if (t.length() == 3) {
//                word = t;
//                break;
//            }
//        }
//        System.out.println(word);

       String word = stringList.stream().filter(string -> string.length() == 3).findFirst().orElse( null);
        System.out.println(word);

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(getSumWithStream(integers));

        String[] array = {"Four", "Seven", "Six", "One"};
        System.out.println(findIndexWithStream(array, "Six"));

        double sum = 0.0;
        for (int i = 0; i < 10_000; i++) {
            sum += 0.1;
        }

        System.out.println(IntStream.range(0, 10_000).mapToDouble(i -> 0.1).sum());
        System.out.println(sum);


       List <Integer> distinctSorted = Stream.of(2,3,5,6,0,0,2).peek(e-> System.out.println("stream: " + e)).distinct().peek(e-> System.out.println("distinct " + e)).sorted().peek(e-> System.out.println("sorted: " + e)).toList();
        System.out.println(distinctSorted);


    }
}