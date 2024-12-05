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

public class amiras_book_table_table8 extends AppCompatActivity {

    EditText
            amiras_booknm8;
    EditText amiras_bookdy8;
    EditText amiras_booktm8;
    EditText amiras_bookphn8;
    Button
            amiras_tbbook8;
    DatabaseReference
            amiras_databaseReference8;

    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiras_book_table_table8);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        amiras_booknm8 = findViewById(R.id.amiras_bookname8);
        amiras_bookdy8 = findViewById(R.id.amiras_bookday8);
        amiras_booktm8=findViewById(R.id.amiras_booktime8);
        amiras_bookphn8=findViewById(R.id.amiras_bookphone8);
        amiras_tbbook8 = findViewById(R.id.amiras_bookbtn8);


        amiras_bookdy8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(amiras_book_table_table8.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            amiras_bookdy8.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });

        amiras_booktm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(amiras_book_table_table8.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        amiras_booktm8.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });
        amiras_databaseReference8 = FirebaseDatabase.getInstance().getReference().child("amiras_table8");
        amiras_tbbook8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((amiras_booknm8.getText().toString()))) {
                    amiras_booknm8.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_bookdy8.getText().toString()))) {
                    amiras_bookdy8.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_booktm8.getText().toString()))) {
                    amiras_booktm8.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_bookphn8.getText().toString()))) {
                    amiras_bookphn8.setError("This is Required Filled");
                    return;
                }else if (amiras_bookphn8.getText().toString().length()!=10) {
                    amiras_bookphn8.setError("please enter proper number ");
                    return;
                }
                Intent intent = new Intent(getApplicationContext() , amiras_show_book_table8.class);
                startActivity(intent);
                insertstudentdata();
                finish();

            }
        });
    }

//    private void insertstudentdata() {
//
//        String amiras_bname8 = amiras_booknm8.getText().toString();
//        String amiras_bday8= amiras_bookdy8.getText().toString();
//        String amiras_btime8= amiras_booktm8.getText().toString();
//        String amiras_bphone8=amiras_bookphn8.getText().toString();
//        amiras_customer8 amiras_custo8=new amiras_customer8(amiras_bname8,amiras_bday8,amiras_btime8,amiras_bphone8);
//        amiras_databaseReference8.push().setValue(amiras_custo8);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String amiras_bname8 = amiras_booknm8.getText().toString();
        String amiras_bday8 = amiras_bookdy8.getText().toString();
        String amiras_btime8 = amiras_booktm8.getText().toString();
        String amiras_bphone8 = amiras_bookphn8.getText().toString();

        // Check if a booking already exists for the same date and time
        amiras_databaseReference8.orderByChild("amiras_bday8").equalTo(amiras_bday8).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    amiras_customer8 existingBooking = snapshot.getValue(amiras_customer8.class);
                    if (existingBooking != null && existingBooking.getAmiras_btime8().equals(amiras_btime8)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    amiras_customer8 amiras_custo8 = new amiras_customer8(amiras_bname8, amiras_bday8, amiras_btime8, amiras_bphone8);
                    amiras_databaseReference8.push().setValue(amiras_custo8);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), amiras_show_book_table8.class);
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