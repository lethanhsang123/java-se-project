package test;

import test.behaviors.Flyable;

public class Bat extends Mammal  {

    private final Flyable flyable;

    public Bat(Flyable flyable) {
        this.flyable = flyable;
    }

    public void fly() {

        flyable.fly();

    }
}
