package object_oriented_design_and_analysis.dougs_dog_doors;

import java.util.*;

public class DogDoor {

    private boolean open;

    private List<Bark> allowedBarks;

    public void open() {
        System.out.println("Thread(" + Thread.currentThread().getName() + "): The dog door opens.");
        open = true;

        final Timer timer = new Timer();
        System.out.println("Thread(" + Thread.currentThread().getName() + "): Waiting time");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Thread(" + Thread.currentThread().getName() + "): Close");
                close();
            }
        }, 5_000);
        System.out.println("Thread(" + Thread.currentThread().getName() + "): End open");
    }

    public void close() {
        System.out.println("Thread(" + Thread.currentThread().getName() + "): The dog door closes.");
        open = false;
    }

    public boolean isOpen() {return open;}

    public List<Bark> getAllowedBark() {
        return allowedBarks;
    }

    public void addAllowedBark(Bark allowedBark) {
        if (Objects.isNull(allowedBarks)) {
            allowedBarks = new ArrayList<>();
        }
        this.allowedBarks.add(allowedBark);
    }
}
