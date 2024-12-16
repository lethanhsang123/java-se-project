package chapter_01_intro_design_pattern;

import chapter_01_intro_design_pattern.behaviors.FlyBehavior;
import chapter_01_intro_design_pattern.behaviors.FlyWithWings;
import chapter_01_intro_design_pattern.behaviors.Quack;
import chapter_01_intro_design_pattern.behaviors.QuackBehavior;

public class MallardDuck extends Duck {


    public MallardDuck() {
        super(new Quack(), new FlyWithWings());
    }

    public MallardDuck(QuackBehavior quackBehavior,
                          FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }

    @Override
    public void swim() {

    }
}
