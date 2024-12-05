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
import android.widget.Toast;

public class home2 extends AppCompatActivity {

    CardView disc1,disc2,disc3,cat1,cat2,cat3,rec1,rec2,rec3,rec4,rec5,pop1,pop2,pop3,pop4,upcmng1,help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        disc1=findViewById(R.id.disc_card1);
        disc2=findViewById(R.id.disc_card2);
        disc3=findViewById(R.id.disc_card3);
        rec1=findViewById(R.id.rec1);
        rec2=findViewById(R.id.rec2);
        rec3=findViewById(R.id.rec3);
        rec4=findViewById(R.id.rec4);
        rec5=findViewById(R.id.rec5);
        pop1=findViewById(R.id.pop1);
        pop2=findViewById(R.id.pop2);
        pop3=findViewById(R.id.pop3);
        pop4=findViewById(R.id.pop4);
        upcmng1=findViewById(R.id.upcmng1);
//        help=findViewById(R.id.help);
        cat1 =findViewById(R.id.cat1);
        cat2=findViewById(R.id.cat2);
        cat3=findViewById(R.id.cat3);


        rec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),amiras.class);
                startActivity(i1);
            }
        });
        rec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),navjivan.class);
                startActivity(i2);
            }
        });
        rec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(getApplicationContext(),spice_villa.class);
                startActivity(i3);
            }
        });
        rec4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(getApplicationContext(),amrutras.class);
                startActivity(i4);
            }
        });
        rec5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5=new Intent(getApplicationContext(),pavillion.class);
                startActivity(i5);
            }
        });
        upcmng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6=new Intent(getApplicationContext() , upcoming_resto.class );
                startActivity(i6);
            }
        });
//        help.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i7=new Intent(getApplicationContext() , help_section.class );
//                startActivity(i7);
//            }});

        cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cat1 = new Intent(getApplicationContext(),fivestar.class);
                startActivity(cat1);
            }
        });
        cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cat2 = new Intent(getApplicationContext(),casual.class);
                startActivity(cat2);
            }
        });
        cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cat3 = new Intent(getApplicationContext(),cafe.class);
                startActivity(cat3);
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