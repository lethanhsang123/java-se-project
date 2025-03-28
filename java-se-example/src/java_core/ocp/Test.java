package java_core.ocp;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        var s1 = "Java";
        var s2 = "Java";
        var s3 = s1.indent(1).strip();
        var s4 = s3.intern();
        var sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
        System.out.println(s1 == s2);   // EQ
        System.out.println(s1.equals(s2));  // EQ
        System.out.println(s1 == s3);   // NA
        System.out.println(s1 == s4);   // EQ
        System.out.println(sb1.toString() == s1); // NA
        System.out.println(sb1.toString().equals(s1)); // EQ
    }

}
