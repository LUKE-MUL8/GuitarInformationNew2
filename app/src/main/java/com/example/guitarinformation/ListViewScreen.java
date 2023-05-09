package com.example.guitarinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewScreen extends AppCompatActivity {

    private ArrayList<String> names;
    private ArrayList<Integer> images;

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        list = findViewById(R.id.id_list);

        names = new ArrayList<>();
        names.add("Image 1");
        names.add("Image 2");
        names.add("Image 3");

        images = new ArrayList<>();
        images.add(R.drawable.stratocaster);
        images.add(R.drawable.telecaster);
        images.add(R.drawable.jaguar);


        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

    }
        public class MyAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                return images.size();  //added this
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                view = getLayoutInflater().inflate(R.layout.my_card, viewGroup, false);
                ImageView myImageView = view.findViewById(R.id.imageView);
                TextView myTextView = view.findViewById(R.id.textView);

                myImageView.setImageResource(images.get(i));
                myTextView.setText(names.get(i));

                return view;
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
            startActivity(new Intent(ListViewScreen.this, ViewFlipperScreen.class));

            return true;
        }

        if (id == R.id.ContactMenu) {
            startActivity(new Intent(ListViewScreen.this, Email_calender_screen.class));
            return true;
        }


        if (id == R.id.GuitarImages) {
            startActivity(new Intent(ListViewScreen.this, ListViewScreen.class));
            return true;
        }


        if (id == R.id.Home) {
            startActivity(new Intent(ListViewScreen.this, Screen2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
