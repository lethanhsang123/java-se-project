package head_first_design_pattern.chapter_01_strategy_pattern;

import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.FlyBehavior;
import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.QuackBehavior;

public abstract class Duck {

    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;

    protected Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        this.quackBehavior = quackBehavior;
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void performQuack() {
        quackBehavior.quack();
    }
    public void performFly() {
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
