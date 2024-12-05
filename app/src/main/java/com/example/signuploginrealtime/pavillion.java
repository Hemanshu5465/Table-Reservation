package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class pavillion extends AppCompatActivity {

    ImageView pavillion_table1 , pavillion_table2 , pavillion_table3 , pavillion_table4 , pavillion_table5 , pavillion_table6 , pavillion_table7 , pavillion_table8 , pavillion_table9 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavillion);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pavillion_table1=findViewById(R.id.pavillion_2seat_table1);
        pavillion_table2=findViewById(R.id.pavillion_2seat_table2);
        pavillion_table3=findViewById(R.id.pavillion_2seat_table3);

        pavillion_table4=findViewById(R.id.pavillion_4seat_table1);
        pavillion_table5=findViewById(R.id.pavillion_4seat_table2);
        pavillion_table6=findViewById(R.id.pavillion_4seat_table3);

        pavillion_table7=findViewById(R.id.pavillion_6seat_table1);
        pavillion_table8=findViewById(R.id.pavillion_6seat_table2);
        pavillion_table9=findViewById(R.id.pavillion_6seat_table3);


        pavillion_table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book.class);
                startActivity(intent);
            }
        });
        pavillion_table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table2.class);
                startActivity(intent);
            }
        });
        pavillion_table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table3.class);
                startActivity(intent);
            }
        });
        pavillion_table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table4.class);
                startActivity(intent);
            }
        });
        pavillion_table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table5.class);
                startActivity(intent);
            }
        });
        pavillion_table6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table6.class);
                startActivity(intent);
            }
        });
        pavillion_table7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table7.class);
                startActivity(intent);
            }
        });
        pavillion_table8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table8.class);
                startActivity(intent);
            }
        });
        pavillion_table9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table9.class);
                startActivity(intent);
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