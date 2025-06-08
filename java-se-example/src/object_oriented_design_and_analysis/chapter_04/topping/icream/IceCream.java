package object_oriented_design_and_analysis.chapter_04.topping.icream;

import object_oriented_design_and_analysis.chapter_04.topping.Topping;

public abstract class IceCream extends Topping {

    protected String taste;

    public IceCream(String taste, String name) {
        super(name);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
