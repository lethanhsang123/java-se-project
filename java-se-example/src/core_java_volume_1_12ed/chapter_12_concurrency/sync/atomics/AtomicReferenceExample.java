package core_java_volume_1_12ed.chapter_12_concurrency.sync.atomics;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
    private AtomicReference<String> message = new AtomicReference<>("Initial");

    public void updateMessage(String newMessage) {
        // Attempt to update the message atomically
        String oldMessage = message.get();
        boolean updated = message.compareAndSet(oldMessage, newMessage);
        System.out.println("Update success: " + updated + " | New message: " + message.get());
    }

    public static void main(String[] args) {
        AtomicReferenceExample example = new AtomicReferenceExample();

        // Two threads trying to update the same reference
        Runnable task1 = () -> example.updateMessage("Hello from Thread 1");
        Runnable task2 = () -> example.updateMessage("Hello from Thread 2");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
