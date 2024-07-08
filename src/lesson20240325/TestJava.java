package lesson20240325;

import java.util.*;

public class TestJava {


    public static void main(String[] args) {
//        boolean[] array = new boolean[3];
//        System.out.println(Arrays.toString(array));
//      int[][] matrix = new int[3][];
//      matrix[0] = new int[]{1,2,3,4,5,6};
//      matrix[1] = new int[]{1,2,3};
//      matrix[2] = new int[]{1};
//     for(int[] ints: matrix){
//         for(int anInt: ints) System.out.println(anInt + " ");
//         System.out.println();


//         int[][] array1 = {{1, 2}, {3, 4}};
//         int[][] array2 = {{1, 2}, {3, 4}};
//         System.out.println(Arrays.deepEquals(array1, array2));
//
//
//        String[] array = new String[3];
//        String text = " ";
//        for(int i = 0; i < 3; i++){
//            text +=array[i];
//
//        }
//        System.out.println(text);
//
//        String[] array3 = {"One", "Two", "Three"};
//        List<String> list = new ArrayList<>();

//
//      List<Long> list1 = new ArrayList<>();
//      list1.add(2L);
//      list1.add(3L);
//      list1.add(1, 1L);
//        System.out.println(list1.get(2));
//
//
//
//        Set<Boolean> set2 = new HashSet<>();
//        set2.add(null); // 2
//        System.out.println(set2);
//
//
//    Queue<String> queue = new PriorityQueue<>(List.of("B", "A", "C", "B", "A", "C"));
//
//
//        System.out.print(queue);



        String one1 = "One";
        String one2 = "One";
        String one3 = new String("One");
        String one4 = new String ("One");
        System.out.println(one1 == one2);
        System.out.println(one1.equals(one2));
        System.out.println(one2.equals(one3));
        System.out.println(one2 == one3);
        System.out.println(one3.equals(one4));
        System.out.println(one3 == one4);
        System.out.println( "A" .compareTo( "B"));

        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        list.add(null);
        list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(list);
    }}

