package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.callables_and_futures;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        // Create an ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Define a Callable task
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                    Thread.sleep(3_000);
                }
                return sum;
            }
        };

        // Submit the task for execution
        Future<Integer> future = executor.submit(sumTask);

        try {
            // Get the result of the computation
            Integer result = future.get();
            System.out.println("Sum of integers from 1 to 10 is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }
}
