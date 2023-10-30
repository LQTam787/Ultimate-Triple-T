public class Board {
	// board is stored as an array of Strings
	// each element represents the cell with the corresponding index:
	/* |---|---|---|
       | 0 | 1 | 2 |
       |-----------|
       | 3 | 4 | 5 |
       |-----------|
       | 6 | 7 | 8 |
       |---|---|---|*/
    // each cell should be either null, "X", or "O"
	protected String[] board = new String[9];
	protected int moveCount = 0; // number of moves made

	// validMove returns a boolean value
	// true means a move is valid
	// false means a move is invalid
	public boolean validMove (int x) {
		if (board[x] == null) {
			return true;
		} else {
			return false;
		}
	}

	// move will only play if validMove is true
	// player should be X or O
	public void move (int x, String player) {
		if (validMove(x)) {
			board[x] = player;
			moveCount++;
		} else {
			System.out.println("ERROR! INVALID MOVE!");
		}
	}

	// checkWin returns an int
	// 0 means the game is not finished
	// 1 for X win
	// 2 for O win
	// 3 for draw
	public int checkWin() {
		if (moveCount < 2) {
			return 0;
		}

		for (int i = 0; i < 8; i++) {
            String line = null;
 
            switch (i) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
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

	/*
	// these are temporary and should be replaced with GUI
	protected String nullConv (String s) {
		if (s == null) {
			return " ";
		} else {
			return s;
		}
	}

	public void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + nullConv(board[0]) + " | " + nullConv(board[1]) + " | " + nullConv(board[2]) + " |");
        System.out.println("|-----------|");
        System.out.println("| " + nullConv(board[3]) + " | " + nullConv(board[4]) + " | " + nullConv(board[5]) + " |");
        System.out.println("|-----------|");
        System.out.println("| " + nullConv(board[6]) + " | " + nullConv(board[7]) + " | " + nullConv(board[8]) + " |");
        System.out.println("|---|---|---|");
    }
    */
}