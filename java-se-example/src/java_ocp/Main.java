package java_ocp;

public class Main {

    private String name;
    private int age;
    private long id;

    public Main(String name, int age) {
        this(name);
    }

    public Main(String name) {
        this.name = name;
    }

    public Main(int age) {
        this.age = age;
    }
}
