public class Game {
	// Starting the Game
	public static void main(String[] arg) {

		// Creating the Players
		Player p1 = new Player(0, 0, 90);
		Player p2 = new Player(4, 4, 270);

		// Giving Winning Conditions
		boolean win1 = false;
		boolean win2 = false;
		
		
		while (!win1 && !win2) {

			// Initializing Board
			Commands.printboard(p1, p2);

			// Gives Move List for Player 1
			System.out
					.println("Player 1 Pick 5 Moves\n1. Move\n2. Turn Right\n3. Turn Left\n4. Turn Around\n5. Attack");
			int[] moves1 = new int[5];
			moves1 = Commands.getmoves();

			// Give Move List for Player 2
			System.out
					.println("Player 2 Pick 5 Moves\n1. Move\n2. Turn Right\n3. Turn Left\n4. Turn Around\n5. Attack");
			int[] moves2 = new int[5];
			moves2 = Commands.getmoves();

			// Sets up One Turn with 5 Commands
			for (int i = 0; i < 5; i++) {

				// Tests if Moving into Another Player
				boolean moveplayer1 = Commands.testmoveplayer(moves1, p1, p2, i);
				
				boolean moveplayer2 = Commands.testmoveplayer(moves2, p2, p1, i);

				// Tests if Moving into a Wall for Player 1
				boolean wall1 = Commands.testwall(moves1, p1, i);

				// Tests if Moving into a Wall for Player 2
				boolean wall2 = Commands.testwall(moves2, p2, i);

				// Tests if Moving into Same Space
				boolean movespace = Commands.testmovespace(moves1, moves2, p1, p2, i);

				// Tests if Attacking Each Other
				boolean attacking = Commands.testattacking(moves1, moves2, p1, p2, i);

				// Tests if Attack Connects
				win1 = Commands.testattackconnect(moves1, p1, p2, attacking, i) || Commands.testmoveattack(moves1, moves2, p1, p2, attacking, i);

				// Tests if Moving Into an Attack
				win2 = Commands.testattackconnect(moves2, p2, p1, attacking, i) || Commands.testmoveattack(moves2, moves1, p2, p1, attacking, i);

				// Executes Moves
				p1.execute(moves1, movespace, attacking, wall1, moveplayer1, i);
				p2.execute(moves2, movespace, attacking, wall2, moveplayer2, i);

				// For Debugging

				 //Commands.printboard(p1, p2);
				 //System.out.print(wall1);
				 //System.out.print(wall2);
				 //System.out.print(attacking);
				 //System.out.print(moveplayer1);
				 //System.out.print(moveplayer2);
				// System.out.println();

			}
		}
		if (win1) {
			System.out.print("Player 1 wins!");
		}
		else {
			System.out.print("Player 2 wins!");
		}
	}
}
