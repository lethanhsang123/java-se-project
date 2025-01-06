package core_java_volume_2_11ed.chapter02_io.io_streams.standard;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {

    public static void main(String[] args) {
        String data = "Hello World!";
        String filename = "src/core_java_volume_2_11ed/chapter02_io/io_streams/output.txt";
        writeToFile(filename, data);
    }

    public static void writeToFile(String filename, String data) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            // Convert string to bytes
            byte[] bytes = data.getBytes();

            // Write bytes to the file
            fos.write(bytes);

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void writeToFileWithBuffer(String filename, String data) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename))) {
            bos.write(data.getBytes());
            System.out.println("Buffered data written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

}
