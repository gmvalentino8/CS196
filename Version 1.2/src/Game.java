public class Game {
	// Starting the Game
	public static void main(String[] arg) {

		// Creating the Players
		Player p1 = new Player(0, 0, 90);
		Player p2 = new Player(4, 4, 270);

		// Giving Winning Conditions
		
		while (p1.live && p2.live) {

			// Initializing Board
			Commands.printboard(p1, p2);

			// Gives Move List for Player 1
			System.out
					.println("Player 1 Pick 5 Moves\n1. Move\n2. Turn Right\n3. Turn Left\n4. Turn Around\n5. Attack");
			int[] moves1 = new int[6];
			moves1 = Commands.getmoves();
			
			
			// Give Move List for Player 2
			System.out
					.println("Player 2 Pick 5 Moves\n1. Move\n2. Turn Right\n3. Turn Left\n4. Turn Around\n5. Attack");
			int[] moves2 = new int[6];
			moves2 = Commands.getmoves();

			// Sets up One Turn with 5 Commands
			for (int i = 0; i < 5; i++) {
				// Tests if Attacking Each Other
				boolean attacking = Commands.testattacking(moves1, moves2, p1, p2, i);
				
				//if(moves1[1] == 5 && moves2[1] == 5 & !attacking) {
				//	win0 = true;
				//}
				
				// Tests if Movements are Valid
				boolean movement1 = Commands.testmove(moves1, moves2, p1, p2, i);				
				boolean movement2 = Commands.testmove(moves2, moves1, p2, p1, i);
				
				// Tests if Attack Connects
				p1.live = ! Commands.testattack(moves2, moves1, p2, p1, i);
				p2.live = ! Commands.testattack(moves1, moves2, p1, p2, i);

				// Executes Moves
				p1.execute(moves1, attacking, movement1, i);
				p2.execute(moves2, attacking, movement2, i);

				// For Debugging

				 //Commands.printboard(p1, p2);
				 //System.out.print(p1.live);
				 //System.out.print(wall2);
				 //System.out.print(attacking);
				 //System.out.print(moveplayer1);
				 //System.out.print(moveplayer2);
				// System.out.println();

			}
		}
		if (p1.live) {
			System.out.print("Player 1 wins!");
		}
		else if (p2.live) {
			System.out.print("Player 2 wins!");
		}
		else {
			System.out.print("Tie!");
		}
	}
}
