package chapter_02_observer_pattern.subject;


import chapter_02_observer_pattern.observer.Observer;

public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}
