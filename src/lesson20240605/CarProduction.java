package lesson20240605;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class CarProduction {

       static class Wheel{

       }
       static class CarBody{

       }
    static class WheelProduction implements Runnable{
           private BlockingDeque<Wheel> wheelBlockingDeque;

        public WheelProduction(BlockingDeque<Wheel> wheelBlockingDeque) {
            this.wheelBlockingDeque = wheelBlockingDeque;
        }

        @Override
        public void run() {
          try{
              while (true){
                  wheelBlockingDeque.put(new Wheel());
                  System.out.println("Production of wheels in action");
                  Thread.sleep(5000);
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        }
    }

    static class CarBodyProduction implements Runnable{
           private BlockingQueue<CarBody> carBodyBlockingQueue;

        public CarBodyProduction(BlockingQueue<CarBody> carBodyBlockingQueue) {
            this.carBodyBlockingQueue = carBodyBlockingQueue;
        }

        @Override
        public void run() {
            try{
                while(true){
                    carBodyBlockingQueue.put(new CarBody());
                    System.out.println("Production of car body in action");
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    static class Car implements Runnable{
          private BlockingQueue <Wheel> wheelBlockingQueue;
          private BlockingQueue<CarBody> carBodyBlockingQueue;

        public Car (BlockingQueue<Wheel> wheelBlockingQueue, BlockingQueue<CarBody> carBodyBlockingQueue, CarBody carBody) {
            this.wheelBlockingQueue = wheelBlockingQueue;
            this.carBodyBlockingQueue = carBodyBlockingQueue;

        }

        @Override
        public void run() {
         try{
             List<Wheel> wheels = new ArrayList<>();
             for (int i = 0; i < 4; i++) {
                 wheels.add(wheelBlockingQueue.take());
             }
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
        }
    }

    }


