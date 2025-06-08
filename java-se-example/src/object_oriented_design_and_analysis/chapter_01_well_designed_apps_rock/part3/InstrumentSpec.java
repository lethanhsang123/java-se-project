package object_oriented_design_and_analysis.chapter_01_well_designed_apps_rock.part3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {

    private Map properties;

    public InstrumentSpec(Map properties) {
        if (properties == null) {
            this.properties = new HashMap();
        } else {
            this.properties = properties;
        }
    }

    public Map getProperties() {
        return properties;
    }

    public Object getProperty(String key) {
        return this.properties.get(key);
    }

    public boolean matches(InstrumentSpec spec) {
       for (Iterator  i = spec.getProperties().keySet().iterator();  i.hasNext(); ) {
              String propertyName = (String) i.next();
              Object value = spec.getProperties().get(propertyName);
              if (!this.properties.containsKey(propertyName) || !this.properties.get(propertyName).equals(spec.getProperty(propertyName))) {
                  return false;
              }
       }
       return true;
    }
}
