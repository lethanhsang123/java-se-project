package refactoring_guru.chapter_02_observer_pattern;

import java.io.File;
import java.util.List;

public class Editor {

    private EventManager eventManager;
    private File file;

    public Editor(List<String> events) {
        this.eventManager = new EventManager(events);
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        eventManager.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null) {
            eventManager.notify(AppConstants.FileEvents.SAVE, file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
