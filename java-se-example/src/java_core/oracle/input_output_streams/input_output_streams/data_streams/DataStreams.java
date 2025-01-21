package java_core.oracle.input_output_streams.input_output_streams.data_streams;

import java.io.*;

public class DataStreams {

    private static final String DATA_FILE_NAME = "src/java_core/oracle/input_output_streams/input_output_streams/data_streams/data.txt";
    private static final double[] PRICES = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    private static final int[] UNITS = { 12, 8, 13, 29, 50 };
    private static final String[] DESCS = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"
    };

    public static void main(String[] args) throws IOException {
//        executeWriteData();
        executeReadData();
    }

    private static void executeWriteData() throws IOException {
        try (
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(DATA_FILE_NAME)));
        ) {
            for (int i = 0; i < PRICES.length; i++) {
                out.writeDouble(PRICES[i]);
                out.writeInt(UNITS[i]);
                out.writeUTF(DESCS[i]);
            }
        }
    }

    private static void executeReadData() throws IOException {
        double price;
        int unit;
        String desc;
        double total = 0.0;
        try (
                DataInputStream in = new DataInputStream(new
                        BufferedInputStream(new FileInputStream(DATA_FILE_NAME)));
        ) {
            while (true) {
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d units of %s at $%.2f%n", unit, desc, price);
                total += unit * price;
            }
        } catch (EOFException e) {
            System.out.println("Total price is $" + total);
            // End of file
        }
    }

}
