package core_java_volume_1_11ed.chapter_8_Generic_Programming.Generic_Method;

class ArrayAlg
{
    public static <T> T getMiddle(T... a)
    {
        return a[a.length / 2];
    }
}


class Test {
    public static void main(String[] args) {
        String middle = ArrayAlg.<String>getMiddle("John", "Q.", "Public");
        String middle2 = ArrayAlg.getMiddle("John", "Q.", "Public");
//        double middle = ArrayAlg.getMiddle(3.14, 1729, 0); => ERROR
        double middle3 = ArrayAlg.getMiddle(3.14, 1729.0, 0.0); // Same parameters type
    }
}
