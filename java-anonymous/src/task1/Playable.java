package task1;

public interface Playable {

    // public abstract
    void play();
    void stop();
    void pause();

    // public
    default void mute() {
        System.out.println("The sound is muted.");
    }


}
