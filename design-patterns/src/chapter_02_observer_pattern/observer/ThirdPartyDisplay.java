package chapter_02_observer_pattern.observer;

import chapter_02_observer_pattern.DisplayElement;

public class ThirdPartyDisplay implements Observer, DisplayElement {
    @Override
    public void display() {

    }

    @Override
    public void update(float temp, float humidity, float pressure) {

    }
}
