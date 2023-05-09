package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        if(checkPermission() == false){
            requestPermission();
            return;
        }

//        Button Screen2Button = (Button) findViewById(R.id.screen2button);
//
//        Screen2Button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                startActivity(new Intent(Screen2.this, Screen3.class));
//            }
//        });

        /*Toast.makeText(this, "screen2", Toast.LENGTH_SHORT).show();*/


    }

    //Permissions
    boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(Screen2.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            return false;
        }
    }

    void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(Screen2.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(Screen2.this,"READ PERMISSION IS REQUIRED,PLEASE ALLOW FROM SETTTINGS",Toast.LENGTH_SHORT).show();
        }else
            ActivityCompat.requestPermissions(Screen2.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
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
            startActivity(new Intent(Screen2.this, ViewFlipperScreen.class));

            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(Screen2.this, Email_calender_screen.class));
            return true;
        }


        if (id == R.id.GuitarImages) {
            startActivity(new Intent(Screen2.this, ListViewScreen.class));
            return true;
        }

        if (id == R.id.CameraMenu) {
            startActivity(new Intent(Screen2.this, CameraScreen.class));
            return true;
        }

        if (id == R.id.Home) {
            startActivity(new Intent(Screen2.this, Screen2.class));
            return true;
        }

        if (id == R.id.YourMusicPlayer) {
            startActivity(new Intent(Screen2.this, MusicActivity.class));
            return true;
        }

        if (id == R.id.YourReminder) {
            startActivity(new Intent(Screen2.this, MainActivityAlarm.class));
            return true;
        }

        if (id == R.id.YourPracticeLocation) {
            startActivity(new Intent(Screen2.this, DummyPracticeLocation.class));
            return true;
        }
        if (id == R.id.YourMetronome) {
            startActivity(new Intent(Screen2.this, Metronome1.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}