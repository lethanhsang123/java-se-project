package core_java_volume_1_11ed.chapter_6.interfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ChildClass test = new ChildClass(12);
        System.out.println("Result: " + test);
        test.test6();

        List<String> test2 = new LinkedList<>();
        test2.removeIf((e) -> e == null);

//        Objects.requireNonNullElseGet()

    }
}
