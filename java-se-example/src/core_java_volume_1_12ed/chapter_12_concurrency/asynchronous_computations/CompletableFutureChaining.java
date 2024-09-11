package core_java_volume_1_12ed.chapter_12_concurrency.asynchronous_computations;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChaining {

    public static void main(String[] args) {
        // Asynchronously run a task, then apply transformation to its result
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenApply(greeting -> {
            return greeting + ", World!";
        });

        // Wait for the result and print it
        System.out.println(future.join());
    }

}
