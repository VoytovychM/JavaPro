package lesson20240527;

public class SyncProblem {
    static Object food = new Object();
    static Object milk = new Object();


    public static void main(String[] args) {
        new Thread(new FeedCatTask()).start();
//        new Thread(new FeedCatTask()).start();
        new Thread(new FeedDogTask()).start();
    }

    static class FeedCatTask implements Runnable{

        @Override
        public void run() {
            synchronized (food) {
                System.out.println(Thread.currentThread().getName() + " feeds cat");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (milk) {
                    System.out.println(Thread.currentThread().getName() + " gives cat milk");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class FeedDogTask implements Runnable{

        @Override
        public void run() {
            synchronized (milk) {
                System.out.println(Thread.currentThread().getName() + " gives dog milk");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (food) {
                    System.out.println(Thread.currentThread().getName() + " feeds dog");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }



}
