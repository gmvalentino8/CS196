public class Game {
	// Starting the Game
	public static void main(String[] arg) {

		// Creating the Players
		Player p1 = new Player(0, 0, 90);
		Player p2 = new Player(4, 4, 270);

		// Giving Winning Conditions
		int win1 = 0;
		int win2 = 0;
		
		
		while (win1 == 0 && win2 == 0) {

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
				boolean[] moveplayer = new boolean[5];
				moveplayer = Commands.testmoveplayer(moves1, moves2, p1, p2);

				// Tests if Moving into a Wall for Player 1
				boolean[] wall1 = new boolean[5];
				wall1 = Commands.testwall(moves1, p1);

				// Tests if Moving into a Wall for Player 2
				boolean[] wall2 = new boolean[5];
				wall2 = Commands.testwall(moves2, p2);

				// Tests if Moving into Same Space
				boolean[] movespace = new boolean[5];
				movespace = Commands.testmovespace(moves1, moves2, p1, p2);

				// Tests if Attacking Each Other
				boolean[] attacking = new boolean[5];
				attacking = Commands.testattacking(moves1, moves2, p1, p2);

				// Tests if Move is Valid
				boolean[] valid = new boolean[5];
				valid = Commands.testvalid(movespace, moveplayer, attacking);

				// Tests if Attack Connects
				win1 = Commands.testattackconnect(moves1, moves2, p1, p2);

				// Tests if Moving Into an Attack
				win2 = Commands.testmoveattack(moves1, moves2, p1, p2, valid);

				// Executes Moves
				p1.execute(moves1, valid, wall1, i);
				p2.execute(moves2, valid, wall2, i);

				// For Debugging

				 Commands.printboard(p1, p2);
				 System.out.print(valid[i]); System.out.print(movespace[i]);
				 System.out.print(moveplayer[i]);
				 System.out.println(attacking[i]);

			}
		}
		System.out.print("Player " + (win1 + win2) + " wins!");
	}
}
