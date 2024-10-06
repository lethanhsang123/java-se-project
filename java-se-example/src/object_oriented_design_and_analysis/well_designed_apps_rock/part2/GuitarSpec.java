package object_oriented_design_and_analysis.well_designed_apps_rock.part2;

import object_oriented_design_and_analysis.well_designed_apps_rock.Builder;
import object_oriented_design_and_analysis.well_designed_apps_rock.Type;
import object_oriented_design_and_analysis.well_designed_apps_rock.Wood;

public class GuitarSpec extends InstrumentSpec {

    private final int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numStrings) {
        super(builder, model, type, backWood, topWood);
        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) {
            return Boolean.FALSE;
        }
        if (!(otherSpec instanceof GuitarSpec spec)) {
            return Boolean.FALSE;
        }
        if (numStrings != spec.numStrings) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
