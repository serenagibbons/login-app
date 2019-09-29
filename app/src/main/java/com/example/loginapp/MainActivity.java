package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String storedFName, storedLName, storedEmail, storedDOB, storedPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i= getIntent();
        Bundle b = i.getExtras();

        if(b!=null)
        {
            if ((boolean) b.get("Success")) {
                Toast.makeText(this, getResources().getString(R.string.toast_success), Toast.LENGTH_LONG).show();
            }
            storedFName =(String) b.get("First Name");
            storedLName =(String) b.get("Last Name");
            storedDOB =(String) b.get("Date of Birth");
            storedEmail =(String) b.get("Email");
            storedPass =(String) b.get("Password");
        }
    }

    // when registration button clicked go to registration activity
    public void goToRegistration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    // when log in button clicked go to log in activity
    public void goToLogIn(View view) {
        Intent logInIntent = new Intent(this, LoginActivity.class);
        logInIntent.putExtra("First Name", storedFName);
        logInIntent.putExtra("Last Name", storedLName);
        logInIntent.putExtra("Email", storedEmail);
        logInIntent.putExtra("Date of Birth", storedDOB);
        logInIntent.putExtra("Password", storedPass);
        startActivity(logInIntent);
    }
}
