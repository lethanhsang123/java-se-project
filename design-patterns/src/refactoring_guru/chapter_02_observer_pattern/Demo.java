package refactoring_guru.chapter_02_observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<String> eventTypes = new ArrayList<>();
        eventTypes.add(AppConstants.FileEvents.SAVE);
        eventTypes.add(AppConstants.FileEvents.OPEN);

        Editor editor = new Editor(eventTypes);

        EventListener logOpenListener = new LogOpenListener("src/refactoring_guru/chapter_02_observer_pattern/test.txt");
        EventListener emailNotificationListener = new EmailNotificationListener("admin@example.com");

        editor.getEventManager().subscribe(AppConstants.FileEvents.OPEN, logOpenListener);
        editor.getEventManager().subscribe(AppConstants.FileEvents.SAVE, emailNotificationListener);

        try {
            editor.openFile("src/refactoring_guru/chapter_02_observer_pattern/test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
