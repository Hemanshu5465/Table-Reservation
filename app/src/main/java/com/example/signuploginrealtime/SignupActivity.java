package com.example.signuploginrealtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText signupName, signupEmail, signupUserName, signupPassword;
    TextView loginRedirectText;

    Button signupButton;

    FirebaseDatabase database;

    DatabaseReference reference;

    ImageView google, facebook, x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        google = findViewById(R.id.google);
        facebook = findViewById(R.id.facebook);
        x = findViewById(R.id.x);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUserName = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("user");


                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUserName.getText().toString();
                String password = signupPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);



                if (TextUtils.isEmpty((signupName.getText().toString()))) {
                    signupUserName.setError("name is compulsory");
                    return;
                }
                if (TextUtils.isEmpty((signupEmail.getText().toString()))) {
                    signupEmail.setError("email is compulsory");
                    return;
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    signupEmail.setError("enter valid email");
                    return;
                }
                if (TextUtils.isEmpty((signupUserName.getText().toString()))) {
                    signupUserName.setError("username is compulsory");
                    return;
                }
                if (TextUtils.isEmpty((signupPassword.getText().toString()))) {
                    signupPassword.setError("password is compulsory");
                    return;
                }else if (signupPassword.getText().toString().length()!=6) {
                    signupPassword.setError("password must be 6 laters ");
                    return;
                }
                Toast.makeText(SignupActivity.this, "you have signup successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, home2.class);
                startActivity(intent);
                finish();
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent
                        intent =
                        new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.co.in/");
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/login/");
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://x.com/?lang=en");
            }
        });
    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}