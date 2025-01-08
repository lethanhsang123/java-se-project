package refactoring_guru.chapter_02_observer_pattern;

public final class AppConstants {

    private AppConstants() {}

    public static final class FileEvents {
        public static final String SAVE = "save";
        public static final String OPEN = "open";

        private FileEvents() {}
    }

}
