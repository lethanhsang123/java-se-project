package java_core.ocp;

public class ClassA {

    private String name = "default";

    public ClassA(String name) {
        System.out.println(this.name);
        System.out.println("Constructor");
        this.name = name;
    }

    {
        System.out.println("Instance initializer block name: " + name);
        name = "instance";
    }

    public String getName() {
        return name;
    }

    static {
        System.out.println("Static initializer block");
    }
}
