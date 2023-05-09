package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                counter = counter+5;
                progressBar.setProgress(counter);

                if(counter >= 100) {
                    t.cancel();
                    Intent i = new Intent(MainActivity.this,Screen2.class);
                    startActivity(i);
                 //   overridePendingTransition(R.transition.slide_in_right,R.transition.slide_out_left);// transition

                }

            }
        };
        t.schedule(tt,0,100);
    }
}