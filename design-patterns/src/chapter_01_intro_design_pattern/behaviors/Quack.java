package chapter_01_intro_design_pattern.behaviors;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
