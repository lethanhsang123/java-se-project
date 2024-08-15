package core_java_volume_1_11ed.chapter_6.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // Print implicit argument
        System.out.print(target);

        // Print method nam
        System.out.print("." + method.getName() + "(");

        // Print explicit arguments
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                System.out.print(objects[i]);
                if (i < objects.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // invoke actual method
        return method.invoke(target, objects);
    }
}
