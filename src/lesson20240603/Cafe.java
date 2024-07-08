package lesson20240603;

//Реализовать модель кафе:
//посетитель (отдельный поток)
//- заходит в кафе
//- делает заказ
//- ждет кофе
//- пьет кофе
//официант (отдельный поток)
//- ждет посетителя
//- готовит кофе
//- приносит посетителю
public class Cafe <T> {
    static Object visitorComes = new Object();
    static Object coffeIsReady = new Object();

    static class Visitor implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " comes in the Cafe");
            synchronized (visitorComes) {
                visitorComes.notify();
            }
            System.out.println(Thread.currentThread().getName() + " makes order");
            synchronized (coffeIsReady) {
                try {
                    coffeIsReady.wait(100_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " drinks coffee");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " says goodbye & goes away");
        }
    }

    static class Waiter implements Runnable {

        @Override
        public void run() {
            synchronized (visitorComes) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waits for visitors");
                    visitorComes.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " receives order, started to make coffee");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (coffeIsReady) {
                coffeIsReady.notify();
                System.out.println(Thread.currentThread().getName() + " bring coffee to the visitor");
            }
        }
    }

    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        Waiter waiter = new Waiter();
        new Thread(visitor, "Visitor").start();
        new Thread(waiter, "Waiter").start();
    }


}