package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class CameraScreen extends AppCompatActivity {

    private Button btu_store;
    private EditText etxCameraScreen;
    private SharedPreferences sp_database;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //String name = sp_database.getString("key_saved_text", null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_screen);

        etxCameraScreen = findViewById(R.id.etxCameraScreen);
        btu_store = findViewById(R.id.btu_store);

        imageView = findViewById(R.id.imageView4);
        button = findViewById(R.id.button);

        try {
            sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
            String name = sp_database.getString("key_saved_text", null);
            etxCameraScreen.setText(name);
        }
        catch  (NullPointerException e) {
            Toast.makeText(this, "Please edit the text", Toast.LENGTH_SHORT).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                }
            }
        });

        Button next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(CameraScreen.this, Screen5.class));
                sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                String name = sp_database.getString("key_saved_text", null);
                Toast.makeText(CameraScreen.this, name, Toast.LENGTH_SHORT).show();
                etxCameraScreen.setText(name);

            }
        });



        btu_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_database.edit();
                String txt = etxCameraScreen.getText().toString();
                editor.putString("key_saved_text", txt);
                editor.commit();
                String name = sp_database.getString("key_saved_text", null);
                Toast.makeText(CameraScreen.this, "Data saved", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);

        }
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
            startActivity(new Intent(CameraScreen.this, ViewFlipperScreen.class));

            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(CameraScreen.this, Email_calender_screen.class));
            return true;
        }


        if (id == R.id.GuitarImages) {
            startActivity(new Intent(CameraScreen.this, ListViewScreen.class));
            return true;
        }

        if (id == R.id.CameraMenu) {
            startActivity(new Intent(CameraScreen.this, CameraScreen.class));
            return true;
        }

        if (id == R.id.Home) {
            startActivity(new Intent(CameraScreen.this, Screen2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}









