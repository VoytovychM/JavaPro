package lesson20240527;

public class SynchExamples {
    static Object mutex = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + " actions in synch block");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " actions after synch block");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");

        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + " actions in synch block");
                int counter = 0;
                for (int i = 0; i < 10; i++) {
                    System.out.println(counter++);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + " actions after synch block");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });

        thread1.start();
        thread2.start();


    }




}
