package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.controlling_groups_of_tasks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is working");
            try {
                Thread.sleep(2000); // Simulate task completion
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown(); // Decrement the latch count
            System.out.println(Thread.currentThread().getName() + " has finished work");
        };

        // Start three threads
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        // Main thread waits for all other threads to finish
        latch.await();
        System.out.println("All tasks have completed");
    }

}
