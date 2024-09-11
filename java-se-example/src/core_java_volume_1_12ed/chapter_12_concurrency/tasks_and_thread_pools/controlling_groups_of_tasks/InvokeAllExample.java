package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.controlling_groups_of_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> taskList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            taskList.add(() -> {
                Thread.sleep(2000);
                return "Task " + taskId + " completed by " + Thread.currentThread().getName();
            });
        }

        // Submit all tasks and wait for their completion
        List<Future<String>> results = executor.invokeAll(taskList);

        // Print results after all tasks have completed
        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        executor.shutdown();
    }

}
