public class Board {

    /**
     *
     */
    protected String[] board;
    // number of moves made

    /**
     *
     */
    protected int moveCount; 

    public Board() {
        this.moveCount = 0;
        this.board = new String[9];
    }

    // validMove returns a boolean value
    // true means a move is valid
    // false means a move is invalid
    public boolean validMove (int pos) {
        return board[pos] == null;
    }

    // move will only play if validMove is true
    // player should be X or O
    public void move (int pos, String player) {
	if (validMove(pos)) {
            board[pos] = player;
            moveCount++;
        }
    }

    // checkWin returns an int
    // 0 means the game is not finished
    // 1 for X win
    // 2 for O win
    // 3 for draw
    public int checkWin() {
        if (moveCount < 5) {
            return 0;
	}

	for (int i = 0; i < 8; i++) {
            String line = null;
 
            switch (i) {
            case 0 -> line = board[0] + board[1] + board[2];
            case 1 -> line = board[3] + board[4] + board[5];
            case 2 -> line = board[6] + board[7] + board[8];
            case 3 -> line = board[0] + board[3] + board[6];
            case 4 -> line = board[1] + board[4] + board[7];
            case 5 -> line = board[2] + board[5] + board[8];
            case 6 -> line = board[0] + board[4] + board[8];
            case 7 -> line = board[2] + board[4] + board[6];
            }

            if (line.equals("XXX")) {
                return 1;
            } else if (line.equals("OOO")) {
                return 2;
            }
        }

        if (moveCount > 8) {
            return 3;
        }

        return 0;
    }
}