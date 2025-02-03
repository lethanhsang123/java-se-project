package java_core.ibm.nio.reading_from_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadingFromFile {

    private static final String FILE_PATH = "src/java_core/ibm/nio/reading_from_file/reading_from_file.txt";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws FileNotFoundException {
        try {
            readFromFile();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFromFile() throws FileNotFoundException {
        try (
                // create a FileInputStream and get the FileChannel object
                FileInputStream fin = new FileInputStream(FILE_PATH);
                FileChannel fc = fin.getChannel();
        ) {
            // create a ByteBuffer object
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            fc.read(buffer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
