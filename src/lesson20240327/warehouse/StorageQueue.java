package lesson20240327.warehouse;

import java.util.LinkedList;
import java.util.Queue;

public class StorageQueue {
    private Queue<BrickPack> brickPackQueue;
    private int size;
    private int count;

    public StorageQueue(int size) {
        this.size = size;
        brickPackQueue = new LinkedList<>();
    }

    public void print() {
        System.out.println(brickPackQueue);
        System.out.println("Size = " + size);
        System.out.println("Count = " + count);
    }

    public boolean storagePush(BrickPack brickPack) {
        if (brickPack == null) {
            return false;
        }
        if (count < size) {
            brickPackQueue.offer(brickPack);
            count++;
            return true;
        }
        System.err.println("Warehouse is full. Failed to add the package " + brickPack);
        return false;
    }

    public BrickPack storagePeek() {
        if (count > 0) {
            return brickPackQueue.peek();
        }
        System.err.println("Warehouse is empty");
        return null;
    }

    public BrickPack storagePoll() {
        if (count > 0) {
            count--;
            return brickPackQueue.poll();
        }
        System.err.println("Warehouse is empty");
        return null;
    }


}

