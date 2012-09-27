package com.example.taskmanager;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    Button btnNewTask = (Button) findViewById(R.id.createTask);
    final EditText taskName = (EditText) findViewById(R.id.taskTitle);
    
    OnClickListener listener = new OnClickListener(){
    	public void onClick(View v){
    		FragmentManager fragmentManager = getFragmentManager();
    		// constructor for the task object TaskListFragment task = new TaskListFragment();
    	}
    };
    
    public void createTask (View view) {
    	
    }
}
