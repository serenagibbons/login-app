package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class RegistrationActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5;
    boolean valid;
    String fName, lName, dob, email, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1 = findViewById(R.id.edtFName);
        e2 = findViewById(R.id.edtLName);
        e3 = findViewById(R.id.edtDOB);
        e4 = findViewById(R.id.edtEmail);
        e5 = findViewById(R.id.edtPassword);
    }

    public void registerUser(View view) {
        // reset valid boolean
        valid = true;

        if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()
                || e3.getText().toString().isEmpty() || e4.getText().toString().isEmpty()
                || e5.getText().toString().isEmpty()) {
            // if any fields are empty display toast and return
            Toast.makeText(this, getResources().getString(R.string.toast_regFields), Toast.LENGTH_LONG).show();
            return;
        }

        // set variables using user's input
        fName = e1.getText().toString();
        lName = e2.getText().toString();
        dob = e3.getText().toString();
        email = e4.getText().toString();
        pass = e5.getText().toString();

        // test user input
        validateInput();

        // if any fields have incorrect input, display toast
        if (!valid) {
            Toast.makeText(this, getResources().getString(R.string.toast_valid), Toast.LENGTH_LONG).show();
            return;
        }

        // create new intent and send data to the LoginActivity
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("First Name", fName);
        intent.putExtra("Last Name", lName);
        intent.putExtra("Date of Birth", dob);
        intent.putExtra("Email", email);
        intent.putExtra("Password", pass);
        intent.putExtra("Success", true);
        startActivity(intent);
    }

    public boolean validateInput() {
        // check first name must be between 3 and 30 characters
        if (fName.length() < 3 || fName.length() > 30) {
            Toast.makeText(this, getResources().getString(R.string.toast_name), Toast.LENGTH_LONG).show();
            valid = false;
        }

        // try to parse dob to check for valid date of birth
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
            sdf.setLenient(false);
            sdf.parse(dob);
        }
        catch (Exception e) {
            Toast.makeText(this, getResources().getString(R.string.toast_date), Toast.LENGTH_LONG).show();
            valid = false;
        }

        // check for valid email address
        if (!(email.contains("@") || email.endsWith(".edu")
                || email.endsWith(".com") || email.endsWith(".org") || email.endsWith(".net"))) {
            Toast.makeText(this, getResources().getString(R.string.toast_email), Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }

    public void goToLogIn(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
