package head_first_design_pattern.chapter_01_strategy_pattern.behaviors;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
