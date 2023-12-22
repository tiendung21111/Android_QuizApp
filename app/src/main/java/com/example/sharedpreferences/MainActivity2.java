package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {


    ArrayList<ChuDe> danhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        danhSach = new ArrayList<>();
        danhSach.add(new ChuDe(R.drawable.dialy, "Dia Ly", "cau hoi ve dia ly"));
        danhSach.add(new ChuDe(R.drawable.lichsu, "Lich Su", "cau hoi ve lich su"));
        danhSach.add(new ChuDe(R.drawable.taichinh, "tai chinh", "cau hoi ve kte tai chinh"));
        danhSach.add(new ChuDe(R.drawable.nghethuat, "nghe thuat", "cau hoi ve nghe thuat"));

        ChuDeAdapter adapter = new ChuDeAdapter(danhSach);
        ListView listView = findViewById(R.id.listProduct);
        listView.setAdapter(adapter);

    }
}