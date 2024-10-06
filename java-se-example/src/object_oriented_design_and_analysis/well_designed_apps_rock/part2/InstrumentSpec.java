package object_oriented_design_and_analysis.well_designed_apps_rock.part2;

import object_oriented_design_and_analysis.well_designed_apps_rock.Builder;
import object_oriented_design_and_analysis.well_designed_apps_rock.Type;
import object_oriented_design_and_analysis.well_designed_apps_rock.Wood;

public abstract class InstrumentSpec {

    private final Builder builder;
    private final String model;
    private final Type type;
    private final Wood backWood;
    private final Wood topWood;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
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

    public boolean matches(InstrumentSpec spec) {
        if (builder != spec.builder) {
            return Boolean.FALSE;
        }
        if ( (model != null) && (!model.isEmpty()) && (!model.equals(spec.getModel())) ) {
            return Boolean.FALSE;
        }
        if ( (type != spec.type) || (backWood != spec.backWood) || (topWood != spec.topWood) ) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
