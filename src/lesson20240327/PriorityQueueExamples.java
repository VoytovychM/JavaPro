package lesson20240327;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExamples {
    public static void main(String[] args) {
         // min binary heap
        Queue<Integer> costs = new PriorityQueue<>();
        costs.add(12);
        costs.add(21);
        costs.add(2);
        costs.add(30);
        costs.add(21);
        costs.add(31);
        System.out.println(costs.peek());
        System.out.println(costs);
        System.out.println(costs.poll());
         // max binary heap
        System.out.println("-----------");
        costs = new PriorityQueue<>(Comparator.reverseOrder());
        costs.add(12);
        costs.add(21);
        costs.add(2);
        costs.add(30);
        costs.add(21);
        costs.add(31);
        System.out.println(costs);
        System.out.println(costs.poll());

    }
}
