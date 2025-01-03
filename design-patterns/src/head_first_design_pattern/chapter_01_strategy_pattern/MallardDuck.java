package head_first_design_pattern.chapter_01_strategy_pattern;

import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.FlyBehavior;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.FlyWithWings;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.Quack;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.QuackBehavior;

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
