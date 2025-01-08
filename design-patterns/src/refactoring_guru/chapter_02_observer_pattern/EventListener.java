package refactoring_guru.chapter_02_observer_pattern;

import java.io.File;

public interface EventListener {

    void update(String eventType, File file);

}
