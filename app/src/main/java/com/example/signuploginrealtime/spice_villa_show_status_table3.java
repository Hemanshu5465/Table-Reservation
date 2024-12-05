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

public class spice_villa_show_status_table3 extends AppCompatActivity {

    RecyclerView
            spice_villa_recyclerView3;
    ArrayList<spice_villa_customer3>
            spice_villa_list3;
    DatabaseReference
            spice_villa_databaseReference3;
    spice_villa_Myadapter3
            spice_villa_adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice_villa_show_status_table3);

        Toolbar
                toolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spice_villa_recyclerView3 =
                findViewById(R.id.spice_villa_recyclerview3);
        spice_villa_databaseReference3 =
                FirebaseDatabase.getInstance().getReference("spice_villa_table3");
        spice_villa_list3 =
                new ArrayList<>();
        spice_villa_recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        spice_villa_adapter3 =
                new spice_villa_Myadapter3(this, spice_villa_list3);
        spice_villa_recyclerView3.setAdapter(spice_villa_adapter3);
        spice_villa_databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    spice_villa_customer3
                            spice_villa_cust3 =
                            dataSnapshot.getValue(spice_villa_customer3.class);
                    spice_villa_list3.add(spice_villa_cust3);
                }
                spice_villa_adapter3.notifyDataSetChanged();
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
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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
            Intent
                    intent =
                    new Intent(getApplicationContext(), feedback.class);
            startActivity(intent);

        }
        return true;
    }
}