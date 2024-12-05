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

public class pavillion_show_status_table5 extends AppCompatActivity {


    RecyclerView
            pavillion_recyclerView5;
    ArrayList<pavillion_customer5>
            pavillion_list5;
    DatabaseReference
            pavillion_databaseReference5;
    pavillion_Myadapter5 pavillion_adapter5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavillion_show_status_table5);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pavillion_recyclerView5=findViewById(R.id.pavillion_recyclerview5);
        pavillion_databaseReference5= FirebaseDatabase.getInstance().getReference("pavillion_table5");
        pavillion_list5=new ArrayList<>();
        pavillion_recyclerView5.setLayoutManager(new LinearLayoutManager(this));
        pavillion_adapter5=new pavillion_Myadapter5(this,pavillion_list5);
        pavillion_recyclerView5.setAdapter(pavillion_adapter5);
        pavillion_databaseReference5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    pavillion_customer5 pavillion_cust5 = dataSnapshot.getValue(pavillion_customer5.class);
                    pavillion_list5.add(pavillion_cust5);
                }
                pavillion_adapter5.notifyDataSetChanged();
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