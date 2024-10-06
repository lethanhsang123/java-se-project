package object_oriented_design_and_analysis.well_designed_apps_rock.part1;

import object_oriented_design_and_analysis.well_designed_apps_rock.Builder;
import object_oriented_design_and_analysis.well_designed_apps_rock.Type;
import object_oriented_design_and_analysis.well_designed_apps_rock.Wood;

public class GuitarSpec {

    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    private int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numStrings) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public boolean matches(GuitarSpec otherSpec) {
        // Todo: Implementation Businesss
        return true;
    }
}
