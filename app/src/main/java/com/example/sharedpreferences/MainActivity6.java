package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

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
        TextView question = findViewById(R.id.cau_hoi);
        TextView dap_an_a= findViewById(R.id.dap_an_a);
        TextView dap_an_b= findViewById(R.id.dap_an_b);
        TextView dap_an_c= findViewById(R.id.dap_an_c);
        TextView dap_an_d= findViewById(R.id.dap_an_d);
        TextView dap_an_dung= findViewById(R.id.dap_an_dung);


    }
}