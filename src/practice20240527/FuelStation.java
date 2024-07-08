package practice20240527;

public class FuelStation {
    public static void main(String[] args) throws InterruptedException {
        Fuel fuel = new Fuel(1000);

        Thread car1 = new Thread(new Car(1, fuel));
        Thread car2 = new Thread(new Car(2, fuel));
        Thread car3 = new Thread(new Car(3, fuel));

        car1.start();
        car2.start();
        car3.start();

        car1.join();
        car2.join();
        car3.join();

        System.out.println("The rest of fuel: " + fuel.getFuel());
    }

    static class Fuel {
        private int fuel;

        public Fuel(int fuel) {
            this.fuel = fuel;
        }

        public synchronized int addFuel(int amount) {
            fuel += amount;
            return fuel;
        }

        public synchronized int consumeFuel(int amount) {
            if (amount > fuel) {
                System.out.println("There is no available fuel");
            } else {
                fuel -= amount;
            }
            return fuel;
        }

        public synchronized int getFuel() {
            return fuel;
        }
    }

    static class Car implements Runnable {
        private int amountToFuel = 40;
        private Fuel barrelOfFuel;
        private int numberOfThread;

        public Car(int numberOfThread, Fuel barrelOfFuel) {
            this.numberOfThread = numberOfThread;
            this.barrelOfFuel = barrelOfFuel;
        }

        public int getAmountToFuel() {
            return amountToFuel;
        }

        @Override
        public void run() {
            synchronized (barrelOfFuel) {
                if (barrelOfFuel.getFuel() >= amountToFuel) {
                    barrelOfFuel.consumeFuel(amountToFuel);
                    System.out.println("Car " + numberOfThread + " filled up.");
                } else {
                    System.out.println("No available fuel for car " + numberOfThread);
                }
            }
        }
    }
}