package object_oriented_design_and_analysis.dougs_dog_doors;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;

    public void open() {
        System.out.println("The dog door opens.");
        open = true;

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
            }
        }, 5_000);
    }

    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }

    public boolean isOpen() {return open;}
}
