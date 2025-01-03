package head_first_design_pattern.chapter_01_strategy_pattern.behaviors;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
