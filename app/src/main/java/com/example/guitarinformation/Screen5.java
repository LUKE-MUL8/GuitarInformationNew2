package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Screen5 extends AppCompatActivity {

    private Button button_screen5_to_screen6;
    private RadioGroup radioChoiceGroup;
    private RadioButton choiceSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen5);


        radioChoiceGroup = findViewById(R.id.radioChoiceGroup);
        button_screen5_to_screen6 = findViewById(R.id.button_screen5_to_screen6);

        RadioButton BeginnerRadio, IntermediateRadio, ExperiencedRadio;

        BeginnerRadio = (RadioButton) findViewById(R.id.BeginnerRadio);
        IntermediateRadio = (RadioButton) findViewById(R.id.IntermediateRadio);
        ExperiencedRadio = (RadioButton) findViewById(R.id.ExperiencedRadio);

        button_screen5_to_screen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioChoiceGroup.getCheckedRadioButtonId();
                choiceSelected = findViewById(selectedId);
                Toast.makeText(Screen5.this, choiceSelected.getText(), Toast.LENGTH_SHORT).show();

                if (BeginnerRadio.isChecked()) {
                    Log.d("BEGINNER", "BEGINNER");
                    startActivity(new Intent(Screen5.this, ForBeginners.class));

                } else if (IntermediateRadio.isChecked()){
                    Log.d("INTERMEDIATE", "Intermediate");
                    startActivity(new Intent(Screen5.this, ForIntermediate.class));

                }
                else {
                    Log.d("EXPERIENCED","EXPERIENCED");
                    startActivity(new Intent(Screen5.this, ForExperienced.class));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ChordsMenu) {
            startActivity(new Intent(Screen5.this, ViewFlipperScreen.class));

            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(Screen5.this, CameraScreen.class));
            return true;
        }


        if (id == R.id.GuitarImages) {
            startActivity(new Intent(Screen5.this, CameraScreen.class));
            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(Screen5.this, CameraScreen.class));
            return true;
        }

        if (id == R.id.Home) {
            startActivity(new Intent(Screen5.this, Screen2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}