package com.example.mycanteenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    Button btnOrderSnack, btnOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnOrderSnack = findViewById(R.id.btnOrderSnack);
        btnOwner = findViewById(R.id.btnOwner);

        btnOrderSnack.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, customeractivity.class));
        });

        btnOwner.setOnClickListener(v -> {
            startActivity(new Intent(HomePage.this, owneractivity.class));
        });
    }
}