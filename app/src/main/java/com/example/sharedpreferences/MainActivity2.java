package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import android.content.Context;
import android.content.SharedPreferences;


public class MainActivity2 extends AppCompatActivity {


    ArrayList<ChuDe> danhSach;

    private int h ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent1 = getIntent();
        int finalTotalScore = intent1.getIntExtra("finalScore", 0);
        TextView txtFinalScore = findViewById(R.id.total_score);


        SharedPreferences sharedPref = getSharedPreferences("PREF", Context.MODE_PRIVATE);
        txtFinalScore.setText(sharedPref.getInt("TotalScore", 0) + " pts");


        danhSach = new ArrayList<>();
        danhSach.add(new ChuDe(R.drawable.dialy, "Địa Lý", "Những câu hỏi xoay quanh địa lý Việt Nam", 1));
        danhSach.add(new ChuDe(R.drawable.lichsu, "Lịch Sử", "Câu hỏi về những sự kiện lịch sử Việt Nam", 2));
        danhSach.add(new ChuDe(R.drawable.taichinh, "Tài Chính", "Câu hỏi về vấn đề tài chính kinh tế toàn cầu", 3));
        danhSach.add(new ChuDe(R.drawable.nghethuat, "Nghệ Thuật", "Câu hỏi về nghệ thuật thế giới", 4));

        ChuDeAdapter adapter = new ChuDeAdapter(danhSach);
        ListView listView = findViewById(R.id.listProduct);
        listView.setAdapter(adapter);

        int checked;
        Switch sw1 = findViewById(R.id.checkDoKho);
        if(sw1.isChecked())checked = 1;
        else {
            checked = 0;
        }

        Button btnDsCauHoi = findViewById(R.id.listCH);

        final int[] a = {0};

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChuDe chuDe =(ChuDe) adapter.getItem(position);
                a[0] = chuDe.getId();
                if(a[0] == 1 ){

                    if((sw1.isChecked())){
                        h=1;
                    }
                    else h =2;

                }
                if(a[0] == 2 ){

                    if((sw1.isChecked())){
                        h=3;
                    }
                    else h = 4;

                }
                if(a[0] == 3 ){

                    if((sw1.isChecked())){
                        h=5;
                    }
                    else h = 6;

                }
                if(a[0] == 4 ){

                    if((sw1.isChecked())){
                        h=7;
                    }
                    else h = 8;

                }
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("th", h);
                startActivity(intent);

            }
        });

        btnDsCauHoi.setOnClickListener(View -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(intent);


        });

    }



}