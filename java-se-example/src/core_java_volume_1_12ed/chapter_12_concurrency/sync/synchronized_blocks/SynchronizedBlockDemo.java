package core_java_volume_1_12ed.chapter_12_concurrency.sync.synchronized_blocks;

class Example {
    private int count = 0;
    private String name;

    public void method() {
        // This part is not synchronized, so any thread can execute it
        System.out.println("Executing non-synchronized part: " + Thread.currentThread().getName());

        // Synchronized block
        synchronized (this) {
            count++;
            System.out.println("Synchronized block by: " + Thread.currentThread().getName() + " | Count: " + count);
        }

        // Another non-synchronized part
        System.out.println("Non-synchronized part continues: " + Thread.currentThread().getName());
    }
}

public class SynchronizedBlockDemo {
    public static void main(String[] args) throws InterruptedException {
        Example example = new Example();

        Thread t1 = new Thread(example::method, "Thread-1");
        Thread t2 = new Thread(example::method, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
