package java_core.core_java_volume_2_11ed.chapter02_io.io_streams.standard;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

    public static void main(String[] args) throws IOException {
        String filename = "src/java_core.core_java_volume_2_11ed/chapter02_io/io_streams/file.txt";
//        readFile(filename);
        readAllBytesOfFile(filename);
    }

    private static void readFile(String filePath) throws IOException {

        try (InputStream inputStream = new FileInputStream(filePath)) {
            int data;
            System.out.println("Reading file content:");

            // read return -1 => end file
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void readAllBytesOfFile(String filePath) throws IOException {

        try (InputStream inputStream = new FileInputStream(filePath)) {
            System.out.println("Reading file content:");
            byte[] bytes = inputStream.readAllBytes();

            // Convert the byte array to a String and print the content
            String content = new String(bytes);
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
