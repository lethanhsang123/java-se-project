package core_java_volume_2_11ed.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestParallel {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = new ArrayList<>();

        numbers.parallelStream()
                .map(n -> {
                    result.add(n);  // Adding elements to a shared list
                    return n * 2;
                })
                .forEach(System.out::println);

        System.out.println(result);  // This may produce inconsistent results due to race conditions

    }

}
