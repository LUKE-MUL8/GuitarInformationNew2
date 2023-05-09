package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Email_calender_screen extends AppCompatActivity {

    private CardView card1;

    private CardView card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_calender_screen);

        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"tom@ait.ie"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Hello from my app");
                email.putExtra(Intent.EXTRA_TEXT, "Bla bla Bla bla  Bla bla  Bla bla  Bla bla ");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Send Mail Using :"));            }
        });

        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:2345612345");
                Intent msg = new Intent(Intent.ACTION_SENDTO, uri);
                msg.putExtra("sms_body", "The SMS text");
                startActivity(Intent.createChooser(msg, "Send sms Using :"));            }
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
            startActivity(new Intent(Email_calender_screen.this, ViewFlipperScreen.class));

            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(Email_calender_screen.this, Email_calender_screen.class));
            return true;
        }


        if (id == R.id.GuitarImages) {
            startActivity(new Intent(Email_calender_screen.this, ListViewScreen.class));
            return true;
        }

        if (id == R.id.CameraMenu) {
            startActivity(new Intent(Email_calender_screen.this, CameraScreen.class));
            return true;
        }


        if (id == R.id.Home) {
            startActivity(new Intent(Email_calender_screen.this, Screen2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}










