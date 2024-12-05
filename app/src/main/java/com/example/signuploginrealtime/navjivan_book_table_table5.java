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

public class navjivan_book_table_table5 extends AppCompatActivity {

    EditText
            booknm5;
    EditText bookdy5;
    EditText booktm5;
    EditText bookphn5;
    Button
            tbbook5;
    DatabaseReference
            databaseReference5;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navjivan_book_table_table5);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        booknm5 = findViewById(R.id.bookname5);
        bookdy5 = findViewById(R.id.bookday5);
        booktm5=findViewById(R.id.booktime5);
        bookphn5=findViewById(R.id.bookphone5);
        tbbook5 = findViewById(R.id.bookbtn5);

        bookdy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(navjivan_book_table_table5.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            bookdy5.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });


        booktm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(navjivan_book_table_table5.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        booktm5.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });

        databaseReference5 = FirebaseDatabase.getInstance().getReference().child("navjivan_table5");
        tbbook5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((booknm5.getText().toString()))) {
                    booknm5.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookdy5.getText().toString()))) {
                    bookdy5.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((booktm5.getText().toString()))) {
                    booktm5.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((bookphn5.getText().toString()))) {
                    bookphn5.setError("This is Required Filled");
                    return;
                }else if (bookphn5.getText().toString().length()!=10) {
                    bookphn5.setError("please enter proper number ");
                    return;
                }
                Intent intent = new Intent(getApplicationContext() , navjivan_show_book_table5.class);
                startActivity(intent);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//        String bname5 = booknm5.getText().toString();
//        String bday5=bookdy5.getText().toString();
//        String btime5=booktm5.getText().toString();
//        String bphone5=bookphn5.getText().toString();
//        customer5 custo5=new customer5(bname5,bday5,btime5,bphone5);
//        databaseReference5.push().setValue(custo5);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String bname5 = booknm5.getText().toString();
        String bday5 = bookdy5.getText().toString();
        String btime5 = booktm5.getText().toString();
        String bphone5 = bookphn5.getText().toString();

        // Check if a booking already exists for the same date and time
        databaseReference5.orderByChild("bday5").equalTo(bday5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    customer5 existingBooking = snapshot.getValue(customer5.class);
                    if (existingBooking != null && existingBooking.getBtime5().equals(btime5)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    customer5 custo5 = new customer5(bname5, bday5, btime5, bphone5);
                    databaseReference5.push().setValue(custo5);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), navjivan_show_book_table5.class);
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