package core_java_volume_1_11ed.chapter_6.inner_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class main {
    public static void main(String[] args) {
        var clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}

class TalkingClock {
    private int interval;
    private boolean beep;

    TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener {

        private Integer count = 1;
        static String a = "";

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("Beep: " + beep);
            System.out.println("At the tone, the time is " + Instant.ofEpochSecond(actionEvent.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
            beep = !beep;
        }
    }
}
