package head_first_design_pattern.chapter_02_observer_pattern.subject;


import head_first_design_pattern.chapter_02_observer_pattern.observer.Observer;

public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}
