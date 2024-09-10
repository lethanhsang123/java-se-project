package core_java_volume_1_12ed.chapter_12_concurrency.sync.synchronized_blocks;

class Counter {
    private int count = 0;

    public void increment() {
        // Synchronized block to increment the counter
        System.out.println(Thread.currentThread().getName() + " Start increment");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " Incrementing");
            count++;
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {}
        }
        System.out.println(Thread.currentThread().getName() + " End increment");
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedBlockExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}
