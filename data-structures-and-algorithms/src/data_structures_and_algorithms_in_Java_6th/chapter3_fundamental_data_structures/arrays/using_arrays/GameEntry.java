package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.arrays.using_arrays;

public class GameEntry {
    private String name;    // name of the person earning this score
    private int score;      // the score value

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "(" + "name='" + name + ", score=" + score + ')';
    }
}
