package core_java_volume_2_11ed.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test1 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", List.of("123", "234")));
        students.add(new Student("B", List.of("112")));
        students.add(new Student("C", List.of("312", "221")));

        Stream<Student> stream = students.stream();
        System.out.println(stream.flatMap(student -> student.getPhones().stream()).toList());

    }

}

class Student {
    private String name;
    private List<String> phones;

    public Student(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}

class Phone {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    Phone(String phone) {
        this.phone = phone;
    }
}
