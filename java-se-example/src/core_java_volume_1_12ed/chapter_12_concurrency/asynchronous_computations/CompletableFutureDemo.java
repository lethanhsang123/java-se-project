package core_java_volume_1_12ed.chapter_12_concurrency.asynchronous_computations;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        // Running a task asynchronously
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Asynchronous task running in: " + Thread.currentThread().getName());
        });

        // Wait for the async task to finish (not blocking the main thread)
        future.join(); // Join waits for the task to finish
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }

}
