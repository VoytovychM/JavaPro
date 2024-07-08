package lesson20240527;

public class SynchMethodExamples {
    public static void main(String[] args) {
        SynchMethodExamples examples = new SynchMethodExamples();

        new Thread(examples::method1, "Thread 1").start();
        new Thread(examples::method2, "Thread 2").start();

        new Thread(SynchMethodExamples::staticMethod1, "Thread 3").start();
        new Thread(SynchMethodExamples::staticMethod2, "Thread 4").start();

        synchronized (examples) {
            System.out.println("Main actions, synch on examples");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (SynchMethodExamples.class) {
            System.out.println("Main actions, synch on SynchMethodExamples.class");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public synchronized void method1() {
//        synchronized (this) {
        System.out.println(Thread.currentThread().getName() + ": method1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }

    public synchronized void method2() {
//        synchronized (this) {
        System.out.println(Thread.currentThread().getName() + ": method2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }

    public synchronized static void staticMethod1() {
//        synchronized (SynchMethodExamples.class) {
        System.out.println(Thread.currentThread().getName() + ": staticMethod1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }

    public synchronized static void staticMethod2() {
//        synchronized (SynchMethodExamples.class) {
        System.out.println(Thread.currentThread().getName() + ": staticMethod2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        }
    }



}
