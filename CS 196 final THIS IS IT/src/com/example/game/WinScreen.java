package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WinScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Intent intent = getIntent();
		Bundle extras = getIntent().getExtras();
		int won = extras.getInt("won");
		
		setContentView(R.layout.winscreen);
		
		if (won==2)
		{
			ImageView imageView = (ImageView) findViewById(R.id.winimage);
			Bitmap win = BitmapFactory.decodeResource(getResources(),R.drawable.player2win);
			imageView.setImageBitmap(win);
		}
	}
	
	public void mainActivity (View view)
	{
		Intent intent = new Intent (this,MainGame.class);
		startActivity (intent);
	}

}
