package oracle.input_output_streams.input_output_streams.buffer_streams;

import oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.*;

public class BufferStreams {

    private static final String BUFFER_OUTPUT_FILE = "src/oracle/input_output_streams/buffer_streams/character_streams_output.txt";

    public static void main(String[] args) throws IOException {
    }

    public static void executeCopyBuffer() throws IOException {
        try (Reader in = new BufferedReader(new FileReader(InputOutputConstant.FileConstants.INPUT_FILE));
             Writer out = new BufferedWriter(new FileWriter(BUFFER_OUTPUT_FILE));
        ) {
            int c;
            while ((c = in.read()) != -1) {
                char unicodeChar = (char) c;
                System.out.println("Unicode Character: " + unicodeChar + " (Code Point: " + Integer.toHexString(unicodeChar));
                out.write(c);
            }
        }
    }

}
