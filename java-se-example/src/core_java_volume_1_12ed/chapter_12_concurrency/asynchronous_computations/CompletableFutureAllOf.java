package core_java_volume_1_12ed.chapter_12_concurrency.asynchronous_computations;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAllOf {

    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task 1");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 2");
        });

        // Wait for all tasks to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);

        // Block and wait for all to complete
        allOf.join();

        System.out.println("All tasks completed.");
    }

}
