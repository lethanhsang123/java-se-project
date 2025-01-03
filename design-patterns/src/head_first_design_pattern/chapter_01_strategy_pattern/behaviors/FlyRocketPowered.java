package head_first_design_pattern.chapter_01_strategy_pattern.behaviors;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
