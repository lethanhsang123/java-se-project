package object_oriented_design_and_analysis.well_designed_apps_rock.part2;

public abstract class Instrument {

    private final String serialNumber;
    private double price;

    private final InstrumentSpec spec;

    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }
}
