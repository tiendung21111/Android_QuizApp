package com.example.sharedpreferences;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
    private static final String KEY_CHU_DE = "Chu_de";
    private static final String[] PRODUCTS = {"Khoa học", "Nghệ thuật", "Địa lý", "Lịch sử"};

    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAutoCompleteTextView();
        initializeQuestionList();
        setupQuestionListView();
    }
    private void setupAutoCompleteTextView() {
        AutoCompleteTextView autoCompleteChuDe = findViewById(R.id.Chu_de);
        autoCompleteChuDe.post(() -> autoCompleteChuDe.showDropDown());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, PRODUCTS);

        autoCompleteChuDe.setAdapter(adapter);
        autoCompleteChuDe.setThreshold(0); // Đặt ngưỡng tìm kiếm xuống 0

    }


    private void initializeQuestionList() {
        questionList = new ArrayList<>();
        questionList.add(new Question("Nghệ thuật","khó",1,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Nghệ thuật","dễ",2,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Địa lý","khó",3,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Địa lý","dễ",4,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Lịch sử","khó",5,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Lịch sử","dễ",6,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Khoa học","khó",7,"aaaa", "a", "b", "c", "d","a"));
        questionList.add(new Question("Khoa học","dễ",8,"aaaa", "a", "b", "c", "d","a"));

    }

    private void setupQuestionListView() {
        ListView questionListView = findViewById(R.id.listQuestion);
        questionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Question selectedQuestion = questionList.get(position);
                // Chuyển Intent và đính kèm dữ liệu từ câu hỏi được chọn
                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                intent.putExtra("cauhoi", selectedQuestion.getQuestion());
                intent.putExtra("dokho", selectedQuestion.getDo_kho());
                intent.putExtra("dapanA", selectedQuestion.getOptionA());
                intent.putExtra("dapanB", selectedQuestion.getOptionB());
                intent.putExtra("dapanC", selectedQuestion.getOptionC());
                intent.putExtra("dapanD", selectedQuestion.getOptionD());
                intent.putExtra("dapandung", selectedQuestion.getRightAnswer());

                startActivity(intent);
            }
        });

        LQuestionAdapter questionAdapter = new LQuestionAdapter(questionList);
        questionListView.setAdapter(questionAdapter);
    }
}
