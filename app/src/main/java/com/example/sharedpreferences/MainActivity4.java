package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Intent intent1 = getIntent();
        int rightAs = intent1.getIntExtra("count", 0);

        TextView displayCount = findViewById(R.id.diem);
        displayCount.setText(String.valueOf(rightAs));
        Button hoan_thanh= findViewById(R.id.hoan_thanh);
        Button choi_lai= findViewById(R.id.choi_lai);
        Button share = findViewById(R.id.share);
        hoan_thanh.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this,MainActivity.class);
            startActivity(intent);
        });
        choi_lai.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
            startActivity(intent);
        });
        share.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Tôi đã đạt được " + String.valueOf(rightAs)+ " điểm trong ứng dụng Q&A");
            sendIntent.setType("text/plain");
            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(sendIntent);
            } else {
                Toast.makeText(this, "Không có ứng dụng nào có thể xử lý Intent", Toast.LENGTH_SHORT).show();

            }


        });
    }
}