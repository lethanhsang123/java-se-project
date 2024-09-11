package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.controlling_groups_of_tasks;

import java.util.concurrent.*;

public class CompletionServiceExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            completionService.submit(() -> {
                Thread.sleep(2000);
                return "Task " + taskId + " completed by " + Thread.currentThread().getName();
            });
        }

        // Process tasks as they complete
        for (int i = 0; i < 5; i++) {
            Future<String> result = completionService.take();
            System.out.println(result.get());
        }

        executor.shutdown();
    }

}
