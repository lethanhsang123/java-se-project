package object_oriented_design_and_analysis.dougs_dog_doors;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(String bark) {
        System.out.println("BarkRecognizer: Heard a '" + bark + "'");
        door.open();
    }
}
