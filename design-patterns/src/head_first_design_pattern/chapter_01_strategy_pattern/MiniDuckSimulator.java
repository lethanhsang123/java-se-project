package head_first_design_pattern.chapter_01_strategy_pattern;

import head_first_design_pattern.chapter_01_strategy_pattern.behaviors.FlyRocketPowered;

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
