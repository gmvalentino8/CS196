public class Player {

	// Parameters for Player
	public int xposition;
	public int yposition;
	public int direction;
	public boolean live;
	
	// Constructor for Player
	public Player(int x, int y, int dir) {
		xposition = x;
		yposition = y;
		direction = dir;
		live = true;
	}
	
	// Print Player
	public void printPlayer(String board[][]) {

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
	
	// Executes Movement
	public void execute(int[] moves, boolean attacking, boolean movement, int j) {
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
