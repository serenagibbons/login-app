package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1, e2;
    String userFName, userEmail, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1 = findViewById(R.id.edtEmail2);
        e2 = findViewById(R.id.edtPassword2);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if (b != null) {
            if ((boolean) b.get("Success")) {
                // display toast if registration was successful
                Toast.makeText(this, getResources().getString(R.string.toast_success), Toast.LENGTH_LONG).show();
            }
            // set variables using data from intent from registration activity
            userFName = (String) b.get("First Name");
            userEmail = (String) b.get("Email");
            userPass = (String) b.get("Password");
        }

    }

    public void logIn(View view) {
        // if either field is empty, make toast and return
        if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.toast_logFields), Toast.LENGTH_LONG).show();
            return;
        }
        // else if email and password don't match data from registration activity, make toast and return
        else if (!(e1.getText().toString().equals(userEmail) && e2.getText().toString().equals(userPass))) {
            Toast.makeText(this, getResources().getString(R.string.toast_login), Toast.LENGTH_LONG).show();
            return;
        }

        // email and password match so go to MainActivity
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("First Name", userFName);
        startActivity(i);

    }

    public void goToRegistration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}
