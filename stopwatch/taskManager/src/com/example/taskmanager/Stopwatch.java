package com.example.taskmanager;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

public class Stopwatch extends Fragment {
	
	private TextView tempTextView; //Temporary TextView
	private Button tempBtn; //Temporary Button
	private Handler mHandler = new Handler();
	private long startTime;
	private long elapsedTime;
	private final int REFRESH_RATE = 100;
	private String hours,minutes,seconds,milliseconds;
	private long secs,mins,hrs,msecs;
	private boolean stopped = false;
	
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_stopwatch, container, false);
    }
    
    public void startClick (View view){
    	showStopButton();
    	if(stopped){
    		startTime = System.currentTimeMillis() - elapsedTime;
    	}
    	else{
    		startTime = System.currentTimeMillis();
    	}
    	mHandler.removeCallbacks(startTimer);
        mHandler.postDelayed(startTimer, 0);
    	
    }

    public void stopClick (View view){
    	hideStopButton();
    	mHandler.removeCallbacks(startTimer);
    	stopped = true;
    }

    public void resetClick (View view){
    	stopped = false;
    	((TextView)findViewById(R.id.timer)).setText("00:00:00");
    	((TextView)findViewById(R.id.timerMs)).setText(".0");
    }
    
    private void showStopButton(){
        ((Button)findViewById(R.id.startButton)).setVisibility(View.GONE);
        ((Button)findViewById(R.id.resetButton)).setVisibility(View.GONE);
        ((Button)findViewById(R.id.stopButton)).setVisibility(View.VISIBLE);
    }

    private void hideStopButton(){
        ((Button)findViewById(R.id.startButton)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.resetButton)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.stopButton)).setVisibility(View.GONE);
    }
    
    private void updateTimer (float time){
		secs = (long)(time/1000);
		mins = (long)((time/1000)/60);
		hrs = (long)(((time/1000)/60)/60);

		/* Convert the seconds to String
		 * and format to ensure it has
		 * a leading zero when required
		 */
		secs = secs % 60;
		seconds=String.valueOf(secs);
    	if(secs == 0){
    		seconds = "00";
    	}
    	if(secs <10 && secs > 0){
    		seconds = "0"+seconds;
    	}

		/* Convert the minutes to String and format the String */

    	mins = mins % 60;
		minutes=String.valueOf(mins);
    	if(mins == 0){
    		minutes = "00";
    	}
    	if(mins <10 && mins > 0){
    		minutes = "0"+minutes;
    	}

    	/* Convert the hours to String and format the String */

    	hours=String.valueOf(hrs);
    	if(hrs == 0){
    		hours = "00";
    	}
    	if(hrs <10 && hrs > 0){
    		hours = "0"+hours;
    	}

    	/* Although we are not using milliseconds on the timer in this example
    	 * I included the code in the event that you wanted to include it on your own
    	 */
    	milliseconds = String.valueOf((long)time);
    	if(milliseconds.length()==2){
    		milliseconds = "0"+milliseconds;
    	}
      	if(milliseconds.length()<=1){
    		milliseconds = "00";
    	}
		milliseconds = milliseconds.substring(milliseconds.length()-3, milliseconds.length()-2);

		/* Setting the timer text to the elapsed time */
		((TextView)findViewById(R.id.timer)).setText(hours + ":" + minutes + ":" + seconds);
		((TextView)findViewById(R.id.timerMs)).setText("." + milliseconds);
    }//end Update Timer
    
    private Runnable startTimer = new Runnable() {
    	public void run() {
    			elapsedTime = System.currentTimeMillis() - startTime;
    			updateTimer(elapsedTime);
    			mHandler.postDelayed(this,REFRESH_RATE);
    	}
    };
    
}//end class
