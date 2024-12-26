package chapter_02_observer_pattern.observer;

import chapter_02_observer_pattern.subject.Subject;

public interface Observer {

    public void update(float temp, float humidity, float pressure);

}
