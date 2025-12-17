package com.example.mycanteenapp;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    Button btnOrderSnack, btnOwner;

    // 🔹 Animation variables
    TextView gplText;
    Handler handler = new Handler();

    String[] texts = {
            "SKIP THE INTERVAL RUSH.",
            "SNACKS FOR YOUR SHOWTIME.",
            "EAT. WATCH. REPEAT."
    };

    int textIndex = 0;
    int charIndex = 0;
    boolean isDeleting = false;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            String currentText = texts[textIndex];

            if (!isDeleting) {
                if (charIndex <= currentText.length()) {
                    gplText.setText(currentText.substring(0, charIndex));
                    charIndex++;
                } else {
                    isDeleting = true;
                    charIndex = currentText.length();
                }
            } else {
                if (charIndex >= 0) {
                    gplText.setText(currentText.substring(0, charIndex));
                    charIndex--;
                } else {
                    isDeleting = false;
                    textIndex++;
                    if (textIndex == texts.length) {
                        textIndex = 0;
                    }
                    charIndex = 0;
                }
            }

            handler.postDelayed(this, 120); // animation speed
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Buttons
        btnOrderSnack = findViewById(R.id.btnOrderSnack);
        btnOwner = findViewById(R.id.btnOwner);

        // Animated text
        gplText = findViewById(R.id.gpltext);
        handler.post(runnable);
    }
}