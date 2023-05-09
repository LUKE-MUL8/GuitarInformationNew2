package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
public class ViewFlipperScreen extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Button btu_next, btu_prev;
    int count = 1;
    private TextView textView_guitar_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);



        btu_next = findViewById(R.id.btu_next);
        btu_prev = findViewById(R.id.btu_prev);
        textView_guitar_type = findViewById(R.id.textView_guitar_type);
        MediaPlayer G = MediaPlayer.create(ViewFlipperScreen.this,R.raw.g_major);
        MediaPlayer A = MediaPlayer.create(ViewFlipperScreen.this,R.raw.a_major);
        MediaPlayer C = MediaPlayer.create(ViewFlipperScreen.this,R.raw.c_major);
        MediaPlayer D = MediaPlayer.create(ViewFlipperScreen.this,R.raw.d_major);


//        if (count == 1) {
//            textView_guitar_type.setText("Fender Jaguar");
//        }
//
//        if (count == 2) {
//            textView_guitar_type.setText("Les Paul");
//
//        }
//
//        if (count == 3) {
//            textView_guitar_type.setText("Fender Stratocaster");
//        }
//
//        if (count == 4) {
//            textView_guitar_type.setText("Fender Stratocaster");
//        }


        viewFlipper = findViewById(R.id.view_flipper);

        btu_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(ViewFlipperScreen.this,R.anim.slide_in_left);
                viewFlipper.setOutAnimation(ViewFlipperScreen.this,R.anim.slide_out_right);
                viewFlipper.showNext();
                count++;
                Log.d("Count", "count at the start " + count);

                if (count == 5) {
                    Toast.makeText(ViewFlipperScreen.this, "count is five", Toast.LENGTH_SHORT).show();
                    count = 1;
                    Log.d("Count was changed", " " + count);

                }

                if (count == 0) {
                    Toast.makeText(ViewFlipperScreen.this, "count is zero", Toast.LENGTH_SHORT).show();
                    count = 4;
                    Log.d("Count was changed", " " + count);
                }

                if (count == 1) {
                    textView_guitar_type.setText("A Chord");
                    A.start();
                }

                if (count == 2) {
                    textView_guitar_type.setText("G Chord");
                    G.start();
                }

                if (count == 3) {
                    textView_guitar_type.setText("D Chord");
                    D.start();
                }

                if (count == 4) {
                    textView_guitar_type.setText("C Chord");
                    C.start();
                }

                Log.d("Count", "count at the end " + count);




            }
        });



        btu_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setInAnimation(ViewFlipperScreen.this,R.anim.slide_in_right);
                viewFlipper.setOutAnimation(ViewFlipperScreen.this,R.anim.slide_out_left);
                viewFlipper.showPrevious();
                count--;
                Log.d("Count", "count at the start " + count);

                if (count == 5) {
                    Toast.makeText(ViewFlipperScreen.this, "count is five", Toast.LENGTH_SHORT).show();
                    count = 1;
                    Log.d("Count was changed", " " + count);

                }

                if (count == 0) {
                    Toast.makeText(ViewFlipperScreen.this, "count is zero", Toast.LENGTH_SHORT).show();
                    count = 4;
                    Log.d("Count was changed", " " + count);
                }

                if (count == 1) {
                    textView_guitar_type.setText("A Chord");
                    A.start();
                }

                if (count == 2) {
                    textView_guitar_type.setText("G Chord");
                    G.start();
                }

                if (count == 3) {
                    textView_guitar_type.setText("D Chord");
                    D.start();
                }

                if (count == 4) {
                    textView_guitar_type.setText("C Chord");
                    C.start();
                }

                Log.d("Count", "count at the end " + count);


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
            startActivity(new Intent(ViewFlipperScreen.this, ViewFlipperScreen.class));

            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(ViewFlipperScreen.this, Email_calender_screen.class));
            return true;
        }


        if (id == R.id.GuitarImages) {
            startActivity(new Intent(ViewFlipperScreen.this, ListViewScreen.class));
            return true;
        }

        if (id == R.id.CameraMenu) {
            startActivity(new Intent(ViewFlipperScreen.this, CameraScreen.class));
            return true;
        }

        if (id == R.id.Home) {
            startActivity(new Intent(ViewFlipperScreen.this, Screen2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}








