package core_java_volume_1_12ed.chapter_6.proxies;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

    public static void main(String[] args) {
        var elements = new Object[1000];

        // fill elements with proxies fir integers 1...1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[] {Comparable.class},
                    handler
            );
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // Search for key
        int result = Arrays.binarySearch(elements, key);

        // Print match if found
        if (result >= 0) System.out.println(elements[result]);
    }

}
