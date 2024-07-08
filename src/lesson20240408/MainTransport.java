package lesson20240408;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainTransport {
    public static void main(String[] args) {


    Transport transport1 = new Transport("Ambulance", 1, TransportTypes.AMBULANCE);
    Transport transport2 = new Transport("Bus", 2, TransportTypes.BUS);
    Transport transport3 = new Transport("AID", 2, TransportTypes.SERVICE);
    Transport transport4 = new Transport("Audi", 2, TransportTypes.CAR);
    Transport transport5 = new Transport("Mercedes", 2, TransportTypes.CAR);

    Queue<Transport> transportQueue = new PriorityQueue<>();
    transportQueue.add(transport1);
        transportQueue.add(transport2);
        transportQueue.add(transport3);
        transportQueue.add(transport4);
        transportQueue.add(transport5);


        System.out.println(transportQueue.peek());

        Queue<Transport>transportQueuePick = new PriorityQueue<>(new Comparator<Transport>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                if(o1.getTransportTypes().equals(TransportTypes.SERVICE) || o1.getTransportTypes().equals(TransportTypes.CAR)){
                    o1.setPriorityLevel(3);
                }
                if(o2.getTransportTypes().equals(TransportTypes.SERVICE) || o2.getTransportTypes().equals(TransportTypes.CAR)){
                    o2.setPriorityLevel(3);
                }
                return Integer.compare(o1.getPriorityLevel(), o2.getPriorityLevel());
            }
        });

      transportQueuePick.addAll(transportQueue);
        System.out.println(transportQueue);
//        System.out.println(transportQueue.remove());
        System.out.println(transportQueuePick.peek());
        System.out.println(transportQueuePick.peek());

        Queue<Transport> transportQueueEmergency = new PriorityQueue<>(new Comparator<Transport>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                if (o1.getTransportTypes().equals(TransportTypes.SERVICE)){
                    o1.setPriorityLevel(1);
                }
                if(o2.getTransportTypes().equals(TransportTypes.SERVICE)){
                    o2.setPriorityLevel(1);
                }
                if(o1.getTransportTypes().equals(TransportTypes.AMBULANCE)){
                    o1.setPriorityLevel(2);
                }
                if(o2.getTransportTypes().equals(TransportTypes.AMBULANCE)){
                    o2.setPriorityLevel(2);
                }
                if(o1.getTransportTypes().equals(TransportTypes.CAR)){
                    o1.setPriorityLevel(2);
                }
                if(o2.getTransportTypes().equals(TransportTypes.CAR)){
                    o2.setPriorityLevel(2);

            }
                return Integer.compare(o1.getPriorityLevel(), o2.getPriorityLevel());
            }
        });
        System.out.println("---------");
       transportQueueEmergency.addAll(transportQueue);
       System.out.println(transportQueueEmergency);


}
}