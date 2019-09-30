package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textWelcome);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        // welcome the user
        if (b != null) {
            name = (String) b.get("First Name");
            String welcome = String.format(getResources().getString(R.string.label_welcome), name);
            text.setText(welcome);
        }
    }

    // log out - go back to log in page
    public void logout(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
