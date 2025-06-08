package test;

import test.behaviors.Swimmable;

public class Whale extends Mammal {
    private final Swimmable swimmable;

    public Whale(Swimmable swimmable) {
        this.swimmable = swimmable;
    }

    public void swim() {
        swimmable.swim();
    }
}
