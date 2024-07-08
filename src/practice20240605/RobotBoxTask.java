package practice20240605;

public class RobotBoxTask {

    static class BoxPlace {
        private boolean hasBox = false;

        public synchronized void putBox(String robotName) throws InterruptedException {
            while (hasBox) {
                wait();
            }
            hasBox = true;
            System.out.println(robotName + " placed a box.");
            notifyAll();
        }

        public synchronized void takeBox(String robotName) throws InterruptedException {
            while (!hasBox) {
                wait();
            }
            hasBox = false;
            System.out.println(robotName + " took the box.");
            notifyAll();
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
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    boxPlace.putBox(name);
                    Thread.sleep(1000); // Simulate time taken to place the box
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " interrupted");
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
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    boxPlace.takeBox(name);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " interrupted");
            }
        }
    }

    public static void main(String[] args) {
        BoxPlace boxPlace = new BoxPlace();

        Thread robotPutThread = new Thread(new RobotPut(boxPlace, "Eva"));
        Thread robotTakeThread = new Thread(new RobotTake(boxPlace, "Wally"));

        robotPutThread.start();
        robotTakeThread.start();

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        robotPutThread.interrupt();
        robotTakeThread.interrupt();

        try{
            robotPutThread.join();
            robotTakeThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main thread is finished");
    }
}