package object_oriented_design_and_analysis.well_designed_apps_rock;

public enum Type {
    ACOUSTIC,
    ELECTRIC;

    @Override
    public String toString() {
        return switch (this) {
            case ACOUSTIC -> "acoustic";
            case ELECTRIC -> "electric";
            default -> null;
        };
    }
}
