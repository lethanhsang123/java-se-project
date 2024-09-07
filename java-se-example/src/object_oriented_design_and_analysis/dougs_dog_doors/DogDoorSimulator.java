package object_oriented_design_and_analysis.dougs_dog_doors;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);
        System.out.println("Fido barks to go outside...");
        recognizer.recognize("Woof");

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.currentThread().wait(1_0000);
        } catch (InterruptedException e) {
            System.out.println("...But he's stuck outside!");

            // Simulate the hardware hearing a bark again
            System.out.println("Fido starts barking");
            recognizer.recognize("Woof");
            System.out.println("\nFido's back inside...");
        }
    }
}
