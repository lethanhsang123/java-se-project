package core_java_volume_1_12ed.chapter_12_concurrency.asynchronous_computations;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCombine {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        // Combine the results of future1 and future2
        CompletableFuture<Integer> result = future1.thenCombine(future2, (a, b) -> a + b);

        // Wait for the result and print it
        System.out.println("Result: " + result.join());
    }
}
