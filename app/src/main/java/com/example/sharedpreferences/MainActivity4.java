package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Intent intent1 = getIntent();
        int rightAs = intent1.getIntExtra("count", 0);

        TextView displayCount = findViewById(R.id.diem);
        displayCount.setText(String.valueOf(rightAs));

    }
}