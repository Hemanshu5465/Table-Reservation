package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class home extends AppCompatActivity {

    String fruitlist[] = {"Navjivan", "Amiras", "Pavillion ", "Spice Villa", "Amrutras",};
    int fruitimages[] = {R.drawable.f, R.drawable.s, R.drawable.t, R.drawable.fr, R.drawable.fif,};
    String fruitnum[] = {"Book Now", "Book Now", "Book Now", "Book Now", "Book Now",};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.customlistview);

        custombaseadapter custmadpter = new custombaseadapter(getApplicationContext(), fruitlist, fruitimages, fruitnum);
        listView.setAdapter(custmadpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent
                            i1 =
                            new Intent(getApplicationContext(), navjivan.class);
                    startActivity(i1);
                }
                if (i == 1) {
                    Intent
                            i1 =
                            new Intent(getApplicationContext(), amiras.class);
                    startActivity(i1);


                }
                if (i == 2) {
                    Intent i1 = new Intent(getApplicationContext(), pavillion.class);
                    startActivity(i1);


                }
                if (i == 3) {
                    Intent i1 = new Intent(getApplicationContext(), spice_villa.class);
                    startActivity(i1);


                }
                if (i == 4) {
                    Intent i1 = new Intent(getApplicationContext(), amrutras.class);
                    startActivity(i1);


                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.New) {
            Toast.makeText(this, "linked", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.settings) {
            Intent intent = new Intent(getApplicationContext(), settings.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.feedback) {
            Intent intent = new Intent(getApplicationContext(), feedback.class);
            startActivity(intent);
        }

        return true;
    }

}