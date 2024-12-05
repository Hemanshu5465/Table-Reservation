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

public class navjivan_book_table_table3 extends AppCompatActivity {


    EditText
            booknm3;
    EditText bookdy3;
    EditText booktm3;
    EditText bookphn3;
    Button
            tbbook3;
    DatabaseReference
            databaseReference3;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navjivan_book_table_table3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        booknm3 = findViewById(R.id.bookname3);
        bookdy3 = findViewById(R.id.bookday3);
        booktm3 =findViewById(R.id.booktime3);
        bookphn3 =findViewById(R.id.bookphone3);
        tbbook3 = findViewById(R.id.bookbtn3);


        bookdy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(navjivan_book_table_table3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            bookdy3.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });


        booktm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(navjivan_book_table_table3.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        booktm3.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });

        databaseReference3 = FirebaseDatabase.getInstance().getReference().child("navjivan_table3");
        tbbook3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty((booknm3.getText().toString()))) {
                    booknm3.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookdy3.getText().toString()))) {
                    bookdy3.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((booktm3.getText().toString()))) {
                    booktm3.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookphn3.getText().toString()))) {
                    bookphn3.setError("This is Required Filled");
                    return;
                }else if (bookphn3.getText().toString().length()!=10) {
                    bookphn3.setError("please enter proper number ");
                    return;
                }
                Intent
                        intent = new Intent(getApplicationContext() , navjivan_show_book_table3.class);
                startActivity(intent);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//        String bname3 = booknm3.getText().toString();
//        String bday3=bookdy3.getText().toString();
//        String btime3=booktm3.getText().toString();
//        String bphone3=bookphn3.getText().toString();
//        customer3 custo3=new customer3(bname3,bday3,btime3,bphone3);
//        databaseReference3.push().setValue(custo3);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String bname3 = booknm3.getText().toString();
        String bday3 = bookdy3.getText().toString();
        String btime3 = booktm3.getText().toString();
        String bphone3 = bookphn3.getText().toString();

        // Check if a booking already exists for the same date and time
        databaseReference3.orderByChild("bday3").equalTo(bday3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    customer3 existingBooking = snapshot.getValue(customer3.class);
                    if (existingBooking != null && existingBooking.getBtime3().equals(btime3)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    customer3 custo3 = new customer3(bname3, bday3, btime3, bphone3);
                    databaseReference3.push().setValue(custo3);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), navjivan_show_book_table3.class);
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