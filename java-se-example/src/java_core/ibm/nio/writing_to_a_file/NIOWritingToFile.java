package java_core.ibm.nio.writing_to_a_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOWritingToFile {

    private static final String FILE_PATH = "src/java_core/ibm/nio/reading_from_file/reading_from_file.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws FileNotFoundException {
        try {
            writeToFile(null);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeToFile(byte[] messages) throws FileNotFoundException {
        try (
                // create a FileInputStream and get the FileChannel object
                FileInputStream fout = new FileInputStream(FILE_PATH);
                FileChannel fc = fout.getChannel();
        ) {
            // create a ByteBuffer object
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            for (int i = 0; i < messages.length; ++i) {
                buffer.put(messages[i]);
            }
            buffer.flip();
            fc.write(buffer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
