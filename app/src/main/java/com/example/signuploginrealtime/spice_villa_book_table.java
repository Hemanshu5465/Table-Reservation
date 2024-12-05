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

public class spice_villa_book_table extends AppCompatActivity {

    EditText
            spice_villa_booknm;
    EditText spice_villa_bookdy;
    EditText spice_villa_booktm;
    EditText spice_villa_bookphn;
    Button
            spice_villa_tbbook;
    DatabaseReference
            spice_villa_databaseReference;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice_villa_book_table);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        spice_villa_booknm = findViewById(R.id.spice_villa_bookname);
        spice_villa_bookdy = findViewById(R.id.spice_villa_bookday);
        spice_villa_booktm=findViewById(R.id.spice_villa_booktime);
        spice_villa_bookphn=findViewById(R.id.spice_villa_bookphone);
        spice_villa_tbbook = findViewById(R.id.spice_villa_bookbtn);

        spice_villa_bookdy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(spice_villa_book_table.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view

                            spice_villa_bookdy.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });

        spice_villa_booktm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(spice_villa_book_table.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        spice_villa_booktm.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });

        spice_villa_databaseReference = FirebaseDatabase.getInstance().getReference().child("spice_villa_table1");
        spice_villa_tbbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty((spice_villa_booknm.getText().toString()))) {
                    spice_villa_booknm.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((spice_villa_bookdy.getText().toString()))) {
                    spice_villa_bookdy.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((spice_villa_booktm.getText().toString()))) {
                    spice_villa_booktm.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((spice_villa_bookphn.getText().toString()))) {
                    spice_villa_bookphn.setError("This is Required Filled");
                    return;
                }else if (spice_villa_bookphn.getText().toString().length()!=10) {
                    spice_villa_bookphn.setError("please enter proper number ");
                    return;
                }
                Intent
                        intent = new Intent(getApplicationContext() , spice_villa_show_book.class);
                startActivity(intent);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//
//        String spice_villa_bname = spice_villa_booknm.getText().toString();
//        String spice_villa_bday= spice_villa_bookdy.getText().toString();
//        String spice_villa_btime= spice_villa_booktm.getText().toString();
//        String spice_villa_bphone= spice_villa_bookphn.getText().toString();
//        spice_villa_customer spice_villa_custo=new spice_villa_customer(spice_villa_bname,spice_villa_bday,spice_villa_btime,spice_villa_bphone);
//        spice_villa_databaseReference.push().setValue(spice_villa_custo);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String spice_villa_bname = spice_villa_booknm.getText().toString();
        String spice_villa_bday = spice_villa_bookdy.getText().toString();
        String spice_villa_btime = spice_villa_booktm.getText().toString();
        String spice_villa_bphone = spice_villa_bookphn.getText().toString();

        // Check if a booking already exists for the same date and time
        spice_villa_databaseReference.orderByChild("spice_villa_bday").equalTo(spice_villa_bday).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    spice_villa_customer existingBooking = snapshot.getValue(spice_villa_customer.class);
                    if (existingBooking != null && existingBooking.getSpice_villa_btime().equals(spice_villa_btime)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    spice_villa_customer spice_villa_custo = new spice_villa_customer(spice_villa_bname, spice_villa_bday, spice_villa_btime, spice_villa_bphone);
                    spice_villa_databaseReference.push().setValue(spice_villa_custo);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), spice_villa_show_book.class);
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