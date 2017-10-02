package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.drawing.GameBoard;

public class MainGame extends Activity {
	
//	private final int start1_x = 0;
//	private final int start1_y = 0;
//	private final int start2_x = 4;
//	private final int start2_y = 4;
	private int whichPlayer = 1;
	
	private int[] moves1 = null;
	private int[] moves2 = null;
	private int index = 0; 
	
	private Player p1= null;
	private Player p2=null;
	
	// Giving Winning Conditions
    private boolean win1;
    private boolean win2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_game);
		// Show the Up button in the action bar.
		
		win1=false;
		win2=false;
		
		//create moves array
		moves1 = new int[5];
		moves2 = new int[5];
		
		 // Creating the Players
		p1 = new Player(0, 0, 90);
        p2 = new Player(4, 4, 270);
        	
		
        //convert index to coordinates
        
     
        
		
		((GameBoard)findViewById(R.id.the_canvas)).setSprite1(new Point (40, 40));
		((GameBoard)findViewById(R.id.the_canvas)).setSprite2(new Point (610, 660));
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void turnLeft(View view) {
		
		if (index>=5) return;
		
		if(whichPlayer == 1){
			moves1[index] = 3;
			movesView(index, 3);
			index ++;
			Log.d("game", "turnLeft button for player 1");
			
			
		}
		else{
			moves2[index] = 3;
			movesView(index, 3);
			index ++;
			Log.d("game", "turnLeft button for player 2");
		
		}
		
		
//		setContentView(R.layout.activity_main_game);
//		((GameBoard)findViewById(R.id.the_canvas)).setSprite1(new Point (150,150));
		
		
	}
	
	public void turnRight(View view) {
		
		if (index>=5) return;
		
		if (whichPlayer ==1 ){
			moves1[index] = 2;
			movesView(index, 2);
			index++;
		
			Log.d("game", "turnRight button for player 1");
		}
		else{
			moves2[index] = 2;
			movesView(index, 2);
			index ++;
			Log.d("game", "turnRight button for player 2");
		}
		
//		setContentView(R.layout.activity_main_game);
//		((GameBoard)findViewById(R.id.the_canvas)).setSprite2(new Point (250,150));
//		
		
	}
	
	public void move(View view){
		
		if (index>=5) return;
		
		if (whichPlayer ==1 ){
			moves1[index] = 1;
			movesView(index, 1);
			index++;
			
			Log.d("game", "move button for player 1");
		}
		else{
			moves2[index] = 1;
			movesView(index, 1);
			index ++;
			Log.d("game", "move button for player 2");
		}
	}
	
	public void attack(View view){
		
		if (index>=5) return;
		
		if (whichPlayer == 1 ){
			moves1[index] = 5;
			movesView(index, 5);
			index++;
			Log.d("game", "attk button for player 1");
		}
		else{
			moves2[index] = 5;
			movesView(index, 5);
			index ++;
			Log.d("game", "attk button for player 2");
		}
	}

	
	public void turnAround(View view){
		
		if (index>=5) return;
		
		if (whichPlayer == 1 ){
			moves1[index] = 4;
			movesView(index, 4);
			index++;
			Log.d("game", "turnAround button for player 1");
		}
		else{
			moves2[index] = 4;
			movesView(index, 4);
			index ++;
			Log.d("game", "turnAround button for player 2");
		}
	}
	
	public void cancelLastMove(View view)
	{
		if (index == 5) index = 4;
		else if (index ==0) return;
		else index --;
		
		if (whichPlayer == 1 )
		{
			moves1[index] = 0;
			movesView(index, 0);
			Log.d("game", "cancelLastMove button for player 1");
		}
		
		else
		{
			moves2[index] = 0;
			movesView(index, 0);
			Log.d("game", "cancelLastMove button for player 2");
		}
	}
	
	public void confirm(View view){
		
		
		index = 0;
		if(whichPlayer == 1){		//player1 turn
			Log.d("game", "confirm button for player 1");
			whichPlayer = 2;
			
			for (int i = 0; i < 5; i++)
			{
				movesView (i, 0);
			}
			
			//change textView to show player 2
			final TextView textViewToChange = (TextView) findViewById(R.id.player_turn);
			textViewToChange.setText("2");
		
			
		}
		else{						//player 2 turn
			Log.d("game", "confirm button for player 1");
			whichPlayer = 1;
			Log.d("game", "before evaulate is called");
			evaluate();
			
			//reset moves1 and moves2
			for (int i = 0; i < 5; i++)
			{
				moves1[i] = 0;
				moves2[i] = 0;
				movesView (i, 0);
			}
			
			Log.d("game", "final p1.x---" + String.valueOf(p1.xposition));
	        Log.d("game", "final p1.y---" + String.valueOf(p1.yposition));
	        Log.d("game", "final p1.d---" + String.valueOf(p1.direction));
	        Log.d("game", "final p2.x---" + String.valueOf(p2.xposition));
	        Log.d("game", "final p2.y---" + String.valueOf(p2.yposition));
	        Log.d("game", "final p2.d---" + String.valueOf(p2.direction));
			
	        Log.d ("game", "before new screen");
	        setContentView(R.layout.activity_main_game);
	        if (p1.direction == 90)((GameBoard)findViewById(R.id.the_canvas)).setSprite1(new Point (p1.xposition*150+40,p1.yposition*155+40));
	        if (p1.direction == 0)((GameBoard)findViewById(R.id.the_canvas)).setSpriteMogF(new Point (p1.xposition*150+40,p1.yposition*155+40));
	        if (p1.direction == 180)((GameBoard)findViewById(R.id.the_canvas)).setSpriteMogB(new Point (p1.xposition*150+40,p1.yposition*155+40));
	        if (p1.direction == 270)((GameBoard)findViewById(R.id.the_canvas)).setSpriteMogL(new Point (p1.xposition*150+40,p1.yposition*155+40));
	    
			if (p2.direction == 270)((GameBoard)findViewById(R.id.the_canvas)).setSprite2(new Point (p2.xposition*150+40,p2.yposition*155+40));
			if (p2.direction == 0)((GameBoard)findViewById(R.id.the_canvas)).setSpriteGirlF(new Point (p2.xposition*150+40,p2.yposition*155+40));
			if (p2.direction == 180)((GameBoard)findViewById(R.id.the_canvas)).setSpriteGirlB(new Point (p2.xposition*150+40,p2.yposition*155+40));
			if (p2.direction == 90)((GameBoard)findViewById(R.id.the_canvas)).setSpriteGirlR(new Point (p2.xposition*150+40,p2.yposition*155+40));
			
			Log.d ("game", "after new screen");
			
			//change textView to player 1
			final TextView textViewToChange = (TextView) findViewById(R.id.player_turn);
			textViewToChange.setText("1");
			
			
			
			
			 if (win1) {
		            Log.d("game", "Player 1 wins!");
		            //setContentView(R.layout.winscreen);
			    	
			    	winScreen(view,1);
		            
		            
		        }
		        if(win2) {
		            Log.d("game","Player 2 wins!");
		            
		            winScreen(view,2);
		        }
	        
			//print new screen
		}
		
		
		
		
		
		
		//code that converts your integer index ranging from 0 to 4 to corresponding coordinates in pixels
		//example
		// public int convert(int x, int y){
		//	if x = 0 , x = 0
		// if x = 1 , x= 100
		// same as below for sprite 1
		
	}
	
	public void evaluate(){
	
		Log.d("game", "before update");
		for (int i=0; i<5; i++){
			Log.d("game", String.valueOf(moves1[i]));
			
		}
		for (int i=0; i<5; i++){
			Log.d("game", String.valueOf(moves2[i]));
			
		}
		
		Log.d("game", "p1.x---" + String.valueOf(p1.xposition));
        Log.d("game", "p1.y---" + String.valueOf(p1.yposition));
        Log.d("game", "p1.d---" + String.valueOf(p1.direction));
        Log.d("game", "p2.x---" + String.valueOf(p2.xposition));
        Log.d("game", "p2.y---" + String.valueOf(p2.yposition));
        Log.d("game", "p2.d---" + String.valueOf(p2.direction));
        
		
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
            

        

        }
        
        
        Log.d("game", "after update");
        Log.d("game", String.valueOf(p1.xposition));
        Log.d("game", String.valueOf(p1.yposition));
        Log.d("game", String.valueOf(p1.direction));
        Log.d("game", String.valueOf(p2.xposition));
        Log.d("game", String.valueOf(p2.yposition));
        Log.d("game", String.valueOf(p2.direction));
        

        
        
        /*if (win1) {
            Log.d("game", "Player 1 wins!");
            setContentView(R.layout.activity_main_game);
    		
	    	((GameBoard)findViewById(R.id.the_canvas)).setSprite1(new Point (0,0));
            
            
        }
        if(win2) {
            Log.d("game","Player 2 wins!");
            ((GameBoard)findViewById(R.id.the_canvas)).setSprite2(new Point (200,200));
        } */
        
    	
	}
	
	public void winScreen (View view, int won)
	{
		Intent intent = new Intent (this,WinScreen.class);
		intent.putExtra("won",won);
		startActivity (intent);
	}
	
	public void blank (View view)
	{
		return;
	}
	
	public void movesView (int index, int move)
	{
		
		TextView movesView = null;
		
		if (index == 0)		
			movesView = (TextView) findViewById(R.id.move0);
		else if (index == 1)
			movesView = (TextView) findViewById(R.id.move1);
		else if (index == 2)
			movesView = (TextView) findViewById(R.id.move2);
		else if (index == 3)
			movesView = (TextView) findViewById(R.id.move3);
		else if (index == 4)
			movesView = (TextView) findViewById(R.id.move4);
			
		if (move == 1)
				movesView.setText("F");
			else if (move == 2)
				movesView.setText("R");
			else if (move == 3)
				movesView.setText("L");
			else if (move == 4)
				movesView.setText("Ar");
			else if (move == 5)
				movesView.setText("A");
			else if (move == 0)
				movesView.setText("0");

		
		
		
	}


}