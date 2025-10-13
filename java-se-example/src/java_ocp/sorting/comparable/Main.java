package java_ocp.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        var students = new ArrayList<Student>();
        students.add(new Student("D", 1));
        students.add(new Student("A", 3));
        students.add(new Student("C", 2));
        students.add(new Student("B", 4));
        System.out.println(students);
        System.out.println("=================");
        Collections.sort(students);
        System.out.println(students);
    }

}
