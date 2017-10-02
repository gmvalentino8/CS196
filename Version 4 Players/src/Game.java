public class Game {
	
	// Starting the Game
	public static void main(String[] arg) {

		// Creating the Players
		Player p1 = new Player(0, 0, 90, true, 1);
		Player p2 = new Player(4, 0, 180, true, 2);
		Player p3 = new Player(4, 4, 270, true, 3);
		Player p4 = new Player(0, 4, 0, true, 4);

		// Retrieve Number of Players
		System.out.println("Number of Players?");
		int number = TextIO.getlnInt();
		if (number == 2) {
			p1 = new Player(0, 0, 90, true, 1);
			p2 = new Player(4, 4, 270, true, 2);
			p3 = new Player(0, 0, 0, false, 3);
			p4 = new Player(0, 0, 0, false, 4);
		}
		if (number == 3) {
			p1 = new Player(2, 1, 0, true, 1);
			p2 = new Player(0, 3, 270, true, 2);
			p3 = new Player(4, 3, 90, true, 3);
			p4 = new Player(0, 0, 0, false, 4);
		}

		// Giving Winning Conditions
		while ((p1.live && p2.live) || (p1.live && p3.live)
				|| (p1.live && p4.live) || (p2.live && p3.live)
				|| (p2.live && p4.live) || (p3.live && p4.live)) {

			// Initializing Board
			Commands.printboard(p1, p2, p3, p4);

			// Gives Move List
			int[] moves1 = p1.getmoves();
			int[] moves2 = p2.getmoves();
			int[] moves3 = p3.getmoves();
			int[] moves4 = p4.getmoves();

			// Sets up One Turn with 5 Commands
			for (int i = 0; i < 5; i++) {

				// Tests if Movements are Valid
				boolean movement1 = true, movement2 = true, movement3 = true, movement4 = true;

				if (p1.live) {
					movement1 = Commands.testmove(moves1, moves2, p1, p2, i)
							&& Commands.testmove(moves1, moves3, p1, p3, i)
							&& Commands.testmove(moves1, moves4, p1, p4, i);
					p1.live = !Commands.testattack(moves2, moves1, p2, p1, i)
							&& !Commands.testattack(moves3, moves1, p3, p1, i)
							&& !Commands.testattack(moves4, moves1, p4, p1, i);
				}
				if (p2.live) {
					movement2 = Commands.testmove(moves2, moves1, p2, p1, i)
							&& Commands.testmove(moves2, moves3, p2, p3, i)
							&& Commands.testmove(moves2, moves4, p2, p4, i);
					p2.live = !Commands.testattack(moves1, moves2, p1, p2, i)
							&& !Commands.testattack(moves3, moves2, p3, p2, i)
							&& !Commands.testattack(moves3, moves2, p3, p2, i);
				}
				if (p3.live) {
					movement3 = Commands.testmove(moves3, moves1, p3, p1, i)
							&& Commands.testmove(moves3, moves2, p3, p2, i)
							&& Commands.testmove(moves3, moves4, p3, p4, i);
					p3.live = !Commands.testattack(moves1, moves3, p1, p3, i)
							&& !Commands.testattack(moves2, moves3, p2, p3, i)
							&& !Commands.testattack(moves4, moves3, p4, p3, i);
				}
				if (p4.live) {
					movement4 = Commands.testmove(moves4, moves1, p4, p1, i)
							&& Commands.testmove(moves4, moves2, p4, p2, i)
							&& Commands.testmove(moves4, moves3, p4, p3, i);
					p4.live = !Commands.testattack(moves1, moves4, p1, p4, i)
							&& !Commands.testattack(moves2, moves4, p2, p4, i)
							&& !Commands.testattack(moves3, moves4, p3, p4, i);
				}

				// Executes Moves
				p1.execute(moves1, movement1, i);
				p2.execute(moves2, movement2, i);
				p3.execute(moves3, movement3, i);
				p4.execute(moves4, movement4, i);

				// For Debugging

				// Commands.printboard(p1, p2, p3, p4);
				// System.out.print(p1.live);
				// System.out.print(wall2);
				// System.out.print(attacking);
				// System.out.print(moveplayer2);
				// System.out.println();

			}
		}
		if (p1.live) {
			System.out.print("Player 1 wins!");
		}
		if (p2.live) {
			System.out.print("Player 2 wins!");
		}
		if (p3.live) {
			System.out.print("Player 3 wins!");
		}
		if (p4.live) {
			System.out.print("Player 4 wins!");
		}
	}
}
