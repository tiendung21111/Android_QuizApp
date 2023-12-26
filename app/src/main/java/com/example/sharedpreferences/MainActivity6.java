package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {
    List<Question> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        TextView question = findViewById(R.id.Cau_hoi);
        TextView dokho= findViewById(R.id.Do_kho);
        TextView dap_an_a= findViewById(R.id.Dap_an_A);
        TextView dap_an_b= findViewById(R.id.Dap_an_B);
        TextView dap_an_c= findViewById(R.id.Dap_an_C);
        TextView dap_an_d= findViewById(R.id.Dap_an_D);
        TextView dap_an_dung= findViewById(R.id.Dap_an_Dung);
        Intent intent= getIntent();
        question.setText(intent.getStringExtra("cauhoi"));
        dokho.setText(intent.getStringExtra("dokho"));
        dap_an_a.setText(intent.getStringExtra("dapanA"));
        dap_an_b.setText(intent.getStringExtra("dapanB"));
        dap_an_c.setText(intent.getStringExtra("dapanC"));
        dap_an_d.setText(intent.getStringExtra("dapanD"));
        dap_an_dung.setText("Đáp án đúng: "+intent.getStringExtra("dapandung"));


    }
}