package object_oriented_design_and_analysis.chapter_04.dessert;

import object_oriented_design_and_analysis.chapter_04.topping.Topping;

import java.util.ArrayList;
import java.util.List;

public abstract class Dessert {

    protected List<Topping> toppings = new ArrayList<>();

    public void getToppings() {
        System.out.print("Toppings: [");
        this.toppings.forEach(topping -> System.out.println(topping.getName()));
        System.out.println("]");
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
        }
    }
}
