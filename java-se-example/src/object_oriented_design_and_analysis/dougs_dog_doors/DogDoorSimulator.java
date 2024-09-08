package object_oriented_design_and_analysis.dougs_dog_doors;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("rowlf"));
        door.addAllowedBark(new Bark("rooowlf"));
        door.addAllowedBark(new Bark("rawlf"));
        door.addAllowedBark(new Bark("woof"));

        BarkRecognizer recognizer = new BarkRecognizer(door);

        Remote remote = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Thread(" + Thread.currentThread().getName() + "): Bruce starts barking");
        recognizer.recognize(new Bark("rowlf"));

        System.out.println("\nThread(" + Thread.currentThread().getName() + "):Bruce has gone outside...");

        try {
            Thread.currentThread().wait(10_000);
        } catch (InterruptedException exception) {}

        System.out.println("\nThread(" + Thread.currentThread().getName() + "):Bruce's all done...");
        System.out.println("Thread(" + Thread.currentThread().getName() + "):...but he's stuck outside!");

        // Simulate the hardware hearing a bark (a Bruce)
        Bark smallDogBark = new Bark("yip");
        System.out.println("Thread(" + Thread.currentThread().getName() + "):A small dog starts barking.");
        recognizer.recognize(smallDogBark);

        try {
            Thread.currentThread().wait(5_000);
        } catch (InterruptedException e) {}

        // Simulate the hardware hearing a bark again
        System.out.println("Thread(" + Thread.currentThread().getName() + "):Bruce starts barking.");
        recognizer.recognize(new Bark("rooowlf"));

        System.out.println("\nThread(" + Thread.currentThread().getName() + "):Bruce's back inside...");

    }
}
