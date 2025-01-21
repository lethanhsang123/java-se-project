package java_core.oracle.input_output_streams.input_output_streams.object_streams;

import java_core.oracle.input_output_streams.input_output_streams.InputOutputConstant;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeExample {

    public static void main(String[] args) {
        Employee employee = new Employee(1, "John Doe", 50000.0);

        try (FileOutputStream fileOut = new FileOutputStream(InputOutputConstant.FileConstants.OBJECT_FILE);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(employee);
            System.out.println("Object has been serialized: " + employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
