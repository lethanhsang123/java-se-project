package core_java_volume_1_12ed.chapter_12_concurrency.sync.condition_object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition(); // Condition for producer
    private final Condition notEmpty = lock.newCondition(); // Condition for consumer
    private final int[] buffer = new int[10];
    private int count = 0, putIndex = 0, takeIndex = 0;

    // Producer method to add items to the buffer
    public void produce(int item) throws InterruptedException {
        lock.lock();  // Acquire lock
        try {
            System.out.print(Thread.currentThread().getName() + " | Start procedure" );
            while (count == buffer.length) {
                System.out.print(" | Waiting");
                notFull.await();  // Wait for space in buffer => releases the lock,
                // but only one thread can proceed when the condition is signaled and the lock is re-acquired.
                //  it releases the lock, allowing a consumer thread to acquire the lock and modify the count safely.
                //  When the consumer is done, it signals the producer (notEmpty.signal()),
                //  and the producer will resume from await() only when it re-acquires the lock.
            }
            System.out.println(" | Value: " + item);
            buffer[putIndex] = item;  // Add item to buffer
            putIndex = (putIndex + 1) % buffer.length;  // Circular buffer
            count++;
            notEmpty.signal();  // Signal that buffer is not empty
        } finally {
            lock.unlock();  // Release lock
        }
    }

    // Consumer method to remove items from the buffer
    public int consume() throws InterruptedException {
        lock.lock();  // Acquire lock
        try {
            System.out.print(Thread.currentThread().getName() + " | Start consume" );
            while (count == 0) {
                System.out.println(" | Waiting");
                notEmpty.await();  // Wait for items in buffer
            }
            int item = buffer[takeIndex];  // Consume item from buffer
            System.out.println(" | Value: " + item);
            takeIndex = (takeIndex + 1) % buffer.length;
            count--;
            notFull.signal();  // Signal that buffer is not full
            return item;
        } finally {
            lock.unlock();  // Release lock
        }
    }

    public static void main(String[] args) {
        ConditionExample pc = new ConditionExample();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    pc.produce(i);
//                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    int item = pc.consume();
//                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }

}
