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
import android.widget.TextView;
import android.widget.Toast;

public class help_section extends AppCompatActivity {

    CardView que1,que2,que3,que4;
    TextView ans1,ans2,ans3,ans4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_section);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        que1=findViewById(R.id.que1);
        que2=findViewById(R.id.que2);
        que3=findViewById(R.id.que3);
        que4=findViewById(R.id.que4);
        ans1=findViewById(R.id.ans1);
        ans2=findViewById(R.id.ans2);
        ans3=findViewById(R.id.ans3);
        ans4=findViewById(R.id.ans4);
        que1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans1.setText("To make reservation first you need to show the status of the table that you want to book and after that you click" +
                        " on book table button and submit your information and then your table is successsfully booked for particular date and time.");
            }
        });
        que2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans2.setText("Yes,you can modify or cancel your reservation.To modify or cancel reservation you need to send the messege on 9773107784 and send the detail of your reservation then your reservation is updated or canceled but ite is do within 10 minute of booking");
            }
        });
        que3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans3.setText("Yes, you can make reservation for any event but once booking is confirm then you can't cancel booking.");
            }
        });
        que4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans4.setText("To contact restaurent you need to call on 973107784 it provide all the information that you want to ask. ");
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
            Toast.makeText(this, "linked", Toast.LENGTH_SHORT).show();
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