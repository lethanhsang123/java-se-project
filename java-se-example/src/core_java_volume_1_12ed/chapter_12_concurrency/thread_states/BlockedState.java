package core_java_volume_1_12ed.chapter_12_concurrency.thread_states;

public class BlockedState {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Runnable task = () -> {
//            resource.useResource();
            resource.criticalSection();
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        System.out.println("Thread Status 1: " + thread1.getState());
        System.out.println("Thread Status 2: " + thread2.getState());

        thread1.start();
        System.out.println("Thread Status 1: " + thread1.getState());
        System.out.println("Thread Status 2: " + thread2.getState());
        thread2.start();

        System.out.println("Thread Status 1: " + thread1.getState());
        System.out.println("Thread Status 2: " + thread2.getState());
    }
}


class Resource {

    public void criticalSection() {
        synchronized (this) {  // Synchronized block
            System.out.println(Thread.currentThread().getName() + " inside critical section");
            try {
                Thread.sleep(2000);  // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " exiting critical section");
        }
    }

    // Synchronized Methods
    public synchronized void useResource() {
        System.out.println("Current name: " + Thread.currentThread().getName() + " | Status: " + Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getName() + " using resource");
        try {
            Thread.sleep(2000);  // Simulate some work with the resource
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " done using resource");
    }
}