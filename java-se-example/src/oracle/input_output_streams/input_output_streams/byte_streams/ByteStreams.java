package oracle.input_output_streams.input_output_streams.byte_streams;

import oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {

    private static final String OUTPUT_FILE = "src/oracle/input_output_streams/input_output_streams/byte_streams/output_byte_streams.txt";

    public static void main(String[] args) throws IOException {
        executeCopyBytes();
    }

    public static void executeCopyBytes() throws IOException {
        try (
                FileInputStream in = new FileInputStream(InputOutputConstant.FileConstants.INPUT_FILE);
                FileOutputStream out = new FileOutputStream(OUTPUT_FILE);
        ) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.println("Byte: " + c);
                out.write(c);
            }
        }
    }

}
