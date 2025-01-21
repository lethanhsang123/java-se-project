package java_core.oracle.input_output_streams.input_output_streams.object_streams;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // For versioning

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + '}';
    }
}
