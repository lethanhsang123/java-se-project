package core_java_volume_1_12ed.chapter_12_concurrency.thread_states;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();

    public void criticalSection() {
        try {
            if (lock.tryLock()) {  // Try acquiring the lock
                try {
                    // Critical section
                    System.out.println(Thread.currentThread().getName() + " acquired lock");
                    Thread.sleep(1000);  // Simulate work
                } finally {
                    lock.unlock();  // Always unlock
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

