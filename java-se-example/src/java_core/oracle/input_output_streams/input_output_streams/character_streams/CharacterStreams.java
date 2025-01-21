package java_core.oracle.input_output_streams.input_output_streams.character_streams;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CharacterStreams {

    private static final String CHARACTER_OUTPUT_FILE = "src/java_core.oracle/input_output_streams/input_output_streams/character_streams_output.txt";
    private static final String LINE_OUTPUT_FILE = "src/java_core.oracle/input_output_streams/input_output_streams/line_output.txt";

    public static void main(String[] args) throws IOException {
//        executeUnicodeCharacterStream();
//        executeCopyCharacters();
//        executeCopyLines();
    }

    public static void executeUnicodeCharacterStream() {
        String unicodeText = "Đây là các characters đặc biệt (ex: Tiếng Việt)"; // Contains Unicode characters from English, Vietnamese

        // Writing to a file using a Writer (character stream)
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(InputOutputConstant.FileConstants.UTF8_INPUT_FILE), StandardCharsets.UTF_8)) {
            writer.write(unicodeText); // Automatically translates from Unicode to UTF-8
            System.out.println("Text written to file: " + unicodeText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Reading from the file using a Reader (character stream)
        try (Reader reader = new InputStreamReader(new FileInputStream(InputOutputConstant.FileConstants.UTF8_INPUT_FILE), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int data;
            while ((data = reader.read()) != -1) {
                content.append((char) data); // Automatically translates from UTF-8 to Unicode
            }
            System.out.println("Text read from file: " + content);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void executeCopyCharacters() throws IOException {
        try (Reader in = new FileReader(InputOutputConstant.FileConstants.INPUT_FILE);
             Writer out = new FileWriter(CHARACTER_OUTPUT_FILE)
        ) {
            int c;
            while ((c = in.read()) != -1) {
                char unicodeChar = (char) c;
                System.out.println("Unicode Character: " + unicodeChar + " (Code Point: " + Integer.toHexString(unicodeChar));
                out.write(c);
            }
        }
    }

    public static void executeCopyLines() throws IOException {
        try (
                BufferedReader in = new BufferedReader(new FileReader(InputOutputConstant.FileConstants.INPUT_FILE));
                PrintWriter out = new PrintWriter(LINE_OUTPUT_FILE);
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
        }
    }

}
