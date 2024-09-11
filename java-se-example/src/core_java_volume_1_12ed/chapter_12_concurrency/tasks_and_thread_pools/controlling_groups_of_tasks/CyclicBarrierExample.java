package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.controlling_groups_of_tasks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("All tasks have arrived at the barrier. Proceeding...");
        });

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is working");
            try {
                Thread.sleep(2000); // Simulate work
                barrier.await(); // Wait at the barrier
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        // Start three threads
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }

}
