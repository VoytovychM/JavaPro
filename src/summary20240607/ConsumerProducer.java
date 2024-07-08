package summary20240607;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducer {

    // 3. BlockingQueue:
    //Класс Продьюсер - генерирует сообщения в очередь
    //Класс Консьюмер - забирает сообщения из очереди
    //Задача - реализовать класс Consumer, который будет анализировать сообщения в очереди и
    //при входящем сообщении "exit" заканчивать работу.
    //При реализации можно использовать одну из стандартных реализаций BlockingQueue из библиотеки
    //или собственный вариант BlockingQueue.

    static class Producer implements Runnable{

        BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queue.put("exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Consumer implements Runnable {

        BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            boolean shouldExit = false;
            while (!shouldExit) {
                try {
                    String data = queue.take();
                    if (!"exit".equals(data)) {
                        System.out.println("Consumer processes: " + data);
                    } else {
                        shouldExit = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queue.put("exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }



}