package java_core.core_java_volume_2_11ed.chapter01_streams;

import java.util.ArrayList;
import java.util.List;

public class NonInterference {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }

        // Attempting to modify the source during stream execution
        numbers.stream().forEach(n -> {
            if (n == 3) {
                numbers.add(6); // Modifying the source
            }
            System.out.println(n);
        });
    }

}
