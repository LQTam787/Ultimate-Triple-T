import java.util.Scanner;

public class UTTT {
	//the subBoard array represents the small boards, whose cells we play dirrectly to
	//the bigBoard object represents the big board, whose cells are the small boards
	//we only play on the bigBoard when the corresponding small board is finished
	protected Board bigBoard = new Board(); //a cell in the bigBoard can also be "-", denoting a draw
	protected Board[] subBoard = new Board[9];
	protected int curr = 4; //current subBoard, start at the middle
	protected String player = "X"; //current player, X goes first

	public UTTT() {
		for (int i = 0; i < subBoard.length; i++) {
   			subBoard[i] = new Board();
		}
	}

	Scanner sc = new Scanner(System.in);

	public void bigMove () {
		//handles being sent to a finished board
		while (!bigBoard.validMove(curr)) {
			System.out.println(player + " has been sent to a finished board. Pick any other board to continue playing in:");
			curr = sc.nextInt();
		}

		//makes a move in subBoard[curr]
		int pos;
		while (true) {
    		System.out.println(player + " playing in board " + curr);
    		System.out.println(player + "'s turn. Enter a number 0 - 8:");
    		pos = sc.nextInt();
    		if (subBoard[curr].validMove(pos)) {
    			subBoard[curr].move(pos, player);
    			break;
    		} else {
    			System.out.println("Invalid move.");
    		}
    	}

    	//check to see if the board that was just played in reached an end state and play to the corresponding bigBoard cell
    	//will glitch if checkWin ever returns something outside of 0-3
    	if (subBoard[curr].checkWin() == 3) {
    		bigBoard.move(curr, "-");
    	} else if (subBoard[curr].checkWin() != 0) {
    		bigBoard.move(curr, player);
    	}

    	//changes parameters for next turn
    	if (player.equals("X")) {
    		player = "O";
    	} else {
    		player = "X";
    	}
    	curr = pos;
	}

	public void printWin () {
		String message;
		switch (bigBoard.checkWin()) {
		case 0:
			message = "It's not done yet! This really shouldn't have been printed...";
			break;
		case 1:
			message = "X wins! It's over!";
			break;
		case 2:
			message = "O wins! It's over!";
			break;
		case 3:
			message = "A draw! It's over!";
			break;
		default:
			message = "ERROR!";
			break;
		}
		System.out.println(message);
	}

	//executes an entire game of UTTT
	public void game() {
    	System.out.println("Welcome to Ultimate Tic Tac Toe. Let's go!");
    	while (bigBoard.checkWin() == 0) {
    		bigMove();
    	}
    	printWin();
    }
}