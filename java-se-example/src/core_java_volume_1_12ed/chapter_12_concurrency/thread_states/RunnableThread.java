package core_java_volume_1_12ed.chapter_12_concurrency.thread_states;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RunnableThread {

    public static void main(String[] args) {

        Runnable cpuBoundTask = () -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Thread state: " + Thread.currentThread().getState());
            for (int i = 0; i < 1_000_000; i++) {
                double result = Math.sin(i) * Math.cos(i);
            }
        };

        System.out.println("Thread main: " + Thread.currentThread().getName());
        Thread thread = new Thread(cpuBoundTask);
        System.out.println("Thread name 1: " + thread.getName());
        System.out.println("Thread state 1: " + thread.getState());
        thread.start();

        Runnable iOBoundTask = () -> {
            try {
                Path path = Paths.get("data.txt");
                AsynchronousFileChannel asyncChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // Non-blocking I/O: Thread stays in RUNNABLE while waiting for file data
                asyncChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    public void completed(Integer result, ByteBuffer buffer) {
                        buffer.flip();
                        System.out.println("Read data: " + new String(buffer.array()));
                    }
                    public void failed(Throwable exc, ByteBuffer buffer) {
                        System.out.println("Failed to read file");
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread thread2 = new Thread(cpuBoundTask);
        System.out.println("Thread name 2: " + thread2.getName());
        System.out.println("Thread state 2: " + thread2.getState());
        thread2.start();

    }

}