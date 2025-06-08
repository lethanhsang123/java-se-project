package object_oriented_design_and_analysis.chapter_01_well_designed_apps_rock;

public enum Style {
    A,
    F;

    @Override
    public String toString() {
        return switch (this) {
            case A -> "A";
            case F -> "F";
        };
    }
}
