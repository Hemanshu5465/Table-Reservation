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

public class amrutras_show_status_table8 extends AppCompatActivity {

    RecyclerView
            amrutras_recyclerView8;
    ArrayList<amrutras_customer8>
            amrutras_list8;
    DatabaseReference
            amrutras_databaseReference8;
    amrutras_Myadapter8 amrutras_adapter8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amrutras_show_status_table8);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amrutras_recyclerView8=findViewById(R.id.amrutras_recyclerview8);
        amrutras_databaseReference8= FirebaseDatabase.getInstance().getReference("amrutras_table8");
        amrutras_list8=new ArrayList<>();
        amrutras_recyclerView8.setLayoutManager(new LinearLayoutManager(this));
        amrutras_adapter8=new amrutras_Myadapter8(this,amrutras_list8);
        amrutras_recyclerView8.setAdapter(amrutras_adapter8);
        amrutras_databaseReference8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    amrutras_customer8 amrutras_cust8 = dataSnapshot.getValue(amrutras_customer8.class);
                    amrutras_list8.add(amrutras_cust8);
                }
                amrutras_adapter8.notifyDataSetChanged();
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