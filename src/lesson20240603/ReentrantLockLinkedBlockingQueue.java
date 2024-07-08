package lesson20240603;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockLinkedBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock(true);

    private Condition condition = lock.newCondition();


    public void put(T t) {
        lock.lock();
        try {
            queue.add(t);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.awaitUninterruptibly();
            }
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

}
