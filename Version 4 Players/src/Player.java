public class Player {

	// Parameters for Player
	public int xposition;
	public int yposition;
	public int direction;
	public boolean live;
	public int count;

	// Constructor for Player
	public Player(int x, int y, int dir, boolean a, int i) {
		xposition = x;
		yposition = y;
		direction = dir;
		live = a;
		count = i;
	}

	// Print Player
	public void printPlayer(String board[][]) {
		if (live) {
			if (direction == 0) {
				board[yposition][xposition] = "^";
			}
			if (direction == 90) {
				board[yposition][xposition] = ">";
			}
			if (direction == 180) {
				board[yposition][xposition] = "v";
			}
			if (direction == 270) {
				board[yposition][xposition] = "<";
			}
		}
	}

	// Gets Moves
	public int[] getmoves() {
		int[] moves = new int[6];
		if (live) {
			System.out
					.println("Player "
							+ count
							+ " Pick 5 Moves\n1. Move\n2. Turn Right\n3. Turn Left\n4. Turn Around\n5. Attack\n0. Confirm");
			for (int i = 0; i < 6; i++) {
				moves[i] = TextIO.getlnInt();
				if (moves[i] == 6) {
					i = i - 2;
				}
				if (moves[5] != 0) {
					i = i - 1;
				}
			}
		}
		return moves;
	}

	// Executes Movement
	public void execute(int[] moves, boolean movement, int j) {
		if (moves[j] == 1 && movement) {
			if (direction == 0) {
				yposition--;
			}
			if (direction == 90) {
				xposition++;
			}
			if (direction == 180) {
				yposition++;
			}
			if (direction == 270) {
				xposition--;
			}
		}
		if (moves[j] == 2) {
			direction = (direction + 90) % 360;
		}
		if (moves[j] == 3) {
			direction = (direction + 270) % 360;
		}
		if (moves[j] == 4) {
			direction = (direction + 180) % 360;
		}
	}
}
