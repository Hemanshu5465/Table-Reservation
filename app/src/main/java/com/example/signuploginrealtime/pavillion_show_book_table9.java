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

public class pavillion_show_book_table9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavillion_show_book_table9);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button
                showtable9=findViewById(R.id.pavillion_show9);
        Button booktable9=findViewById(R.id.pavillion_book9);

        showtable9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        sh=new Intent(getApplicationContext(), pavillion_show_status_table9.class );
                startActivity(sh);
                finish();
            }
        });
        booktable9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bk = new Intent(getApplicationContext(), pavillion_book_table_table9.class);
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