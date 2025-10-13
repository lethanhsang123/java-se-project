package java_ocp.sorting.comparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        record Student(String name, int age) {}
        Comparator<Student> studentComparator = Comparator.comparing(Student::name)
                .thenComparingInt(Student::age)
                .reversed();

        Comparator<Student> c1 = Comparator.comparing(Student::name);
        Comparator<Student> c2 = Comparator.comparing(Student::age);
        Comparator<Student> c3 = c1.thenComparing(c2).reversed();

        var students = new ArrayList<Student>();
        students.add(new Student("D", 1));
        students.add(new Student("A", 3));
        students.add(new Student("C", 2));
        students.add(new Student("D", 3));
        students.add(new Student("B", 4));
        students.add(new Student("A", 1));
        System.out.println(students);
        System.out.println("=================");
        students.sort(studentComparator);
        System.out.println(students);
    }

}
