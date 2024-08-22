package core_java_volume_1_12ed.chapter_8_Generic_Programming.Wild_Card;

import core_java_volume_1_12ed.chapter_8_Generic_Programming.Define_Simple_Generic_Class.Pair;

public class test {

    public static void main(String[] args) {

    }

    public static void test2(Pair<? extends Employee> p) {
        Employee employee = new Employee("A", 2);
    }

}

class Employee {
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}


class Manager extends Employee {

    private Integer bonus;

    public Manager(String name, Integer age, Integer bonus) {
        super(name, age);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}