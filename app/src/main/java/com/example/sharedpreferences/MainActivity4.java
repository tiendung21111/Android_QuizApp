package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView diem = findViewById(R.id.diem);
        Button hoan_thanh=findViewById(R.id.hoan_thanh);
        Button choi_lai=findViewById(R.id.choi_lai);
        Button share=findViewById(R.id.share);
        hoan_thanh.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity.class);
        });
        choi_lai.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity3.class);
        });
        share.setOnClickListener(v -> {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Tôi đã được điểm cao");
            shareIntent.setType("text/plain");

            // Start the Intent
            startActivity(Intent.createChooser(shareIntent, "Share via..."));
        });
    }
}