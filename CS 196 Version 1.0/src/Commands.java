public class Commands {

	// Print Board
	public static String[][] printboard(Player a, Player b) {

		String[][] board = new String[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = "+";
			}
		}

		// Print Player 1
		a.printPlayer(board);

		// Print Player 2
		if (b.direction == 0) {
			board[b.yposition][b.xposition] = "n";
		}
		if (b.direction == 90) {
			board[b.yposition][b.xposition] = ")";
		}
		if (b.direction == 180) {
			board[b.yposition][b.xposition] = "u";
		}
		if (b.direction == 270) {
			board[b.yposition][b.xposition] = "(";
		}

		// Printing Full Board
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println("");
		}
		return board;
	}

	// Gets Moves
	public static int[] getmoves() {

		int[] moves = new int[5];
		for (int i = 0; i < 5; i++) {
			moves[i] = TextIO.getlnInt();
			if (moves[i] == 0) {
				i = i - 2;
			}
		}
		return moves;
	}

	// Tests if Moving into a Wall
	public static boolean[] testwall(int x[], Player a) {

		boolean[] wall = new boolean[5];

		for (int i = 0; i < 5; i++) {
			wall[i] = true;
			if (x[i] == 1) {
				if (a.direction == 0 && a.yposition == 0) {
					wall[i] = false;
				}
				if (a.direction == 90 && a.xposition == 4) {
					wall[i] = false;
				}
				if (a.direction == 180 && a.yposition == 4) {
					wall[i] = false;
				}
				if (a.direction == 270 && a.xposition == 0) {
					wall[i] = false;
				}
			}
		}
		return wall;
	}

	// Tests if Moving into Another Player
	public static boolean[] testmoveplayer(int x[], int y[], Player a, Player b) {

		boolean[] moveplayer = new boolean[5];

		for (int i = 0; i < 5; i++) {
			moveplayer[i] = true;
			if (x[i] == 1) {
				if (a.direction == 0 && a.xposition == b.xposition
						&& a.yposition == b.yposition + 1) {
					moveplayer[i] = false;
				}
				if (a.direction == 90 && a.yposition == b.yposition
						&& a.xposition == b.xposition + 1) {
					moveplayer[i] = false;
				}
				if (a.direction == 180 && a.xposition == b.xposition
						&& a.yposition == b.yposition - 1) {
					moveplayer[i] = false;
				}
				if (a.direction == 270 && a.yposition == b.yposition
						&& a.xposition == b.xposition - 1) {
					moveplayer[i] = false;
				}
			}
			if (y[i] == 1) {
				if (b.direction == 0 && a.xposition == b.xposition
						&& b.yposition == a.yposition - 1) {
					moveplayer[i] = false;
				}
				if (b.direction == 90 && a.yposition == b.yposition
						&& b.xposition == a.xposition - 1) {
					moveplayer[i] = false;
				}
				if (b.direction == 180 && a.xposition == b.xposition
						&& b.yposition == a.yposition + 1) {
					moveplayer[i] = false;
				}
				if (b.direction == 270 && a.yposition == b.yposition
						&& b.xposition == a.xposition + 1) {
					moveplayer[i] = false;
				}
			}
		}
		return moveplayer;
	}

	// Tests if Moving into Same Space
	public static boolean[] testmovespace(int x[], int y[], Player a, Player b) {

		boolean[] movespace = new boolean[5];

		for (int i = 0; i < 5; i++) {
			movespace[i] = true;
			if (x[i] == 1 && y[i] == 1) {
				if (a.direction == 0 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition + 1) {
					movespace[i] = false;
				}
				if (a.direction == 0 && b.direction == 180
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition + 2) {
					movespace[i] = false;
				}
				if (a.direction == 0 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition + 1) {
					movespace[i] = false;
				}
				if (a.direction == 90 && b.direction == 0
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition - 1) {
					movespace[i] = false;
				}
				if (a.direction == 90 && b.direction == 180
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition + 1) {
					movespace[i] = false;
				}
				if (a.direction == 90 && b.direction == 270
						&& a.xposition == b.xposition - 2
						&& a.yposition == b.yposition) {
					movespace[i] = false;
				}
				if (a.direction == 180 && b.direction == 0
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition - 2) {
					movespace[i] = false;
				}
				if (a.direction == 180 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition - 1) {
					movespace[i] = false;
				}
				if (a.direction == 180 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition - 1) {
					movespace[i] = false;
				}
				if (a.direction == 270 && b.direction == 0
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition - 1) {
					movespace[i] = false;
				}
				if (a.direction == 270 && b.direction == 90
						&& a.xposition == b.xposition + 2
						&& a.yposition == b.yposition) {
					movespace[i] = false;
				}
				if (a.direction == 270 && b.direction == 180
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition + 1) {
					movespace[i] = false;
				}
			}
		}
		return movespace;
	}

	// Tests if Attacking Each Other

	public static boolean[] testattacking(int x[], int y[], Player a, Player b) {

		boolean[] attacking = new boolean[5];
		for (int i = 0; i < 5; i++) {
			attacking[i] = true;
			if (x[i] == 5 && y[i] == 5) {
				if (a.direction == 0 && b.direction == 180
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition + 1) {
					attacking[i] = false;
				}
				if (a.direction == 90 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition) {
					attacking[i] = false;
				}
				if (a.direction == 180 && b.direction == 0
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition - 1) {
					attacking[i] = false;
				}
				if (a.direction == 270 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition) {
					attacking[i] = false;
				}
			}
		}
		return attacking;
	}

	// Tests if Move is Valid
	public static boolean[] testvalid(boolean a[], boolean b[], boolean c[]) {

		boolean[] valid = new boolean[5];

		for (int i = 0; i < 5; i++) {
			valid[i] = a[i] && b[i] && b[i];
		}
		return valid;
	}

	// Tests if Attack Connects

	public static int testattackconnect(int x[], int y[], Player a, Player b) {

		int win = 0;

		for (int i = 0; i < 5; i++) {
			if (x[i] == 5) {
				if (a.direction == 0 && a.xposition == b.xposition
						&& a.yposition == b.yposition + 1) {
					win = 1;
				}
				if (a.direction == 90 && a.xposition == b.xposition - 1
						&& a.yposition == b.yposition) {
					win = 1;
				}
				if (a.direction == 180 && a.xposition == b.xposition
						&& a.yposition == b.yposition - 1) {
					win = 1;
				}
				if (a.direction == 270 && a.xposition == b.xposition + 1
						&& a.yposition == b.yposition) {
					win = 1;
				}
			}
			if (y[i] == 5) {
				if (b.direction == 0 && b.xposition == a.xposition
						&& b.yposition == a.yposition + 1) {
					win = 2;
				}
				if (b.direction == 90 && b.xposition == a.xposition - 1
						&& b.yposition == a.yposition) {
					win = 2;
				}
				if (b.direction == 180 && b.xposition == a.xposition
						&& b.yposition == a.yposition - 1) {
					win = 2;
				}
				if (b.direction == 270 && b.xposition == a.xposition + 1
						&& b.yposition == a.yposition) {
					win = 2;
				}
			}
			if (win != 0 || win != 0) {
				break;
			}
		}
		return win;
	}

	// Tests if Moving Into an Attack

	public static int testmoveattack(int x[], int y[], Player a, Player b,
			boolean p[]) {

		int win = 0;
		for (int i = 0; i < 5; i++) {
			if (x[i] == 5 && y[i] == 1 && p[i] == true) {
				if (a.direction == 0 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition + 1) {
					win = 1;
				}
				if (a.direction == 0 && b.direction == 180
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition + 2) {
					win = 1;
				}
				if (a.direction == 0 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition + 1) {
					win = 1;
				}
				if (a.direction == 90 && b.direction == 0
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition - 1) {
					win = 1;
				}
				if (a.direction == 90 && b.direction == 180
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition + 1) {
					win = 1;
				}
				if (a.direction == 90 && b.direction == 270
						&& a.xposition == b.xposition - 2
						&& a.yposition == b.yposition) {
					win = 1;
				}
				if (a.direction == 180 && b.direction == 0
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition - 2) {
					win = 1;
				}
				if (a.direction == 180 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition - 1) {
					win = 1;
				}
				if (a.direction == 180 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition - 1) {
					win = 1;
				}
				if (a.direction == 270 && b.direction == 0
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition - 1) {
					win = 1;
				}
				if (a.direction == 270 && b.direction == 90
						&& a.xposition == b.xposition + 2
						&& a.yposition == b.yposition) {
					win = 1;
				}
				if (a.direction == 270 && b.direction == 180
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition + 1) {
					win = 1;
				}
			}
			if (x[i] == 1 && y[i] == 5 && p[i] == true) {
				if (a.direction == 0 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition + 1) {
					win = 2;
				}
				if (a.direction == 0 && b.direction == 180
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition + 2) {
					win = 2;
				}
				if (a.direction == 0 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition + 1) {
					win = 2;
				}
				if (a.direction == 90 && b.direction == 0
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition - 1) {
					win = 2;
				}
				if (a.direction == 90 && b.direction == 180
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition + 1) {
					win = 2;
				}
				if (a.direction == 90 && b.direction == 270
						&& a.xposition == b.xposition - 2
						&& a.yposition == b.yposition) {
					win = 2;
				}
				if (a.direction == 180 && b.direction == 0
						&& a.xposition == b.xposition
						&& a.yposition == b.yposition - 2) {
					win = 2;
				}
				if (a.direction == 180 && b.direction == 90
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition - 1) {
					win = 2;
				}
				if (a.direction == 180 && b.direction == 270
						&& a.xposition == b.xposition - 1
						&& a.yposition == b.yposition - 1) {
					win = 2;
				}
				if (a.direction == 270 && b.direction == 0
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition - 1) {
					win = 2;
				}
				if (a.direction == 270 && b.direction == 90
						&& a.xposition == b.xposition + 2
						&& a.yposition == b.yposition) {
					win = 2;
				}
				if (a.direction == 270 && b.direction == 180
						&& a.xposition == b.xposition + 1
						&& a.yposition == b.yposition + 1) {
					win = 2;
				}
			}
		}
		return win;
	}
}