package java_core.oracle.input_output_streams.input_output_streams.serialization;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeOldVersionWithNew {

    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream(InputOutputConstant.FileConstants.OLD_VERSION_FILE);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            NewVersion newVersion = (NewVersion) in.readObject(); // Throws InvalidClassException due to mismatched serialVersionUID
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
