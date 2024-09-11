package core_java_volume_1_12ed.chapter_12_concurrency.asynchronous_computations;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionHandling {

    public static void main(String[] args) {
        // Simulate a task that throws an exception
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Success";
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return "Fallback value";
        });

        // Print the result
        System.out.println("Result: " + future.join());
    }

}
