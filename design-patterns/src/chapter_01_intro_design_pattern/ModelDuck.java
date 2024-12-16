package chapter_01_intro_design_pattern;

import chapter_01_intro_design_pattern.behaviors.FlyBehavior;
import chapter_01_intro_design_pattern.behaviors.FlyNoWay;
import chapter_01_intro_design_pattern.behaviors.Quack;
import chapter_01_intro_design_pattern.behaviors.QuackBehavior;

public class ModelDuck extends Duck {

    public ModelDuck() {
        super(new Quack(), new FlyNoWay());
    }

    public ModelDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
