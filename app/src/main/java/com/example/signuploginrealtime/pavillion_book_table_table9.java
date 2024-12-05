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

public class pavillion_book_table_table9 extends AppCompatActivity {

    EditText
            pavillion_booknm9;
    EditText pavillion_bookdy9;
    EditText pavillion_booktm9;
    EditText pavillion_bookphn9;
    Button
            pavillion_tbbook9;
    DatabaseReference
            pavillion_databaseReference9;
    DatePickerDialog picker;
    TimePickerDialog time;
    Calendar cal;
    int currentHour;
    int currentMinute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavillion_book_table_table9);

        Toolbar
                toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        pavillion_booknm9 = findViewById(R.id.pavillion_bookname9);
        pavillion_bookdy9 = findViewById(R.id.pavillion_bookday9);
        pavillion_booktm9=findViewById(R.id.pavillion_booktime9);
        pavillion_bookphn9=findViewById(R.id.pavillion_bookphone9);
        pavillion_tbbook9 = findViewById(R.id.pavillion_bookbtn9);

        pavillion_bookdy9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(pavillion_book_table_table9.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(selectedYear, selectedMonth, selectedDay);

                        if (selectedDate.before(calendar)) {
                            // Show error message to user
                            Toast.makeText(pavillion_book_table_table9.this, "Cannot select previous date", Toast.LENGTH_SHORT).show();
                        } else {
                            // Set the selected date to the text view
                            pavillion_bookdy9.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                        }
                    }
                }, year, month, day);

                // Set the minimum date to the current date
                picker.getDatePicker().setMinDate(calendar.getTimeInMillis());

                picker.show();
            }
        });

        pavillion_booktm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);

                time = new TimePickerDialog(pavillion_book_table_table9.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        if (Hour >= 12){
                            ampm = "PM";
                        }else{
                            ampm = "AM";
                        }
                        pavillion_booktm9.setText(String.format("%02d:%02d %s", Hour % 12 == 0 ? 12 : Hour % 12, Minute, ampm));
                    }
                } ,0 , 0 ,false);
                time.show();
            }
        });


        pavillion_databaseReference9 = FirebaseDatabase.getInstance().getReference().child("pavillion_table9");
        pavillion_tbbook9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty((pavillion_booknm9.getText().toString()))) {
                    pavillion_booknm9.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((pavillion_bookdy9.getText().toString()))) {
                    pavillion_bookdy9.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((pavillion_booktm9.getText().toString()))) {
                    pavillion_booktm9.setError("This is Required Filled");
                    return;
                }
                else if(TextUtils.isEmpty((pavillion_bookphn9.getText().toString()))) {
                    pavillion_bookphn9.setError("This is Required Filled");
                    return;
                }else if (pavillion_bookphn9.getText().toString().length()!=10) {
                    pavillion_bookphn9.setError("please enter proper number ");
                    return;
                }
                Intent
                        intent = new Intent(getApplicationContext() , pavillion_show_book_table9.class);
                startActivity(intent);
                insertstudentdata();

            }
        });
    }

//    private void insertstudentdata() {
//        String pavillion_bname9 = pavillion_booknm9.getText().toString();
//        String pavillion_bday9= pavillion_bookdy9.getText().toString();
//        String pavillion_btime9= pavillion_booktm9.getText().toString();
//        String pavillion_bphone9=pavillion_bookphn9.getText().toString();
//        pavillion_customer9 pavillion_custo9 =new pavillion_customer9(pavillion_bname9,pavillion_bday9,pavillion_btime9,pavillion_bphone9);
//        pavillion_databaseReference9.push().setValue(pavillion_custo9);
//        Toast.makeText(getApplicationContext(),"inserted successfully",Toast.LENGTH_LONG).show();
//    }

    private void insertstudentdata() {
        String pavillion_bname9 = pavillion_booknm9.getText().toString();
        String pavillion_bday9 = pavillion_bookdy9.getText().toString();
        String pavillion_btime9 = pavillion_booktm9.getText().toString();
        String pavillion_bphone9 = pavillion_bookphn9.getText().toString();

        // Check if a booking already exists for the same date and time
        pavillion_databaseReference9.orderByChild("pavillion_bday9").equalTo(pavillion_bday9).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isConflict = false;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    pavillion_customer9 existingBooking = snapshot.getValue(pavillion_customer9.class);
                    if (existingBooking != null && existingBooking.getPavillion_btime9().equals(pavillion_btime9)) {
                        isConflict = true;
                        break;
                    }
                }

                if (isConflict) {
                    Toast.makeText(getApplicationContext(), "Table is already booked by someone on this date and time.", Toast.LENGTH_LONG).show();
                } else {
                    // If not booked then, book table
                    pavillion_customer9 pavillion_custo9 = new pavillion_customer9(pavillion_bname9, pavillion_bday9, pavillion_btime9, pavillion_bphone9);
                    pavillion_databaseReference9.push().setValue(pavillion_custo9);
                    Toast.makeText(getApplicationContext(), "Inserted successfully", Toast.LENGTH_LONG).show();

                    // Redirect to the show booking activity
                    Intent intent = new Intent(getApplicationContext(), pavillion_show_book_table9.class);
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