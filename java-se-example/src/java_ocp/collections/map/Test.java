package java_ocp.collections.map;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        var map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        System.out.println(map);
    }

}
