package java_core.oracle.input_output_streams.input_output_streams.serialization;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeOldVersion {

    public static void main(String[] args) {
        OldVersion oldVersion = new OldVersion("John", 30);
        try (FileOutputStream fileOut = new FileOutputStream(InputOutputConstant.FileConstants.OLD_VERSION_FILE);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(oldVersion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
