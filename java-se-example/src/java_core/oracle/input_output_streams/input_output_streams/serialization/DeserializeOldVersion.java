package java_core.oracle.input_output_streams.input_output_streams.serialization;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeOldVersion {

    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream(InputOutputConstant.FileConstants.OLD_VERSION_FILE);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            OldVersion oldVersion = (OldVersion) in.readObject();
            System.out.println("Name: " + oldVersion.getName() + ", Age: " + oldVersion.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
