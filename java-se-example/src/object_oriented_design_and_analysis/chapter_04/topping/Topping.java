package object_oriented_design_and_analysis.chapter_04.topping;

public abstract class Topping {

    protected String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
