package refactoring_guru.chapter_02_observer_pattern;

import java.io.File;
import java.util.*;

public class EventManager implements EventPublisher {

    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(List<String> events) {
        Optional.ofNullable(events).ifPresent(strings -> {
            for (String event : strings) {
                this.listeners.put(event, new ArrayList<>());
            }
        });
    }

    @Override
    public void subscribe(String eventType, EventListener listener) {
        Optional.ofNullable(this.listeners.get(eventType)).ifPresent(
                listeners -> listeners.add(listener)
        );
    }

    @Override
    public void unsubscribe(String eventType, EventListener listener) {
        Optional.ofNullable(this.listeners.get(eventType)).ifPresent(
                listeners -> listeners.remove(listener)
        );
    }

    @Override
    public void notify(String eventType, File file) {
        Optional.ofNullable(this.listeners.get(eventType)).ifPresent(
                listeners -> {
                    for (EventListener listener : listeners) {
                        listener.update(eventType, file);
                    }
                }
        );
    }
}
