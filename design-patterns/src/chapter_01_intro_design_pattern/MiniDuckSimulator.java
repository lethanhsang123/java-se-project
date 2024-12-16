package chapter_01_intro_design_pattern;

import chapter_01_intro_design_pattern.behaviors.FlyRocketPowered;

public class MiniDuckSimulator {

    public static void main(String[] args) {
//        Duck mallardDuck = new MallardDuck();
//        mallardDuck.performQuack();
//        mallardDuck.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

    }

}
