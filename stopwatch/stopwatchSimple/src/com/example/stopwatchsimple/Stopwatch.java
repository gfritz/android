package com.example.stopwatchsimple;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Stopwatch extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_stopwatch, menu);
        return true;
    }
    
}
