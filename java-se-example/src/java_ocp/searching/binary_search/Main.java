package java_ocp.searching.binary_search;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        record Student(String name, int age) {}
        var students = new ArrayList<>(Arrays.asList(new Student("D", 1), new Student("B", 2), new Student("C", 3)));
        System.out.println(students);
//         Collections.sort(students);
        System.out.println(students);
//        System.out.println(Collections.binarySearch(students, new Student("A", 4)));
        // Does not compile because a sorting object must extend Comparable or pass Comparator instance
    }

    public static void test2() {
        record Student(String name, int age) {}
        var studentComparator = Comparator.comparing(Student::age);
        Set<Student> students = new TreeSet<>();    // WARNING: Construction of a sorted collection with non-comparable elements
        students.add(new Student("D", 1));
        System.out.println(students);   // Exception: java.lang.ClassCastException: Student cannot be cast to java.lang.Comparable

        Set<Student> students2 = new TreeSet<>(studentComparator);
        students2.add(new Student("D", 1));
        System.out.println(students2);
    }

}
