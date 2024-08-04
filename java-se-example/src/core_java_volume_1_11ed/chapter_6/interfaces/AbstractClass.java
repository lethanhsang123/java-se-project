package core_java_volume_1_11ed.chapter_6.interfaces;

public abstract class AbstractClass {

    private String name;

    public AbstractClass(String name) {
        this.name = name;
    }

    public void test() {
        System.out.println("test method in Abstract Class");
    }

    public static void test1() {
        System.out.println("Test 1 Abstract Classs");
    }
}
