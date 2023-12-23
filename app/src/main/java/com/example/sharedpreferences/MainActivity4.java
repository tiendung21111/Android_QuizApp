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

    private int ths2;
    private int tmpM4;

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

        Intent intent2 = getIntent();
        int ths1 = intent2.getIntExtra("thsFromM3",0 );
        int tmp1 = intent2.getIntExtra("tmp", 0);
        ths2 = ths1+8;
        tmpM4 = tmp1;

        Button btnChoiLai = findViewById(R.id.choi_lai);
        btnChoiLai.setOnClickListener(View -> {

            Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
            intent.putExtra("ths1FromM4", ths2);
            intent.putExtra("tmp1", tmpM4);
            startActivity(intent);

        });



    }
}