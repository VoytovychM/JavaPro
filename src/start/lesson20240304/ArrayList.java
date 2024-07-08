package start.lesson20240304;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList {
 public static void main(String[] args) {

//        List<String> list = new ArrayList<String>();
  List<String> list = new java.util.ArrayList<>();
  list.add("A");
  list.add("B");
  list.add("C");

  System.out.println(list.get(0));
  System.out.println(list.get(1));
  System.out.println(list.get(2));

  String[] array = new String[3];
  array[0] = "A";
  array[1] = "B";
  array[2] = "C";

  Object[] objects = new Object[3];
  objects[0] = 1;
  objects[1] = "string";

  List<Object> objectList = new java.util.ArrayList<>();
  objectList.add(1);
  objectList.add("string");
  Object o1 = objectList.get(0);
  Object o2 = objectList.get(1);

  List<Double> doubleList = new java.util.ArrayList<>(5);
  doubleList.add(4.0);
  doubleList.add(5.0);
  doubleList.add(1.0);
  doubleList.add(6.0);
  doubleList.add(2.0);
  doubleList.add(3.0);
  System.out.println(doubleList);

  for (int i = 0; i < doubleList.size(); i++) {
   System.out.println(doubleList.get(i));
  }

  for (Double d : doubleList) {
   System.out.println(d);
  }

//        Arrays.sort();
  Collections.sort(doubleList);
  System.out.println(doubleList);

  Collections.reverse(doubleList);
  System.out.println(doubleList);

  // <>
  List<Cat> catList = new java.util.ArrayList<>();

  List<String> textList = new java.util.ArrayList<>();
  textList.add("Java");
  textList.add("is");
  textList.add("the");
  textList.add("best");
  textList.add("programming");
  textList.add("language");

  System.out.println(textList.size());
  System.out.println(textList.isEmpty());
  System.out.println(textList.contains("the"));
  System.out.println(textList.indexOf("the"));

  System.out.println(textList);
  textList.set(3, "worst");
  System.out.println(textList);

  textList.add("!!!");
  textList.add(3,"not");
  System.out.println(textList);
  for (String s : textList) {
   System.out.println(s);
  }

  List<String> newList = Arrays.asList("A", "B", "C");
  textList.addAll(newList);
  System.out.println(textList);

  textList.remove(9);
  System.out.println(textList);
  textList.remove("A");
  textList.remove("C");
  System.out.println(textList);

  java.util.ArrayList<String> newLink = (java.util.ArrayList<String>) textList;
  newLink.trimToSize();


  // CAPSLOCK
  for (int i = 0; i < textList.size(); i++) {
   textList.set(i, textList.get(i).toUpperCase());
  }
  System.out.println(textList);

  // удалить все четные числа
  List<Double> doubles = new java.util.ArrayList<>();
  for (Double d : doubleList) {
   if (d % 2 == 1) {
    doubles.add(d);
   }
  }
  doubleList = doubles;
  System.out.println(doubleList);

  // вернуть слово из 3 символов
  String word = null;
  for (String t : textList){
   if (t.length() == 3) {
    word = t;
    break;
   }
  }
  System.out.println(word);


  int[][] ints = new int[3][3];

  List<List<Integer>> listOfLists = new java.util.ArrayList<>();
  List<Integer> list1 = Arrays.asList(1 ,2);
  List<Integer> list2 = Arrays.asList(4 ,5, 6);
  List<Integer> list3 = Arrays.asList(7 ,8, 9, 10);
  listOfLists.add(list1);
  listOfLists.add(list2);
  listOfLists.add(list3);
  System.out.println(listOfLists);
  for (List<Integer> innerList : listOfLists) {
   for (Integer i : innerList) {
    System.out.println(i);
   }
  }
  Integer element = listOfLists.get(1).get(2);
 }


}
