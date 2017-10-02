

package com.example.game;

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
     

    
    
    
     
    // Executes Movement
    public void execute(int[] moves, boolean movespace, boolean attacking, boolean wall, boolean moveplayer, int j) {
        if (moves[j] == 1 && movespace && wall && moveplayer) {
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


