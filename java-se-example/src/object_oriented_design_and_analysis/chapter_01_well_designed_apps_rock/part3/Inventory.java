package object_oriented_design_and_analysis.chapter_01_well_designed_apps_rock.part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {

    private final List<Instrument> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec) {;
            // Anonymous class to create an Instrument instance
        };
        this.inventory.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (Objects.nonNull(instrument)
                    && instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec instrumentSpec) {
        List<Instrument> result = new ArrayList<>();
        for (Instrument instrument : inventory) {
            if (instrument.getSpec().matches(instrumentSpec)) {
                result.add(instrument);
            }
        }
        return result;
    }
}
