package test;

import test.behaviors.Walkable;

public class Dog extends Mammal {

    private final Walkable walkable;

    public Dog(Walkable walkable) {
        this.walkable = walkable;
    }

    public void walk() {
        walkable.walk();
    }
}
