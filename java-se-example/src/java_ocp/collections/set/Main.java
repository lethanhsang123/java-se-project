package java_ocp.collections.set;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final Student[] data = {new Student("A", 1), new Student("B", 2), new Student("B", 2)};

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        Set<Student> students = Arrays.stream(data).collect(
                Collectors.toSet()
        );
        print(students);
    }

    public static void test2() {
        Set<Student> students = new LinkedHashSet<>();
        print(students);
    }

    public static void print(Collection<?> collections) {
        System.out.print("[");
        collections.forEach(System.out::print);
        System.out.println("]");
    }

}
