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

public class amrutras_show_status_table4 extends AppCompatActivity {

    RecyclerView
            amrutras_recyclerView4;
    ArrayList<amrutras_customer4>
            amrutras_list4;
    DatabaseReference
            amrutras_databaseReference4;
    amrutras_Myadapter4 amrutras_adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amrutras_show_status_table4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amrutras_recyclerView4=findViewById(R.id.amrutras_recyclerview4);
        amrutras_databaseReference4= FirebaseDatabase.getInstance().getReference("amrutras_table4");
        amrutras_list4=new ArrayList<>();
        amrutras_recyclerView4.setLayoutManager(new LinearLayoutManager(this));
        amrutras_adapter4=new amrutras_Myadapter4(this,amrutras_list4);
        amrutras_recyclerView4.setAdapter(amrutras_adapter4);
        amrutras_databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    amrutras_customer4 amrutras_cust4 = dataSnapshot.getValue(amrutras_customer4.class);
                    amrutras_list4.add(amrutras_cust4);
                }
                amrutras_adapter4.notifyDataSetChanged();
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