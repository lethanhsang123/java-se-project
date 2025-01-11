package oracle.input_output_streams.input_output_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {

    public static void main(String[] args) throws IOException {
        executeCopyBytes();
    }

    public static void executeCopyBytes() throws IOException {
        try (
                FileInputStream in = new FileInputStream(InputOutputConstant.FileConstants.INPUT_FILE);
                FileOutputStream out = new FileOutputStream(InputOutputConstant.FileConstants.OUTPUT_FILE);
        ) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }

}
