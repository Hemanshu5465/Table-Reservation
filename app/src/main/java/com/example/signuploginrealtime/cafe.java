package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class cafe extends AppCompatActivity {

    CardView cafe1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cafe1 = findViewById(R.id.cafe1);

        cafe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent
                        i1 = new Intent(getApplicationContext(),amrutras.class);
                startActivity(i1);
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
        int
                id =
                item.getItemId();
        if (id == R.id.logout) {
            Intent
                    intent =
                    new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.New) {
            Intent intent = new Intent(getApplicationContext(), upcoming_resto.class);
            startActivity(intent);
        }
        if (id == R.id.settings) {
            Intent
                    intent =
                    new Intent(getApplicationContext(), settings.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.feedback) {
            Intent
                    intent =
                    new Intent(getApplicationContext(), feedback.class);
            startActivity(intent);

        }
        return true;
    }
}