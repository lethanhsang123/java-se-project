package object_oriented_design_and_analysis.dougs_dog_doors;

public class Bark {

    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bark) {
            if (this.sound.equalsIgnoreCase(((Bark) obj).getSound())) {
                return true;
            }
        }
        return false;
    }
}
