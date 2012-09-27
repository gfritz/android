package com.example.taskmanager;

//import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
        
        Button btnNewTask = (Button) findViewById(R.id.createTask);
        final EditText taskName = (EditText) findViewById(R.id.taskTitle);
        
        
        OnClickListener listener = new OnClickListener(){
        	public void onClick(View v){
        		FragmentManager fragmentManager = getFragmentManager();
        		FragmentTransaction ft = fragmentManager.beginTransaction();
        		//constructor for the task object TaskListFragment task = new TaskListFragment();
        		Stopwatch sw = new Stopwatch();
        		ft.add(R.id.fragment_container, sw);
        		ft.commit();
        		
        	}
        };
        
        btnNewTask.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void createTask (View view) {
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		//constructor for the task object TaskListFragment task = new TaskListFragment();
		Stopwatch sw = new Stopwatch();
		ft.add(R.id.fragment_container, sw);
		ft.commit();
    }
}
