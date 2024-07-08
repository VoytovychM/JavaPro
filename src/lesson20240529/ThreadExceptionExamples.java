package lesson20240529;

public class ThreadExceptionExamples {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("General logic for exception in " + thread.getName() + ", exception message: " + exception.getMessage());
        });

        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 10) {
                try {
                    System.out.println(i++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            throw new RuntimeException("some error in additional thread");
        });
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Special logic for exception in " + t.getName() + ", exception message: " + e.getMessage());
        });
        thread.start();

        new Thread(() -> {
            int i = 0;
            while (i < 10) {
                try {
                    System.out.println(i++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            throw new RuntimeException("some error in additional thread");
        }).start();

        Thread.sleep(5000);
        System.out.println(1 /0);

        System.out.println("Some main logic");
        System.out.println("Main end");
    }

}

