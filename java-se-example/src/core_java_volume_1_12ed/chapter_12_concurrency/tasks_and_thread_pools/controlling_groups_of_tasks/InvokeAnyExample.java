package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.controlling_groups_of_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyExample {

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

        // Submit tasks and return result of the first task that completes
        String result = executor.invokeAny(taskList);
        System.out.println(result);

        executor.shutdown();
    }

}
