package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class UseQueue {
    static class Producer{

        private Queue<String> queue;
        private int k = 0;
        public Producer(Queue<String> queue) {
            this.queue = queue;
        }

        public void generateData(){
            for (int i = 0; i < 5; i++) {

                String data = "Data from " + this.toString() + " " + k++;
                System.out.println("Generating: " + data);
                queue.add(data);
            }
        }
    }
    static  class Consumer{
        private Queue<String> queue;

        public Consumer(Queue<String> queue) {

            this.queue = queue;
        }
        public void consumeData(){
            while (!queue.isEmpty()){
                String data = queue.remove();
                System.out.println("Processing " + data);
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> queue =  new ArrayDeque<>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer1.generateData();
        producer2.generateData();
        consumer.consumeData();

    }
}
