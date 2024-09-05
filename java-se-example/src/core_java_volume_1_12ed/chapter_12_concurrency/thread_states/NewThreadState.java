package core_java_volume_1_12ed.chapter_12_concurrency.thread_states;

public class NewThreadState {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("Thread state: " + thread.getState());
    }

}
