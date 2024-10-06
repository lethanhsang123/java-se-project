package object_oriented_design_and_analysis.well_designed_apps_rock.part2;

import java.util.*;

public class Inventory {

    private final List<Instrument> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;
        if (spec instanceof GuitarSpec guitarSpec) {
            instrument = new Guitar(serialNumber, price, guitarSpec);
        }
        if (spec instanceof MandolinSpec mandolinSpec) {
            instrument = new Mandolin(serialNumber, price, mandolinSpec);
        }
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

    public List<Instrument> search(MandolinSpec mandolinSpec) {
        List<Instrument> result = new ArrayList<>();
        for (Instrument instrument : inventory) {
            if (instrument instanceof Mandolin mandolin
                    && Objects.nonNull(mandolin.getSpec())
                    && mandolin.getSpec().matches(mandolinSpec)) {
                result.add(mandolin);
            }
        }
        return result;
    }
}
