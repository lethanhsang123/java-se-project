package object_oriented_design_and_analysis.dougs_dog_doors;

public class DogDoor {

    private boolean open;

    public void open() {
        System.out.println("The dog door opens.");
        open = true;
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {return open;}
}
