package lesson20240527;

public class ThreadWithFlag {
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(5000);
        flag = false; // volatile flag 1905677082 1912146723
//        thread.interrupt(); // 1946877558 1957947646
//        flag = false; // without volatile 2414187728 2413295909

        System.out.println("Final value: " + task.counter);

    }

    static class Task implements Runnable {
        long counter = 0;

        @Override
        public void run() {
//            while (!Thread.interrupted()) {
            while (flag) {
                if (counter++ %  1_000_000 == 0) {
                    System.out.println(counter);
                }
            }

        }
    }



}
