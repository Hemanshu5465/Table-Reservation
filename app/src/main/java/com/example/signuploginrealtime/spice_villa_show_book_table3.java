package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class spice_villa_show_book_table3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice_villa_show_book_table3);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button
                showtable3=findViewById(R.id.spice_villa_show3);
        Button booktable3=findViewById(R.id.spice_villa_book3);

        showtable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        sh=new Intent(getApplicationContext(), spice_villa_show_status_table3.class );
                startActivity(sh);
                finish();
            }
        });
        booktable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bk = new Intent(getApplicationContext(), spice_villa_book_table_table3.class);
                startActivity(bk);
                finish();
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