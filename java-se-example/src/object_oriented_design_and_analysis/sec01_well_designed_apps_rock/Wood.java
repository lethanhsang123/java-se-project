package object_oriented_design_and_analysis.sec01_well_designed_apps_rock;

public enum Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY,
    MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

    @Override
    public String toString() {
        return switch (this) {
            case INDIAN_ROSEWOOD -> "Indian Rosewood";
            case BRAZILIAN_ROSEWOOD -> "Brazilian rosewood";
            case MAHOGANY -> "Mahogany";
            case MAPLE -> "Maple";
            case COCOBOLO -> "Cocobolo";
            case CEDAR -> "Cedar";
            case ADIRONDACK -> "Adirondack";
            case ALDER -> "Alder";
            case SITKA -> "Sitka";
        };
    }
}
