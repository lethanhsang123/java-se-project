package core_java_volume_1_12ed.chapter_12_concurrency.thread_properties;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocalData = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int initialValue = threadLocalData.get();
            System.out.println(Thread.currentThread().getName() + " initial value: " + initialValue);

            // Modify thread-specific data
            threadLocalData.set(initialValue + 1);
            System.out.println(Thread.currentThread().getName() + " new value: " + threadLocalData.get());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
