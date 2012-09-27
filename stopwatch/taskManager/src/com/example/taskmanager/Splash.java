package com.example.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Splash extends Activity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash);
	}
	
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
    public void toTaskManager(View v){
    	Intent i = new Intent(Splash.this, MainActivity.class);
    	startActivity(i);
    }

}
