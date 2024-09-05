package core_java_volume_1_12ed.chapter_12_concurrency.thread_states;

class ResourceA {
    public synchronized void methodA(ResourceB resourceB) {
        System.out.println(Thread.currentThread().getName() + " acquired lock on ResourceA");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        resourceB.methodB();
    }
}

class ResourceB {
    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " acquired lock on ResourceB");
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        Thread thread1 = new Thread(() -> {
            resourceA.methodA(resourceB);  // Acquires lock on resourceA
        });

        Thread thread2 = new Thread(() -> {
            resourceB.methodB();  // Acquires lock on resourceB
            resourceA.methodA(resourceB);  // Tries to acquire lock on resourceA
        });

        thread1.start();
        thread2.start();
    }
}

