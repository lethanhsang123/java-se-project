package core_java_volume_1_12ed.chapter_12_concurrency.tasks_and_thread_pools.fork_join_framewok;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinSortTask extends RecursiveAction {
    private static final int THRESHOLD = 10;
    private final int[] array;
    private final int start;
    private final int end;

    public ForkJoinSortTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            Arrays.sort(array, start, end);
        } else {
            int mid = (start + end) / 2;
            ForkJoinSortTask leftTask = new ForkJoinSortTask(array, start, mid);
            ForkJoinSortTask rightTask = new ForkJoinSortTask(array, mid, end);

            invokeAll(leftTask, rightTask); // Fork both tasks and wait for completion
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 3, 15, 7, 8, 23, 74, 18, 4, 36};

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSortTask task = new ForkJoinSortTask(array, 0, array.length);

        // Execute the sort task
        pool.invoke(task);

        // Print the sorted array
        System.out.println(Arrays.toString(array));
    }
}
