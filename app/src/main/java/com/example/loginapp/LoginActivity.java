package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1 = findViewById(R.id.edtEmail2);
        e2 = findViewById(R.id.edtPassword2);

    }

    public void logIn(View view) {

        if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.toast_valid), Toast.LENGTH_LONG).show();
            return;
        }
        startActivity(new Intent(this, AppActivity.class));

    }
}
