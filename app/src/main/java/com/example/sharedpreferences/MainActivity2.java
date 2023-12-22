package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    ArrayList<ChuDe> danhSach;

    private int h ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        danhSach = new ArrayList<>();
        danhSach.add(new ChuDe(R.drawable.dialy, "Dia Ly", "cau hoi ve dia ly", 1));
        danhSach.add(new ChuDe(R.drawable.lichsu, "Lich Su", "cau hoi ve lich su", 2));
        danhSach.add(new ChuDe(R.drawable.taichinh, "tai chinh", "cau hoi ve kte tai chinh", 3));
        danhSach.add(new ChuDe(R.drawable.nghethuat, "nghe thuat", "cau hoi ve nghe thuat", 4));

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

            }
        });

        btnDsCauHoi.setOnClickListener(View -> {

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

        });

    }



}