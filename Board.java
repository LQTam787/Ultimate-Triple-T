/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Board;

/**
 *
 * @author lqtam
 */
public class Board {
    /* the board is stored as an array of subboards
    each element represents the subboard with the corresponding index:
    |---|---|---|
    | 0 | 1 | 2 |
    |-----------|
    | 3 | 4 | 5 |
    |-----------|
    | 6 | 7 | 8 |
    |---|---|---| */
    /**
     *
     */
    protected String[][] subboards;
    /**
     *
     */
    protected String[] board;
    /**
     *
     */
    protected int[] moveCount;
    /**
     *
     */
    protected int nowPlayingOn;
    /**
     *
     */
    protected int boardsConcluded;

    /**
     *
     */
    public Board() {
        this.boardsConcluded = 0;
        this.moveCount = new int[9];
        this.nowPlayingOn = -1;
        this.board = new String[9];
        this.subboards = new String[9][9];
    }

    // validMove returns a boolean value
    // true means a move is valid
    // false means a move is invalid

    /**
     *
     * @param subboard
     * @param pos
     * @return
     */
    public boolean validMove (int subboard, int pos) {
        if (nowPlayingOn == -1 && subboards[subboard][pos] == null) {
            return true;
        } else if (board[nowPlayingOn] != null && subboards[subboard][pos] == null) {
            return true;
        } else return (board[nowPlayingOn] == null && subboards[nowPlayingOn][pos] == null);
    }

    // move will only play if validMove is true
    // player should be X or O
    public void move (int subboard, int pos, String player) {
	if (validMove(subboard, pos)) {
            subboards[subboard][pos] = player;
            moveCount[subboard]++;
            nowPlayingOn = pos;
        }
    }

    // checkWin returns an int
    // 0 means the game is not finished
    // 1 for X win
    // 2 for O win
    // 3 for draw
    public int checkWinOnSubboard(int subboard) {
        if (moveCount[subboard] < 5) {
            return 0;
	}

	for (int i = 0; i < 8; i++) {
            String line = null;
 
            switch (i) {
            case 0 -> line = subboards[subboard][0] + subboards[subboard][1] + subboards[subboard][2];
            case 1 -> line = subboards[subboard][3] + subboards[subboard][4] + subboards[subboard][5];
            case 2 -> line = subboards[subboard][6] + subboards[subboard][7] + subboards[subboard][8];
            case 3 -> line = subboards[subboard][0] + subboards[subboard][3] + subboards[subboard][6];
            case 4 -> line = subboards[subboard][1] + subboards[subboard][4] + subboards[subboard][7];
            case 5 -> line = subboards[subboard][2] + subboards[subboard][5] + subboards[subboard][8];
            case 6 -> line = subboards[subboard][0] + subboards[subboard][4] + subboards[subboard][8];
            case 7 -> line = subboards[subboard][2] + subboards[subboard][4] + subboards[subboard][6];
            }

            if (line.equals("XXX")) {
                return 1;
            } else if (line.equals("OOO")) {
                return 2;
            }
        }

        if (moveCount[subboard] > 8) {
            return 3;
        }

        return 0;
    }
    
    public void Update() {
        for (int i = 0; i < 8; i++) {
            switch (checkWinOnSubboard(i)) {
                case 1 -> {
                    board[i] = "X";
                    boardsConcluded++;
                    break;
                }
                case 2 -> {
                    board[i] = "O";
                    boardsConcluded++;
                    break;
                }
                case 3 -> {
                    board[i] = "D";
                    boardsConcluded++;
                    break;
                }
            }
        }
    }
    
    public int checkWin() {
        if (boardsConcluded < 5) {
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

        if (boardsConcluded > 8) {
            return 3;
        }

        return 0;
    }
}
