package refactoring_guru.chapter_02_observer_pattern;

import java.io.File;

public interface EventPublisher {

    void subscribe(String eventType, EventListener listener);

    void unsubscribe(String eventType, EventListener listener);

    void notify(String eventType, File file);

}
