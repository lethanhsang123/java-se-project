package object_oriented_design_and_analysis.well_designed_apps_rock.part2;

import object_oriented_design_and_analysis.well_designed_apps_rock.Builder;
import object_oriented_design_and_analysis.well_designed_apps_rock.Type;
import object_oriented_design_and_analysis.well_designed_apps_rock.Wood;

public class MandolinSpec extends InstrumentSpec {

    private Style style;

    public MandolinSpec(Builder builder, String model, Type type,
                        Wood backWood, Wood topWood, Style style) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) {
            return Boolean.FALSE;
        }
        if (!(otherSpec instanceof MandolinSpec spec)) {
            return Boolean.FALSE;
        }
        if (style != spec.style) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
