import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Main: " + Thread.currentThread().getName());
        test();
        System.out.println("Hello world!");
    }

    public static void test() {
        System.out.println("Start test: " + Thread.currentThread().getName());
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Excecute task: " + Thread.currentThread().getName());
                timer.cancel();
            }
        }, 5_000);
        System.out.println("End test: " + Thread.currentThread().getName());
    }
}