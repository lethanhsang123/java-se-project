package core_java_volume_1_12ed.chapter_12_concurrency.asynchronous_computations;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTimeout {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000); // Simulate long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Completed";
        }).orTimeout(3, TimeUnit.SECONDS);

        try {
            System.out.println(future.join());
        } catch (Exception e) {
            System.out.println("Timeout occurred: " + e.getMessage());
        }
    }
}