package practice20240605;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RobotBoxTaskWithQueue {


        static class BoxPlace {
            final private BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

            public void putBox(String robotName) throws InterruptedException {
                queue.put(robotName);
                System.out.println(robotName + " placed a box.");
            }

            public void takeBox(String robotName) throws InterruptedException {
                queue.take();
                System.out.println(robotName + " took the box.");
            }
        }

        static class RobotPut implements Runnable {
            private BoxPlace boxPlace;
            private String name;

            public RobotPut(BoxPlace boxPlace, String name) {
                this.boxPlace = boxPlace;
                this.name = name;
            }

            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            boxPlace.putBox(name);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(name + " finished its work");
                    }
                }
            }
        }

        static class RobotTake implements Runnable {
            private BoxPlace boxPlace;
            private String name;

            public RobotTake(BoxPlace boxPlace, String name) {
                this.boxPlace = boxPlace;
                this.name = name;
            }

            @Override
            public void run() {
                synchronized (this){
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        boxPlace.takeBox(name);
                        Thread.sleep(1000);

                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(name + " finished its work");
                }

        }
            }
        }
        public static void main(String[] args) {
            BoxPlace boxPlace = new BoxPlace();

            Thread robotPutThread = new Thread(new RobotPut(boxPlace, "Eva"));
            Thread robotTakeThread1 = new Thread(new RobotTake(boxPlace, "Wally"));
            Thread robotTakeThread2 = new Thread(new RobotTake(boxPlace, "Bubu"));

            robotPutThread.start();
            robotTakeThread1.start();
            robotTakeThread2.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            robotPutThread.interrupt();
            robotTakeThread1.interrupt();
            robotTakeThread2.interrupt();

            try {
                robotPutThread.join();
                robotTakeThread1.join();
                robotTakeThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main thread is finished");
        }
    }

