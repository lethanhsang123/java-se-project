package java_core.ibm.nio.file_locking;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileLocking {

    private static final String FILE_PATH = "src/java_core/ibm/nio/file_locking/file_locking.txt";

    public static void main(String[] args) {
        // Prepare a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit multiple tasks that write to the same file
        for (int i = 0; i < 4; i++) {
            executor.submit(() -> {
                try {
                    testLockFile();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
    }

    /**
     * Attempts to lock a file for exclusive access.
     * The file is specified by the FILE_PATH constant.
     * If the file is successfully locked, the lock is released.
     *
     * @throws FileNotFoundException if the file does not exist.
     */
    private static void testLockFile() throws FileNotFoundException {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_PATH, "rw");
             FileChannel fc = raf.getChannel();
             FileLock lock = fc.lock();) {
            String thread = Thread.currentThread().getName();
            // Acquire an exclusive lock on this channel's file
            System.out.println("Thread " + thread + " acquired the lock.");

            // Simulate some work by writing thread-specific data into the file
            String data = "Thread " + thread + " was here.\n";
            ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());

            // Move to the end of the file before writing
            fc.position(fc.size());
            fc.write(buffer);

            // Hold the lock for a short period to simulate processing
            Thread.sleep(2000);

            // Release the lock
            lock.release();
            System.out.println("Thread " + thread + " released the lock.");
        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }
    }

}
