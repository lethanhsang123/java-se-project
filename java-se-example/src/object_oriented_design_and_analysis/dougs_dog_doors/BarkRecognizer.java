package object_oriented_design_and_analysis.dougs_dog_doors;

import java.util.List;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("Thread(" + Thread.currentThread().getName() + "): BarkRecognizer Heard a '" + bark.getSound() + "'");
        List<Bark> allowedBarks = door.getAllowedBark();
        if (allowedBarks.stream().anyMatch(bark::equals)){
            door.open();
            return;
        }
        System.out.println("Thread(" + Thread.currentThread().getName() + "): This dog is not allowed.");
    }
}
