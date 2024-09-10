package core_java_volume_1_12ed.chapter_12_concurrency.sync.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private AtomicInteger counter = new AtomicInteger(0);

    public void incrementCounter() {
        // Atomic increment
        int newValue = counter.incrementAndGet();
        System.out.println("Incremented value: " + newValue);
    }

    public static void main(String[] args) {
        AtomicExample example = new AtomicExample();

        // Simulate multiple threads incrementing the counter
        Runnable task = example::incrementCounter;
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
