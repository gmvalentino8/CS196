package com.example.game;

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
        //a.printPlayer(board);
 
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
            //moves[i] = TextIO.getlnInt();
            if (moves[i] == 0) {
                i = i - 2;
            }
        }
        return moves;
    } 
 
    // Tests if Moving into a Wall
    public static boolean testwall(int x[], Player a, int j) {
 
        boolean wall = true;
 
        if (x[j] == 1) {
                if (a.direction == 0 && a.yposition == 0) {
                    wall = false;
                }
                if (a.direction == 90 && a.xposition == 4) {
                    wall = false;
                }
                if (a.direction == 180 && a.yposition == 4) {
                    wall = false;
                }
                if (a.direction == 270 && a.xposition == 0) {
                    wall = false;
                }
        }
        return wall;
    }
 
    // Tests if Moving into Another Player
    public static boolean testmoveplayer(int x[], Player a, Player b, int j) {
 
        boolean moveplayer = true;
            if (x[j] == 1) {
                if (a.direction == 0 && a.xposition == b.xposition
                        && a.yposition == b.yposition + 1) {
                    moveplayer = false;
                }
                if (a.direction == 90 && a.yposition == b.yposition
                        && a.xposition == b.xposition + 1) {
                    moveplayer = false;
                }
                if (a.direction == 180 && a.xposition == b.xposition
                        && a.yposition == b.yposition - 1) {
                    moveplayer = false;
                }
                if (a.direction == 270 && a.yposition == b.yposition
                        && a.xposition == b.xposition - 1) {
                    moveplayer = false;
                }
        }
        return moveplayer;
    }
 
    // Tests if Moving into Same Space
    public static boolean testmovespace(int x[], int y[], Player a, Player b, int j) {
 
        boolean movespace = true;
 
            if (x[j] == 1 && y[j] == 1) {
                if (a.direction == 0 && b.direction == 90
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition + 1) {
                    movespace = false;
                }
                if (a.direction == 0 && b.direction == 180
                        && a.xposition == b.xposition
                        && a.yposition == b.yposition + 2) {
                    movespace = false;
                }
                if (a.direction == 0 && b.direction == 270
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition + 1) {
                    movespace = false;
                }
                if (a.direction == 90 && b.direction == 0
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition - 1) {
                    movespace = false;
                }
                if (a.direction == 90 && b.direction == 180
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition + 1) {
                    movespace = false;
                }
                if (a.direction == 90 && b.direction == 270
                        && a.xposition == b.xposition - 2
                        && a.yposition == b.yposition) {
                    movespace = false;
                }
                if (a.direction == 180 && b.direction == 0
                        && a.xposition == b.xposition
                        && a.yposition == b.yposition - 2) {
                    movespace = false;
                }
                if (a.direction == 180 && b.direction == 90
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition - 1) {
                    movespace = false;
                }
                if (a.direction == 180 && b.direction == 270
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition - 1) {
                    movespace = false;
                }
                if (a.direction == 270 && b.direction == 0
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition - 1) {
                    movespace = false;
                }
                if (a.direction == 270 && b.direction == 90
                        && a.xposition == b.xposition + 2
                        && a.yposition == b.yposition) {
                    movespace = false;
                }
                if (a.direction == 270 && b.direction == 180
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition + 1) {
                    movespace = false;
                }
            }
        return movespace;
    }
 
    // Tests if Attacking Each Other
 
    public static boolean testattacking(int x[], int y[], Player a, Player b, int j) {
 
        boolean attacking = true;
 
            if (x[j] == 5 && y[j] == 5) {
                if (a.direction == 0 && b.direction == 180
                        && a.xposition == b.xposition
                        && a.yposition == b.yposition + 1) {
                    attacking = false;
                }
                if (a.direction == 90 && b.direction == 270
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition) {
                    attacking = false;
                }
                if (a.direction == 180 && b.direction == 0
                        && a.xposition == b.xposition
                        && a.yposition == b.yposition - 1) {
                    attacking = false;
                }
                if (a.direction == 270 && b.direction == 90
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition) {
                    attacking = false;
                }
        }
        return attacking;
    }
 
    // Tests if Attack Connects
 
    public static boolean testattackconnect(int x[], Player a, Player b, boolean attacking, int j) {
 
        boolean win = false;
 
            if (x[j] == 5 && attacking) {
                if (a.direction == 0 && a.xposition == b.xposition
                        && a.yposition == b.yposition + 1) {
                    win = true;
                }
                if (a.direction == 90 && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition) {
                    win = true;
                }
                if (a.direction == 180 && a.xposition == b.xposition
                        && a.yposition == b.yposition - 1) {
                    win = true;
                }
                if (a.direction == 270 && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition) {
                    win = true;
                }
            }
        return win;
    }
 
    // Tests if Moving Into an Attack
 
    public static boolean testmoveattack(int x[], int y[], Player a, Player b,
            boolean p, int j) {
 
        boolean win = false;
            if (x[j] == 5 && y[j] == 1 && p) {
                if (a.direction == 0 && b.direction == 90
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition + 1) {
                    win = true;
                }
                if (a.direction == 0 && b.direction == 180
                        && a.xposition == b.xposition
                        && a.yposition == b.yposition + 2) {
                    win = true;
                }
                if (a.direction == 0 && b.direction == 270
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition + 1) {
                    win = true;
                }
                if (a.direction == 90 && b.direction == 0
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition - 1) {
                    win = true;
                }
                if (a.direction == 90 && b.direction == 180
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition + 1) {
                    win = true;
                }
                if (a.direction == 90 && b.direction == 270
                        && a.xposition == b.xposition - 2
                        && a.yposition == b.yposition) {
                    win = true;
                }
                if (a.direction == 180 && b.direction == 0
                        && a.xposition == b.xposition
                        && a.yposition == b.yposition - 2) {
                    win = true;
                }
                if (a.direction == 180 && b.direction == 90
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition - 1) {
                    win = true;
                }
                if (a.direction == 180 && b.direction == 270
                        && a.xposition == b.xposition - 1
                        && a.yposition == b.yposition - 1) {
                    win = true;
                }
                if (a.direction == 270 && b.direction == 0
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition - 1) {
                    win = true;
                }
                if (a.direction == 270 && b.direction == 90
                        && a.xposition == b.xposition + 2
                        && a.yposition == b.yposition) {
                    win = true;
                }
                if (a.direction == 270 && b.direction == 180
                        && a.xposition == b.xposition + 1
                        && a.yposition == b.yposition + 1) {
                    win = true;
                }
            }
        return win;
    }
}