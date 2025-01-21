package java_core.oracle.input_output_streams.input_output_streams.serialization;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeNewVersion {

    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream(InputOutputConstant.FileConstants.NEW_VERSION_FILE);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            NewVersion newVersion = (NewVersion) in.readObject();
            System.out.println("Name: " + newVersion.getName() + ", Age: " + newVersion.getAge() + ", Address: " + newVersion.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
