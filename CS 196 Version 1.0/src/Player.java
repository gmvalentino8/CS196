public class Player {

	// Parameters for Player
	public int xposition;
	public int yposition;
	public int direction;
	
	// Constructor for Player
	public Player(int x, int y, int dir) {
		xposition = x;
		yposition = y;
		direction = dir;
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
	
	// Executes Moves
	public void execute(int[] moves, boolean[] valid, boolean[] wall, int j) {
		if (moves[j] == 1 && valid[j] && wall[j]) {
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
		if (moves[j] == 2 && valid[j]) {
			direction = (direction + 90) % 360;				
		}
		if (moves[j] == 3 && valid[j]) {
			direction = (direction + 270) % 360;
		}
		if (moves[j] == 4 && valid[j]) {
			direction = (direction + 180) % 360;
		}
	}
}
