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

public class navjivan extends AppCompatActivity {

    ImageView table1 , table2 , table3 , table4 , table5 , table6 , table7 ,table8 , table9 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navjivan);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        table1=findViewById(R.id.navjivan_2seat_table1);
        table2=findViewById(R.id.navjivan_2seat_table2);
        table3=findViewById(R.id.navjivan_2seat_table3);
        table4=findViewById(R.id.navjivan_4seat_table1);
        table5=findViewById(R.id.navjivan_4seat_table2);
        table6=findViewById(R.id.navjivan_4seat_table3);
        table7=findViewById(R.id.navjivan_6seat_table1);
        table8=findViewById(R.id.navjivan_6seat_table2);
        table9=findViewById(R.id.navjivan_6seat_table3);


        table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book.class);
                startActivity(intent);
            }
        });
        table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table2.class);
                startActivity(intent);
            }
        });

        table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table3.class);
                startActivity(intent);
            }
        });

        table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table4.class);
                startActivity(intent);
            }
        });

        table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table5.class);
                startActivity(intent);
            }
        });

        table6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table6.class);
                startActivity(intent);
            }
        });

        table7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table7.class);
                startActivity(intent);
            }
        });
        table8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table8.class);
                startActivity(intent);
            }
        });
        table9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table9.class);
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