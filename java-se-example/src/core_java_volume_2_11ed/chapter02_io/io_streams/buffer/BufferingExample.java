package core_java_volume_2_11ed.chapter02_io.io_streams.buffer;

import java.io.*;

public class BufferingExample {

    private static final int BUFFER_SIZE = 8192; // 8 KB buffer
    private static final String INPUT_FILE_NAME = "src/core_java_volume_2_11ed/chapter02_io/io_streams/buffer/input.txt" ;
    private static final String OUTPUT_FILE_NAME = "src/core_java_volume_2_11ed/chapter02_io/io_streams/buffer/output.txt" ;

    public static void main(String[] args) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(INPUT_FILE_NAME));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_NAME))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead); // Fewer I/O operations
            }
        }
    }

}
