package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.arrays.two_dimensional_arrays_and_positional_games;

/**
 * Simulation of a Tic-Tac-Toe game (does not do strategy).
 */
public class TicTacToe {

    private static final int X = 1, O = -1; // players
    public static final int EMPTY = 0;      // Empty cells
    private int board[][] = new int[3][3];  // Game board
    private int player;

    public TicTacToe() {clearBoard();}

    /**
     * Method clear game board
     */
    private void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;    // every cell should be empty
            }
        }
        this.player = X;                // current player
    }


    /**
     * Puts an X or O mark at position i,j.
     * @param i Row number
     * @param j Collum number
     * @throws IllegalArgumentException Exception
     */
    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2)) {
            throw new IllegalArgumentException("Invalid board position");
        }
        if (board[i][j] != EMPTY) {
            throw new IllegalArgumentException("Board position occupied");
        }
        board[i][j] = this.player;
        player = -player;
    }

    /**
     * Checks whether the board configuration is a win for the given player.
     * @param mark  Mark board game
     * @return      Winner
     */
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark*3)         // row 0
                || (board[1][0] + board[1][1] + board[1][2] == mark*3)     // row 1
                || (board[2][0] + board[2][1] + board[2][2] == mark*3)     // row 2
                || (board[0][0] + board[1][0] + board[2][0] == mark*3)     // column 0
                || (board[0][1] + board[1][1] + board[2][1] == mark*3)     // column 1
                || (board[0][2] + board[1][2] + board[2][2] == mark*3)     // column 2
                || (board[0][0] + board[1][1] + board[2][2] == mark*3)     // diagonal
                || (board[2][0] + board[1][1] + board[0][2] == mark*3));   // rev diag
    }

    /**
     * Returns the winning player's code, or 0 to indicate a tie (or unfinished game).
     * @return  winning player's code, or 0 to indicate a tie (or unfinished game).
     */
    public int winner() {
        if (isWin(X)) return (X);
        else if (isWin(O)) return (O);
        else return 0;
    }

    /**
     * Returns a simple character string showing the current board.
     * @return  character string showing the current board.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        sb.append("X");
                        break;
                    case O:
                        sb.append("O");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                }
                if (j < 2) sb.append("|");      // column boundary
            }
            if (i < 2) sb.append("\n-----\n");  // row boundary
        }
        return sb.toString();
    }

    public static void main(String[ ] args) {
        TicTacToe game = new TicTacToe( );
        game.putMark(1,1);
        game.putMark(0,2);
        game.putMark(2,2);
        game.putMark(0,0);
        game.putMark(0,1);
        game.putMark(2,1);
        game.putMark(1,2);
        game.putMark(1,0);
        game.putMark(2,0);
        System.out.println(game);
        int winningPlayer = game.winner( );
        String[ ] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
        System.out.println(outcome[1 + winningPlayer]);
    }

}
