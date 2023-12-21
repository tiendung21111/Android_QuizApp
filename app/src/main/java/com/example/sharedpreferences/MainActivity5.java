package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
    private static final String KEY_CHU_DE = "Chu_de";
    private static final String[] PRODUCTS = {"Khoa học", "Nghệ thuật", "Địa lý", "Lịch sử"};

    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        setupAutoCompleteTextView();
        initializeQuestionList();
        setupQuestionListView();
    }

    private void setupAutoCompleteTextView() {
        AutoCompleteTextView autoCompleteChuDe = findViewById(R.id.Chu_de);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, PRODUCTS);
        autoCompleteChuDe.setAdapter(adapter);
    }

    private void initializeQuestionList() {
        questionList = new ArrayList<>();
        questionList.add(new Question("Địa lý", true, 1));
        questionList.add(new Question("Địa lý", false, 2));
        questionList.add(new Question("Khoa học", true, 3));
        questionList.add(new Question("Khoa học", false, 4));
        questionList.add(new Question("Lịch sử", true, 5));
        questionList.add(new Question("Lịch sử", false, 6));
    }

    private void setupQuestionListView() {
        QuestionAdapter questionAdapter = new QuestionAdapter(questionList);
        ListView questionListView = findViewById(R.id.listQuestion);

        if (questionListView != null) {
            questionListView.setAdapter(questionAdapter);
        }
    }
}
