package core_java_volume_1_11ed.chapter_6.interfaces;

public interface Interface2 {
    void test2();

    static void test3() {
        test5();
        System.out.println("Test 3 static Interface 2");
    }

    private void test4() {
        System.out.println("Test 4 Interface 2");
    }

    private static void test5() {
        System.out.println("Test 5 static Interface 2");
    }

    default void test6() {
        test2();
        System.out.println("Test default methods");
    }
}
