package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen4 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        Button Screen4Button = (Button) findViewById(R.id.screen4toscreen5btu);

        Screen4Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Screen4.this, Screen5.class));
            }
        });


        tv = findViewById(R.id.tv);
        try {
            Bundle extras = getIntent().getExtras();
            String sentText = extras.getString("TextToSend");
            tv.setText("Hello " + sentText + " today you will learn about the guitar");
        } catch (RuntimeException e) {
            e.printStackTrace();

        }


    }
}