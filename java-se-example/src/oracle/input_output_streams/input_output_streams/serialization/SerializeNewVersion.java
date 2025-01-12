package oracle.input_output_streams.input_output_streams.serialization;

import oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeNewVersion {

    public static void main(String[] args) {
        NewVersion newVersion = new NewVersion("John", 30, "123 Street Name");
        try (FileOutputStream fileOut = new FileOutputStream(InputOutputConstant.FileConstants.NEW_VERSION_FILE);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(newVersion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
