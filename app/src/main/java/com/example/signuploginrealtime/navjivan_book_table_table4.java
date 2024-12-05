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

public class navjivan_book_table_table4 extends AppCompatActivity {
    EditText booknm4;
    EditText bookdy4;
    EditText booktm4;
    EditText bookphn4;
    Button tbbook4;
    DatabaseReference databaseReference4;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navjivan_book_table_table4);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        booknm4 = findViewById(R.id.bookname4);
        bookdy4 = findViewById(R.id.bookday4);
        booktm4 = findViewById(R.id.booktime4);
        bookphn4 = findViewById(R.id.bookphone4);
        tbbook4 = findViewById(R.id.bookbtn4);

        bookdy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(navjivan_book_table_table4.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            bookdy4.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });


        booktm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(navjivan_book_table_table4.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        booktm4.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });

        databaseReference4 = FirebaseDatabase.getInstance().getReference().child("navjivan_table4");
        tbbook4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((booknm4.getText().toString()))) {
                    booknm4.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookdy4.getText().toString()))) {
                    bookdy4.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((booktm4.getText().toString()))) {
                    booktm4.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookphn4.getText().toString()))) {
                    bookphn4.setError("This is Required Filled");
                    return;
                }else if (bookphn4.getText().toString().length()!=10) {
                    bookphn4.setError("please enter proper number ");
                    return;
                }
                Intent i2 = new Intent(getApplicationContext(), navjivan_show_book_table4.class);
                startActivity(i2);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//        String bname4 = booknm4.getText().toString();
//        String bday4 = bookdy4.getText().toString();
//        String btime4 = booktm4.getText().toString();
//        String bphone4 = bookphn4.getText().toString();
//        customer4 custo4 = new customer4(bname4, bday4, btime4, bphone4);
//        databaseReference4.push().setValue(custo4);
//        Toast.makeText(getApplicationContext(), "inserted successfully", Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String bname4 = booknm4.getText().toString();
        String bday4 = bookdy4.getText().toString();
        String btime4 = booktm4.getText().toString();
        String bphone4 = bookphn4.getText().toString();

        // Check if a booking already exists for the same date and time
        databaseReference4.orderByChild("bday4").equalTo(bday4).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    customer4 existingBooking = snapshot.getValue(customer4.class);
                    if (existingBooking != null && existingBooking.getBtime4().equals(btime4)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    customer4 custo4 = new customer4(bname4, bday4, btime4, bphone4);
                    databaseReference4.push().setValue(custo4);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), navjivan_show_book_table4.class);
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