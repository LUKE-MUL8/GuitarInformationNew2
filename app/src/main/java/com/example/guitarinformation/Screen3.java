package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Screen3 extends AppCompatActivity {
    private EditText etx;
    private Button btu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        etx = findViewById(R.id.etx);
        btu = findViewById(R.id.btu);

        btu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Screen3.this, Screen4.class);
                String myText = etx.getText().toString();
                i.putExtra("TextToSend", myText);
                startActivity(i);
            }
    });
}
}