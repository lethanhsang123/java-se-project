package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures;

/**
 *  Class for storing high scores in an array in nondecreasing order
 */
public class Scoreboard {
    private int numEntries = 0;     // number of actual entries
    private GameEntry[ ] board;     // array of game entries (names & scores)

    /**
     * Constructs an empty scoreboard with the given capacity for storing entries
     * @param capacity
     */
    public Scoreboard(int capacity) {
        this.board = new GameEntry[capacity];
    }
}
