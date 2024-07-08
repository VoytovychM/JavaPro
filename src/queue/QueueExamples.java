package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();  // FIFO
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.poll());  // no exception
        System.out.println(queue.peek()); // no exception
//
//        for(String s : queue){
//            System.out.println(s);
//        }
//
//        Deque<String>  deque = new ArrayDeque<>();   // двунаправленная очередь
//        deque.add ("One");
//        deque.add ("Two");
//        deque.add("Three");
//        deque = new LinkedList<>();
//        deque.addFirst("One");
//        deque.addLast("Three");
//        deque.addLast("Two");
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeLast());


    }
}
