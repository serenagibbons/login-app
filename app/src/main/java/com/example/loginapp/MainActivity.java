package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // when registration button clicked go to registration activity
    public void goToRegistration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    // when log in button clicked go to log in activity
    public void goToLogIn(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
