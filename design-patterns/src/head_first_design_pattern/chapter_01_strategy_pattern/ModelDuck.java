package head_first_design_pattern.chapter_01_strategy_pattern;

import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.FlyBehavior;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.FlyNoWay;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.Quack;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.QuackBehavior;

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
