package java_ocp.pack2;

import java_ocp.pack1.Parent;
import java_ocp.pack1.Test1;

public class Child1 extends Parent {

    private boolean a;

    private String b;

    public Child1(boolean a, String b) {
        super(b);
        this.a = a;
        this.b = b;
    }

    public Child1(boolean a) {
        this(a, "");
    }

    public Child1(String b) {
        this(false, b);
    }
}
