package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class amiras_show_status_table9 extends AppCompatActivity {


    RecyclerView
            amiras_recyclerView9;
    ArrayList<amiras_customer9>
            amiras_list9;
    DatabaseReference
            amiras_databaseReference9;
    amiras_Myadapter9 amiras_adapter9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiras_show_status_table9);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amiras_recyclerView9=findViewById(R.id.amiras_recyclerview9);
        amiras_databaseReference9= FirebaseDatabase.getInstance().getReference("amiras_table9");
        amiras_list9=new ArrayList<>();
        amiras_recyclerView9.setLayoutManager(new LinearLayoutManager(this));
        amiras_adapter9=new amiras_Myadapter9(this,amiras_list9);
        amiras_recyclerView9.setAdapter(amiras_adapter9);
        amiras_databaseReference9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    amiras_customer9 amiras_cust9 = dataSnapshot.getValue(amiras_customer9.class);
                    amiras_list9.add(amiras_cust9);
                }
                amiras_adapter9.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
            Intent
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
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