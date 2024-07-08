package start.LinkedListTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {
    // Дан список некоторых упорядоченных данных. Необходимо "честно" перемешать данные,
// т.е. распределить их так, чтобы вероятность нахождения любого элемента на любом месте была бы одинакова.
// Например, задача перемешивания колоды карт.

    public static void main(String[] args) {
        List<String> cards = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        swap(cards, 1, 4);
//        mixCards(lesson20240320.cards);
        Collections.shuffle(cards);
        System.out.println(cards);
    }

    public static void mixCards(List<String> cards) { //это итерация по списку и замена каждого элемента на случайно выбранный элемент из списка.
        Random randCard = new Random();
        for (int i = 1; i < cards.size(); i++) {  //Эта строка запускает цикл, который выполняет итерацию по каждому индексу i от 0 до n-1. Этот цикл гарантирует, что каждая карта в списке будет рассмотрена для перетасовки.
          swap(cards, i, randCard.nextInt(i + 1));
        }
    }

    public static void swap(List<String> cards, int i, int j){
        String tmp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, tmp);
    }


}

