package start.pracArray;

import java.util.Arrays;

public class DynamicIntArray {

    private int length; //реальный размер хранимых данных
    private int capacity; //общий размер массива
    private int[] arr;
    public static final int DEFAULT_CAPACITY = 10;
    public static final double PERCENT_CHANGE = 1.5; // 50%

    public DynamicIntArray() {
        arr = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public DynamicIntArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    @Override
    public String toString() {
        return "DynamicIntArray{" +
                "length=" + length +
                ", capacity=" + capacity +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    public void add(int element) {
        if(length < capacity) {
            arr[length++] = element;
        }
        else {
            int newCapacity = ((int)(capacity * PERCENT_CHANGE));
            int[] newArr = new int[newCapacity];
            capacity = newCapacity;
            copyElements(arr, newArr);
            arr = newArr;
            add(element);
        }
    }

    public void add(int[] elements) {
        if (length + elements.length < capacity) {
            copyElements(arr, elements, length);
            length = length + elements.length;
        } else {
            int newCapacity = ((int)(capacity * PERCENT_CHANGE));
            if(newCapacity < (length + elements.length)) {
                newCapacity = (int)((length + elements.length) * PERCENT_CHANGE);
            }
            int[] newArr = new int[newCapacity];
            capacity = newCapacity;
            copyElements(arr, newArr);
            arr = newArr;
            add(elements);
        }
    }
    public void delete (int index) {
        for (int i = index; i < arr.length - 1; i++) {
            int tmp = arr[i + 1];
            arr[i] = tmp;
        }
        arr[length] = 0;
        length--;
    }

    public void insert (int index, int element) {
        if (length < capacity) {
            for (int i = capacity - 1; i > index; i--) {
                int tmp = arr[i - 1];
                arr[i] = tmp;
            }
            arr[index] = element;
            length++;
        } else {
            int[] newArr = new int[((int)(capacity * PERCENT_CHANGE))];
            capacity = ((int)(capacity * PERCENT_CHANGE));
            copyElements(arr, newArr);
            arr = newArr;
            insert(index, element);
        }
    }

    public int getElem(int index) {
        return arr[index];
    }

    private void copyElements(int[] oldArr, int[] newArr) {
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
    }
    private void copyElements(int[] oldArr, int[] newElements, int startIndex) {
        int start = startIndex;
        for (int i = 0; i < newElements.length; i++) {
            oldArr[start] = newElements[i];
            start++;
        }
    }
}

//1) У вас есть класс DynamicIntArray. Внутри него есть 3 характеристики:
//        - int lenght(реальный размер хранимых данных),
//        - int capacity(размер массива),
//        - массив int размером capacity (arr[capacity]),
//        константы:
//        - начальный размер массива по умолчанию (DEFAULT_CAPACITY),
//        - % изменения размера массива при автоматическом увеличениию (PROCENT_CHANGE).
//        Реализуйте 2 конструктора:
//        - по умолчанию (создается массив arr размером DEFAULT_CAPACITY)
//        - с параметром capacity (создается массив arr размер которого передается параметром  capacity).
//        Реализуйте методы:
//        - add(int element) - добавление элемента в конец (не забывайте про ограничения размера массива).
//        - add(int[] elements) - добавление массива элементов в конец нашего массива(не забывайте про ограничения размера массива).
//        - insert (int index, int element) - вставка элемента в место с нужным индексом (не забывайте про ограничения размера массива
//        и смещение элементов вправо)
//        - delete (int index) - удаление элемента (не забывайте про смещение элементов влево при операции).
//        - getElem(int index) - вернуть значение элемента по index

