package start.iteratorSamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 1. Дан список из числовых данных.
//С помощью итератора:
//a). Напечатать только четные числа из списка.
//b). Удалить из списка все числа, заканчивающиеся на 0.
//c). Составить список квадратов чисел.
public class IteratorTasks {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 6, 8, 90, 33, 23));
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
        iterator = integerList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 10 == 0) {
                iterator.remove();
            }
        }
        System.out.println(integerList);

        List<Integer> squaresList = new ArrayList<>();
        iterator = integerList.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            squaresList.add(num * num);
        }
        System.out.println(squaresList);
    }
}

