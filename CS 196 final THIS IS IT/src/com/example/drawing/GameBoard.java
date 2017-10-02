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
    
    private Bitmap bm2L = null;
    
    private Bitmap bm3 = null;
    
    private Point spriteMogF;
    private Bitmap bmspriteMogF = null;
    private Rect bmspriteMogFBounds = new Rect(0,0,0,0);
    
    private Point spriteMogB;
    private Bitmap bmspriteMogB = null;
    private Rect bmspriteMogBBounds = new Rect(0,0,0,0);
    
    private Point spriteMogL;
    private Bitmap bmspriteMogL = null;
    private Rect bmspriteMogLBounds = new Rect(0,0,0,0);


    
    private Point spriteGirlF;
    private Bitmap bmspriteGirlF = null;
    private Rect bmspriteGirlFBounds = new Rect(0,0,0,0);
    
    private Point spriteGirlB;
    private Bitmap bmspriteGirlB = null;
    private Rect bmspriteGirlBBounds = new Rect(0,0,0,0);
    
    private Point spriteGirlR;
    private Bitmap bmspriteGirlR = null;
    private Rect bmspriteGirlRBounds = new Rect(0,0,0,0);


    
	public GameBoard(Context context, AttributeSet aSet)
	{
		super (context, aSet);	
		background = context.getResources().getDrawable(R.drawable.background);
		
		sprite1 = new Point (-1,-1);
		bm1 = BitmapFactory.decodeResource(getResources(),R.drawable.mogright);
		sprite1Bounds = new Rect (0,0,bm1.getWidth(),bm1.getHeight());
		
		spriteMogF = new Point (-1,-1);
		bmspriteMogF = BitmapFactory.decodeResource(getResources(),R.drawable.mogfront);
		bmspriteMogFBounds = new Rect(0,0,bmspriteMogF.getWidth(),bmspriteMogF.getHeight());
		
		spriteMogB = new Point (-1,-1);
		bmspriteMogB = BitmapFactory.decodeResource(getResources(),R.drawable.mogback);
		bmspriteMogBBounds = new Rect(0,0,bmspriteMogB.getWidth(),bmspriteMogB.getHeight());
		
		spriteMogL = new Point (-1,-1);
		bmspriteMogL = BitmapFactory.decodeResource(getResources(),R.drawable.mogleft);
		bmspriteMogLBounds = new Rect(0,0,bmspriteMogL.getWidth(),bmspriteMogL.getHeight());


			
		sprite2 = new Point (-1,-1);
		bm2L = BitmapFactory.decodeResource(getResources(),R.drawable.girlleft);
		sprite2Bounds = new Rect (0,0,bm1.getWidth(),bm1.getHeight());
		
		spriteGirlF = new Point (-1,-1);
		bmspriteGirlF = BitmapFactory.decodeResource(getResources(),R.drawable.girlfront);
		bmspriteGirlFBounds = new Rect(0,0,bmspriteGirlF.getWidth(),bmspriteGirlF.getHeight());
		
		spriteGirlB = new Point (-1,-1);
		bmspriteGirlB = BitmapFactory.decodeResource(getResources(),R.drawable.girlback);
		bmspriteGirlBBounds = new Rect(0,0,bmspriteGirlB.getWidth(),bmspriteGirlB.getHeight());
		
		spriteGirlR = new Point (-1,-1);
		bmspriteGirlR = BitmapFactory.decodeResource(getResources(),R.drawable.girlright);
		bmspriteGirlRBounds = new Rect(0,0,bmspriteGirlR.getWidth(),bmspriteGirlR.getHeight());

		
		
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
        if (spriteMogF.x >=0)
        {
        	canvas.drawBitmap(bmspriteMogF, spriteMogF.x, spriteMogF.y, null);
        }
        if (spriteMogB.x >=0)
        {
        	canvas.drawBitmap(bmspriteMogB, spriteMogB.x, spriteMogB.y, null);
        }
        if (spriteMogL.x >=0)
        {
        	canvas.drawBitmap(bmspriteMogL, spriteMogL.x, spriteMogL.y, null);
        }
        
        
        if (sprite2.x >= 0)
        {
        	canvas.drawBitmap(bm2L, sprite2.x, sprite2.y, null);
        }
        if (spriteGirlF.x >=0)
        {
        	canvas.drawBitmap(bmspriteGirlF, spriteGirlF.x, spriteGirlF.y, null);
        }
        if (spriteGirlB.x >=0)
        {
        	canvas.drawBitmap(bmspriteGirlB, spriteGirlB.x, spriteGirlB.y, null);
        }
        if (spriteGirlR.x >=0)
        {
        	canvas.drawBitmap(bmspriteGirlR, spriteGirlR.x, spriteGirlR.y, null);
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
	synchronized public void setSpriteMogF(Point p)
	{
		spriteMogF = p;
	}
	synchronized public void setSpriteMogB(Point p)
	{
		spriteMogB = p;
	}
	synchronized public void setSpriteMogL(Point p)
	{
		spriteMogL = p;
	}



	synchronized public void setSprite3(Point p) 
	{
        sprite3 = p;
	}

synchronized public Point getSprite3() 
	 {
	       return sprite3;
	 }

	synchronized public void setSpriteGirlF(Point p)
	{
		spriteGirlF = p;
	}
	
	synchronized public void setSpriteGirlB(Point p)
	{
		spriteGirlB = p;
	}
	synchronized public void setSpriteGirlR(Point p)
	{
		spriteGirlR = p;
	}


}
