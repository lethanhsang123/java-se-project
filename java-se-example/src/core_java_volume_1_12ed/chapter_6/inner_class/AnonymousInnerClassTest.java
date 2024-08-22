package core_java_volume_1_12ed.chapter_6.inner_class;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class AnonymousInnerClassTest {

    public static void main(String[] args) {

    }

}

class TalkingClock2 {
    public void start(int interval, boolean beep) {
        var listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(actionEvent.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
    }
}