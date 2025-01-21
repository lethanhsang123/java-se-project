package java_core.oracle.input_output_streams.input_output_streams.object_streams;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeExample {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream(InputOutputConstant.FileConstants.OBJECT_FILE);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Employee employee = (Employee) objectIn.readObject();
            System.out.println("Object has been deserialized: " + employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
