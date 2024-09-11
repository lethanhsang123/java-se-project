package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule a task to run after a 5-second delay
        scheduler.schedule(() -> {
            System.out.println("Task executed after delay by " + Thread.currentThread().getName());
        }, 5, TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
