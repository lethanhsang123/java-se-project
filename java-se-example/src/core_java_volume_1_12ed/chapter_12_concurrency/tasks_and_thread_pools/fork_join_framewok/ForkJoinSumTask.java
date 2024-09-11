package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.fork_join_framewok;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10; // threshold for splitting tasks
    private final int[] array;
    private final int start;
    private final int end;

    public ForkJoinSumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // Base case: if the task is small enough, compute directly
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            ForkJoinSumTask leftTask = new ForkJoinSumTask(array, start, mid);
            ForkJoinSumTask rightTask = new ForkJoinSumTask(array, mid, end);

            // Fork the left subtask
            leftTask.fork();

            // Compute the right subtask directly
            int rightResult = rightTask.compute();

            // Join the left task (waits for the result)
            int leftResult = leftTask.join();

            // Combine the results of the two subtasks
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Create the task and the pool
        ForkJoinSumTask task = new ForkJoinSumTask(array, 0, array.length);
        ForkJoinPool pool = new ForkJoinPool();

        // Invoke the task and print the result
        int result = pool.invoke(task);
        System.out.println("Sum: " + result); // Expected output: 5050 (sum of 1 to 100)
    }
}
