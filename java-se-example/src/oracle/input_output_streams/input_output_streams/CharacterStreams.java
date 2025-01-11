package oracle.input_output_streams.input_output_streams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CharacterStreams {

    public static void main(String[] args) throws IOException {
        executeUnicodeCharacterStream();
    }

    public static void executeUnicodeCharacterStream() {
        String unicodeText = "Đây là các characters đặc biệt (ex: Tiếng Việt)"; // Contains Unicode characters from English, Vietnamese

        // Writing to a file using a Writer (character stream)
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(InputOutputConstant.FileConstants.UTF8_FILE), StandardCharsets.UTF_8)) {
            writer.write(unicodeText); // Automatically translates from Unicode to UTF-8
            System.out.println("Text written to file: " + unicodeText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Reading from the file using a Reader (character stream)
        try (Reader reader = new InputStreamReader(new FileInputStream(InputOutputConstant.FileConstants.UTF8_FILE), StandardCharsets.UTF_8)) {
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
        try(Reader in = new FileReader(InputOutputConstant.FileConstants.INPUT_FILE);
            Writer out = new FileWriter(InputOutputConstant.FileConstants.CHARACTER_OUTPUT_FILE)
        ) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }

}
