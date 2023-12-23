package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = getIntent();
        int totalScoreFromM4 = intent1.getIntExtra("totalScore", 0);
        finalScore = totalScoreFromM4;

        Button btnStart = findViewById(R.id.BtnStart);
        btnStart.setOnClickListener(View -> {

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("finalScore", finalScore);
            startActivity(intent);

        });


    }
}