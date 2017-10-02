package com.example.drawing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.example.game.R;

public class GameBoard extends View {
	
	private Drawable background;
	private Rect sprite1Bounds = new Rect(0,0,0,0);
	private Rect sprite2Bounds = new Rect(0,0,0,0);
	
	private Rect sprite3Bounds = new Rect(0,0,0,0);
	
    private Point sprite1;
    private Point sprite2;
    
    private Point sprite3; //winscreen1
    
    private Bitmap bm1 = null;
    private Bitmap bm2 = null;
    
    private Bitmap bm3 = null;
    
	public GameBoard(Context context, AttributeSet aSet)
	{
		super (context, aSet);	
		background = context.getResources().getDrawable(R.drawable.background);
		
		sprite1 = new Point (-1,-1);
		bm1 = BitmapFactory.decodeResource(getResources(),R.drawable.ufo);
		sprite1Bounds = new Rect (0,0,bm1.getWidth(),bm1.getHeight());
		
		sprite2 = new Point (-1,-1);
		bm2 = BitmapFactory.decodeResource(getResources(),R.drawable.ufo);
		sprite2Bounds = new Rect (0,0,bm1.getWidth(),bm1.getHeight());
		
		
		
	}
	

	
	@Override
	synchronized public void onDraw(Canvas canvas)
	{
		Rect imageBounds = canvas.getClipBounds(); 

        background.setBounds(imageBounds);
        background.draw(canvas);
		
        //draw sprites
        if (sprite1.x >= 0)
        {
        	canvas.drawBitmap(bm1, sprite1.x, sprite1.y, null);
        }
        if (sprite2.x >= 0)
        {
        	canvas.drawBitmap(bm2, sprite2.x, sprite2.y, null);
        }
        
	}
	

	
	//sprite 1 setter
	synchronized public void setSprite1(Point p) 
	{
        sprite1 = p;
	}

	 //sprite 1 getter
	 synchronized public Point getSprite1() 
	 {
	       return sprite1;
	 }
	 
	 
	 
	 
	synchronized public void setSprite2(Point p) 
		{
	        sprite2 = p;
		}

	synchronized public Point getSprite2() 
		 {
		       return sprite2;
		 }



	synchronized public void setSprite3(Point p) 
	{
        sprite3 = p;
	}

synchronized public Point getSprite3() 
	 {
	       return sprite3;
	 }

}
