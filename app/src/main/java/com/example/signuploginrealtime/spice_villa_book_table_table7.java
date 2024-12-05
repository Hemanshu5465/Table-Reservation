package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class spice_villa_book_table_table7 extends AppCompatActivity {

    EditText
            spice_villa_booknm7;
    EditText spice_villa_bookdy7;
    EditText spice_villa_booktm7;
    EditText spice_villa_bookphn7;
    Button
            spice_villa_tbbook7;
    DatabaseReference
            spice_villa_databaseReference7;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice_villa_book_table_table7);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        spice_villa_booknm7 = findViewById(R.id.spice_villa_bookname7);
        spice_villa_bookdy7 = findViewById(R.id.spice_villa_bookday7);
        spice_villa_booktm7=findViewById(R.id.spice_villa_booktime7);
        spice_villa_bookphn7=findViewById(R.id.spice_villa_bookphone7);
        spice_villa_tbbook7 = findViewById(R.id.spice_villa_bookbtn7);

        spice_villa_bookdy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(spice_villa_book_table_table7.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view

                            spice_villa_bookdy7.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });

        spice_villa_booktm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(spice_villa_book_table_table7.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        spice_villa_booktm7.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });



        spice_villa_databaseReference7 = FirebaseDatabase.getInstance().getReference().child("spice_villa_table7");
        spice_villa_tbbook7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty((spice_villa_booknm7.getText().toString()))) {
                    spice_villa_booknm7.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((spice_villa_bookdy7.getText().toString()))) {
                    spice_villa_bookdy7.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((spice_villa_booktm7.getText().toString()))) {
                    spice_villa_booktm7.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((spice_villa_bookphn7.getText().toString()))) {
                    spice_villa_bookphn7.setError("This is Required Filled");
                    return;
                }else if (spice_villa_bookphn7.getText().toString().length()!=10) {
                    spice_villa_bookphn7.setError("please enter proper number ");
                    return;
                }
                Intent
                        intent = new Intent(getApplicationContext() , spice_villa_show_book_table7.class);
                startActivity(intent);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//        String spice_villa_bname7 = spice_villa_booknm7.getText().toString();
//        String spice_villa_bday7= spice_villa_bookdy7.getText().toString();
//        String spice_villa_btime7= spice_villa_booktm7.getText().toString();
//        String spice_villa_bphone7= spice_villa_bookphn7.getText().toString();
//        spice_villa_customer7 spice_villa_custo7=new spice_villa_customer7(spice_villa_bname7,spice_villa_bday7,spice_villa_btime7,spice_villa_bphone7);
//        spice_villa_databaseReference7.push().setValue(spice_villa_custo7);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String spice_villa_bname7 = spice_villa_booknm7.getText().toString();
        String spice_villa_bday7 = spice_villa_bookdy7.getText().toString();
        String spice_villa_btime7 = spice_villa_booktm7.getText().toString();
        String spice_villa_bphone7 = spice_villa_bookphn7.getText().toString();

        // Check if a booking already exists for the same date and time
        spice_villa_databaseReference7.orderByChild("spice_villa_bday7").equalTo(spice_villa_bday7).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    spice_villa_customer7 existingBooking = snapshot.getValue(spice_villa_customer7.class);
                    if (existingBooking != null && existingBooking.getSpice_villa_btime7().equals(spice_villa_btime7)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    spice_villa_customer7 spice_villa_custo7 = new spice_villa_customer7(spice_villa_bname7, spice_villa_bday7, spice_villa_btime7, spice_villa_bphone7);
                    spice_villa_databaseReference7.push().setValue(spice_villa_custo7);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), spice_villa_show_book_table7.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
            Intent intent = new Intent(getApplicationContext(), feedback.class);
            startActivity(intent);

        }
        return true;
    }
}