package java_ocp.sequenced_collections.sequenced_collections;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class Main {

    private record Student(String name, int age) {}

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("D", 1));
        students.add(new Student("C", 5));
        students.add(new Student("Z", 0));
        students.add(new Student("B", 4));
        test1(students);
    }

    public static void test1(SequencedCollection<Student> collection) {
        var collectionsReversed = collection.reversed();
        System.out.println(collectionsReversed);
        collectionsReversed.removeFirst();
        System.out.println(collectionsReversed);
    }

}
