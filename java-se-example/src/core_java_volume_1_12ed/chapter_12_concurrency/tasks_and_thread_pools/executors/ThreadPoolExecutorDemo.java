package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // Core pool size
                4, // Maximum pool size
                30, // Keep-alive time
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), // Work queue with capacity of 2
                new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
        );

        // Submit tasks to the executor
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate task execution
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
