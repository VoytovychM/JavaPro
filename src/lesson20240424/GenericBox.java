package lesson20240424;

//1. Создать generic класс Box<Item>, в котором можно хранить предметы любого типа.
//        Реализовать методы:
//        - put(Item item) - положить предмет
//        - get() - извлечь предмет
//        - remove() - извлечь и удалить предмет

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericBox <Item> {
    private Item item;

    public GenericBox(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void put(Item item){
        this.item = item;
    }

    public Item get(){
        return item;
    }

    public Item remove(){
       Item removedItem = item;
       item = null;
       return removedItem;
    }

    //Написать generic метод makeList(), который преобразует массив в список.
    private static <T> List<T> makeListFromTwoElements(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public static <T> Object[] makeArray (List<T> list){
//      T[] t = (T[]) new Object[list.size()]; // poss
//      int i = 0;
//      for (T element : list){
//          t[i++] = element;
//
//      }
//      return t;
        return list.toArray();
    }



    public static void main(String[] args) {
        GenericBox<String> stringGenericBox = new GenericBox<>("String");
        stringGenericBox.put("String");

        System.out.println(stringGenericBox.get());
        System.out.println(stringGenericBox.remove());

        GenericBox<Integer> integerGenericBox = new GenericBox<>(123);
        integerGenericBox.put(123);
        System.out.println(integerGenericBox.get());
        System.out.println(integerGenericBox.remove());

        Integer[] array = {1,2,3,4,5,6};
        List<Integer> intList = makeListFromTwoElements(array);
        System.out.println(intList);

        String[] strings ={"Hello", "World"};
        List<String> stringList = makeListFromTwoElements(strings);
        System.out.println(stringList);

    // Написать Generic метод makeArray(), который преобразует список в массив.

      Object[] integers = makeArray(intList);
        System.out.println(Arrays.toString(integers));
        Object[] strings1 = makeArray(stringList);
        System.out.println(Arrays.toString(strings1));

    }
}
