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
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class upcoming_resto extends AppCompatActivity {

    private RecyclerView
            recyclerView;
    private SearchView searchView;
    ArrayList<itemadapter> arrayList=new ArrayList<>();
    ArrayList<itemadapter> searchlist;
    String[] fruitlist=new String[]{"The Garden ","WingMans pub","Haute Diner","Indian Accent","J.K Diner","Bomras","Bansari","Karavalli Dine","Raj family arestaurant"};
    String[] fruitnum=new String[]{"coming soon","coming soon","coming soon","coming soon","coming soon","coming soon","coming soon","coming soon","coming soon"};
    int[] imglist=new int[]{R.drawable.us,R.drawable.us,R.drawable.us,R.drawable.us,R.drawable.us,R.drawable.us,R.drawable.us,R.drawable.us,R.drawable.us};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_resto);

        Toolbar
                toolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =
                findViewById(R.id.recyclerview);
        searchView =
                findViewById(R.id.searchview);
        searchView.setIconified(false);
        searchView.clearFocus();

        for (int
             i =
             0; i < fruitlist.length; i++) {
            itemadapter
                    itemada =
                    new itemadapter();
            itemada.setFruitname(fruitlist[i]);
            itemada.setFruitnum(fruitnum[i]);
            itemada.setImg(imglist[i]);
            arrayList.add(itemada);
        }
        RecyclerView.LayoutManager
                layoutManager =
                new LinearLayoutManager(upcoming_resto.this);
        recyclerView.setLayoutManager(layoutManager);

        fruitadapter
                fruitada =
                new fruitadapter(upcoming_resto.this, arrayList);
        recyclerView.setAdapter(fruitada);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.length() > 0) {
                    for (int
                         i =
                         0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFruitname().toUpperCase().contains(s.toUpperCase())) {
                            itemadapter
                                    itemada =
                                    new itemadapter();
                            itemada.setFruitname(arrayList.get(i).getFruitname());
                            itemada.setFruitnum(arrayList.get(i).getFruitnum());
                            itemada.setImg(arrayList.get(i).getImg());
                            searchlist.add(itemada);

                        }
                    }
                    RecyclerView.LayoutManager
                            layoutManager =
                            new LinearLayoutManager(upcoming_resto.this);
                    recyclerView.setLayoutManager(layoutManager);

                    fruitadapter
                            fruitada =
                            new fruitadapter(upcoming_resto.this, searchlist);
                    recyclerView.setAdapter(fruitada);
                } else {
                    RecyclerView.LayoutManager
                            layoutManager =
                            new LinearLayoutManager(upcoming_resto.this);
                    recyclerView.setLayoutManager(layoutManager);

                    fruitadapter
                            fruitada =
                            new fruitadapter(upcoming_resto.this, arrayList);
                    recyclerView.setAdapter(fruitada);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchlist =
                        new ArrayList<>();


                if (s.length() > 0) {
                    for (int
                         i =
                         0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFruitname().toUpperCase().contains(s.toUpperCase())) {
                            itemadapter
                                    itemada =
                                    new itemadapter();
                            itemada.setFruitname(arrayList.get(i).getFruitname());
                            itemada.setFruitnum(arrayList.get(i).getFruitnum());
                            itemada.setImg(arrayList.get(i).getImg());
                            searchlist.add(itemada);


                        }
                    }
                    RecyclerView.LayoutManager
                            layoutManager =
                            new LinearLayoutManager(upcoming_resto.this);
                    recyclerView.setLayoutManager(layoutManager);

                    fruitadapter
                            fruitada =
                            new fruitadapter(upcoming_resto.this, searchlist);
                    recyclerView.setAdapter(fruitada);
                } else {
                    RecyclerView.LayoutManager
                            layoutManager =
                            new LinearLayoutManager(upcoming_resto.this);
                    recyclerView.setLayoutManager(layoutManager);

                    fruitadapter
                            fruitada =
                            new fruitadapter(upcoming_resto.this, arrayList);
                    recyclerView.setAdapter(fruitada);
                }
                return false;
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