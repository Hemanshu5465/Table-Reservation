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

public class amiras_book_table_table3 extends AppCompatActivity {


    EditText
            amiras_booknm3;
    EditText amiras_bookdy3;
    EditText amiras_booktm3;
    EditText amiras_bookphn3;
    Button
            amiras_tbbook3;
    DatabaseReference
            amiras_databaseReference3;

    DatePickerDialog picker;

    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiras_book_table_table3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        amiras_booknm3 = findViewById(R.id.amiras_bookname3);
        amiras_bookdy3 = findViewById(R.id.amiras_bookday3);
        amiras_booktm3=findViewById(R.id.amiras_booktime3);
        amiras_bookphn3=findViewById(R.id.amiras_bookphone3);
        amiras_tbbook3 = findViewById(R.id.amiras_bookbtn3);

        amiras_bookdy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar
                        calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(amiras_book_table_table3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
                        amiras_bookdy3.setText(dayofMonth + "/" +(month + 1) + "/" + year);
                    }
                } ,year , month ,day);
                picker.show();
            }
        });

        amiras_bookdy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(amiras_book_table_table3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            amiras_bookdy3.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });

        amiras_databaseReference3 = FirebaseDatabase.getInstance().getReference().child("amiras_table3");
        amiras_tbbook3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((amiras_booknm3.getText().toString()))) {
                    amiras_booknm3.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_bookdy3.getText().toString()))) {
                    amiras_bookdy3.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_booktm3.getText().toString()))) {
                    amiras_booktm3.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_bookphn3.getText().toString()))) {
                    amiras_bookphn3.setError("This is Required Filled");
                    return;
                }else if (amiras_bookphn3.getText().toString().length()!=10) {
                    amiras_bookphn3.setError("please enter proper number ");
                    return;
                }
                Intent intent = new Intent(getApplicationContext() , amiras_show_book_table3.class);
                startActivity(intent);
                insertstudentdata();
                finish();

            }
        });
    }

//    private void insertstudentdata() {
//
//        String amiras_bname3 = amiras_booknm3.getText().toString();
//        String amiras_bday3= amiras_bookdy3.getText().toString();
//        String amiras_btime3= amiras_booktm3.getText().toString();
//        String amiras_bphone3=amiras_bookphn3.getText().toString();
//        amiras_customer3 amiras_custo3=new amiras_customer3(amiras_bname3,amiras_bday3,amiras_btime3,amiras_bphone3);
//        amiras_databaseReference3.push().setValue(amiras_custo3);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String amiras_bname3 = amiras_booknm3.getText().toString();
        String amiras_bday3 = amiras_bookdy3.getText().toString();
        String amiras_btime3 = amiras_booktm3.getText().toString();
        String amiras_bphone3 = amiras_bookphn3.getText().toString();

        // Check if a booking already exists for the same date and time
        amiras_databaseReference3.orderByChild("amiras_bday3").equalTo(amiras_bday3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    amiras_customer3 existingBooking = snapshot.getValue(amiras_customer3.class);
                    if (existingBooking != null && existingBooking.getAmiras_btime3().equals(amiras_btime3)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    amiras_customer3 amiras_custo3 = new amiras_customer3(amiras_bname3, amiras_bday3, amiras_btime3, amiras_bphone3);
                    amiras_databaseReference3.push().setValue(amiras_custo3);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), amiras_show_book_table3.class);
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