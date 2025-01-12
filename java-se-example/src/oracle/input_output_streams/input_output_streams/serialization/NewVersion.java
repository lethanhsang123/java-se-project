package oracle.input_output_streams.input_output_streams.serialization;

public class NewVersion extends OldVersion {

    private static final long serialVersionUID = 101L;

    private String address;

    public NewVersion(String name, int age, String address) {
        super(name, age);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
