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

public class amiras_book_table_table4 extends AppCompatActivity {


    EditText
            amiras_booknm4;
    EditText amiras_bookdy4;
    EditText amiras_booktm4;
    EditText amiras_bookphn4;
    Button amiras_tbbook4;
    DatabaseReference amiras_databaseReference4;
    DatePickerDialog picker;

    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amiras_book_table_table4);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        amiras_booknm4 = findViewById(R.id.amiras_bookname4);
        amiras_bookdy4 = findViewById(R.id.amiras_bookday4);
        amiras_booktm4=findViewById(R.id.amiras_booktime4);
        amiras_bookphn4=findViewById(R.id.amiras_bookphone4);
        amiras_tbbook4 = findViewById(R.id.amiras_bookbtn4);

        amiras_bookdy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(amiras_book_table_table4.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {

                            Toast.makeText(getApplicationContext(), "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            amiras_bookdy4.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });

        amiras_booktm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(amiras_book_table_table4.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        amiras_booktm4.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });

        amiras_databaseReference4 = FirebaseDatabase.getInstance().getReference().child("amiras_table4");
        amiras_tbbook4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty((amiras_booknm4.getText().toString()))) {
                    amiras_booknm4.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_bookdy4.getText().toString()))) {
                    amiras_bookdy4.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_booktm4.getText().toString()))) {
                    amiras_booktm4.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((amiras_bookphn4.getText().toString()))) {
                    amiras_bookphn4.setError("This is Required Filled");
                    return;
                }else if (amiras_bookphn4.getText().toString().length()!=10) {
                    amiras_bookphn4.setError("please enter proper number ");
                    return;
                }

                Intent intent = new Intent(getApplicationContext() , amiras_show_book_table4.class);
                startActivity(intent);
                insertstudentdata();
                finish();
            }
        });
    }

//    private void insertstudentdata() {
//
//        String amiras_bname4 = amiras_booknm4.getText().toString();
//        String amiras_bday4= amiras_bookdy4.getText().toString();
//        String amiras_btime4= amiras_booktm4.getText().toString();
//        String amiras_bphone4=amiras_bookphn4.getText().toString();
//        amiras_customer4 amiras_custo4=new amiras_customer4(amiras_bname4,amiras_bday4,amiras_btime4,amiras_bphone4);
//        amiras_databaseReference4.push().setValue(amiras_custo4);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String amiras_bname4 = amiras_booknm4.getText().toString();
        String amiras_bday4 = amiras_bookdy4.getText().toString();
        String amiras_btime4 = amiras_booktm4.getText().toString();
        String amiras_bphone4 = amiras_bookphn4.getText().toString();

        // Check if a booking already exists for the same date and time
        amiras_databaseReference4.orderByChild("amiras_bday4").equalTo(amiras_bday4).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    amiras_customer4 existingBooking = snapshot.getValue(amiras_customer4.class);
                    if (existingBooking != null && existingBooking.getAmiras_btime4().equals(amiras_btime4)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    amiras_customer4 amiras_custo4 = new amiras_customer4(amiras_bname4, amiras_bday4, amiras_btime4, amiras_bphone4);
                    amiras_databaseReference4.push().setValue(amiras_custo4);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), amiras_show_book_table4.class);
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