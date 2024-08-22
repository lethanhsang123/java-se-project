package core_java_volume_1_12ed.chapter_6.interfaces;

public class ChildClass extends AbstractClass implements Interface1, Interface2 {

    private Integer salary;

    public ChildClass(Integer salary) {
        super("name");
        this.salary = salary;
    }

    public void test() {
        test1();
        System.out.println("test method in Child Class");
    }

    public static void test1() {
        System.out.println("Test 1 Child");
    }

    @Override
    public void test2() {
        System.out.println("Test 2 Child Class");
    }


}
