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

public class pavillion_show_status_table4 extends AppCompatActivity {

    RecyclerView
            pavillion_recyclerView4;
    ArrayList<pavillion_customer4>
            pavillion_list4;
    DatabaseReference
            pavillion_databaseReference4;
    pavillion_Myadapter4 pavillion_adapter4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavillion_show_status_table4);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pavillion_recyclerView4=findViewById(R.id.pavillion_recyclerview4);
        pavillion_databaseReference4= FirebaseDatabase.getInstance().getReference("pavillion_table4");
        pavillion_list4=new ArrayList<>();
        pavillion_recyclerView4.setLayoutManager(new LinearLayoutManager(this));
        pavillion_adapter4=new pavillion_Myadapter4(this,pavillion_list4);
        pavillion_recyclerView4.setAdapter(pavillion_adapter4);
        pavillion_databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    pavillion_customer4 pavillion_cust4 = dataSnapshot.getValue(pavillion_customer4.class);
                    pavillion_list4.add(pavillion_cust4);
                }
                pavillion_adapter4.notifyDataSetChanged();
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