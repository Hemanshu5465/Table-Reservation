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

public class navjivan_book_table_table7 extends AppCompatActivity {

    EditText
            booknm7;
    EditText bookdy7;
    EditText booktm7;
    EditText bookphn7;
    Button tbbook7;
    DatabaseReference databaseReference7;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navjivan_book_table_table7);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        booknm7 = findViewById(R.id.bookname7);
        bookdy7 = findViewById(R.id.bookday7);
        booktm7 = findViewById(R.id.booktime7);
        bookphn7 = findViewById(R.id.bookphone7);
        tbbook7 = findViewById(R.id.bookbtn7);

        bookdy7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(navjivan_book_table_table7.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            bookdy7.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });


        booktm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(navjivan_book_table_table7.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        booktm7.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });

        databaseReference7 = FirebaseDatabase.getInstance().getReference().child("navjivan_table7");
        tbbook7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((booknm7.getText().toString()))) {
                    booknm7.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookdy7.getText().toString()))) {
                    bookdy7.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((booktm7.getText().toString()))) {
                    booktm7.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookphn7.getText().toString()))) {
                    bookphn7.setError("This is Required Filled");
                    return;
                }else if (bookphn7.getText().toString().length()!=10) {
                    bookphn7.setError("please enter proper number ");
                    return;
                }
                Intent i2 = new Intent(getApplicationContext(), navjivan_show_book_table7.class);
                startActivity(i2);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//        String bname7 = booknm7.getText().toString();
//        String bday7 = bookdy7.getText().toString();
//        String btime7 = booktm7.getText().toString();
//        String bphone7 = bookphn7.getText().toString();
//        customer7 custo7 = new customer7(bname7, bday7, btime7, bphone7);
//        databaseReference7.push().setValue(custo7);
//        Toast.makeText(getApplicationContext(), "inserted successfully", Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String bname7 = booknm7.getText().toString();
        String bday7 = bookdy7.getText().toString();
        String btime7 = booktm7.getText().toString();
        String bphone7 = bookphn7.getText().toString();

        // Check if a booking already exists for the same date and time
        databaseReference7.orderByChild("bday7").equalTo(bday7).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    customer7 existingBooking = snapshot.getValue(customer7.class);
                    if (existingBooking != null && existingBooking.getBtime7().equals(btime7)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    customer7 custo7 = new customer7(bname7, bday7, btime7, bphone7);
                    databaseReference7.push().setValue(custo7);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), navjivan_show_book_table7.class);
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