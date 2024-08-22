package core_java_volume_1_12ed.chapter_8_Generic_Programming.Restriction_And_Limitation;

import core_java_volume_1_12ed.chapter_8_Generic_Programming.Define_Simple_Generic_Class.Pair;

public class main {
    public static void main(String[] args) {
        Pair<String> test = new Pair<>();
        System.out.println(test.getClass());
    }
}
