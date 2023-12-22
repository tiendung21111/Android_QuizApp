package com.example.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity3 extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerRadioGroup;
    private Button submitButton;

    private ArrayList<Question> questions;
    private int currentQuestionIndex;

    private int countRightAnswer = 0;
    private String txtCount;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        questionTextView = findViewById(R.id.questionTextView);
        answerRadioGroup = findViewById(R.id.answerRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        // Tạo các câu hỏi và đáp án
        questions = new ArrayList<>();

        Intent intent1 = getIntent();
        int ths = intent1.getIntExtra("th", 0);


        if(ths == 1) {
            questions.add(new Question("Quần Đảo Hoàng Sa thuộc tỉnh/ tp nào?", new String[]{"Đà Nẵng", "Nha Trang", "Phan Thiết", "Hải Phòng"}, 0));
            questions.add(new Question("Việt Nam có bao nhiêu dân tộc thiểu số?", new String[]{"51", "53", "54", "55"}, 1));
            questions.add(new Question("Cột mốc biên giới Việt Nam - Lào- Campuchia ở đâu?", new String[]{"Hà Giang", "Điện Biên", "Kon Tum", "Lào Cai"}, 2));
        }
        else if(ths == 2) {
            questions.add(new Question("Hang động lớn nhất Việt Nam?", new String[]{"Phong Nha- Kẻ Bàng", "Sơn Đòong", "Hang Én", "Tràng An"}, 1));
            questions.add(new Question("Giờ Việt Nam theo múi giờ nào?", new String[]{"GMT+7", "GMT+8", "GMT+11", "GMT+12"}, 0));
            questions.add(new Question("Vịnh nào Việt Nam lot top 7 kỳ quan thế giới?", new String[]{"Cát Bà", "Côtô", "Hạ Long", "Lan Hạ"}, 3));
        }
        else if(ths == 3) {
            questions.add(new Question("Trong lịch sử, Nhà Trần đã 3 lần đánh thắng quân xâm lược nào?", new String[]{"Nam Hán", "Nhà Thanh", "Nhà Tần", "Mông Nguyên"}, 3));
            questions.add(new Question("Quốc hiệu Việt Nam dưới thời nhà Hồ?", new String[]{"Đại Ngu", "Đại Việt", "Văn Lang", "Âu Lac"}, 0));
            questions.add(new Question("Vị vua cuối cùng của chế độ quân chủ", new String[]{"Gia Long", "Bảo Đại", "Duy Tân", "Hàm Nghi"}, 1));
        }

        else if(ths == 4) {
            questions.add(new Question("Chiến dịch Điện Biên Phủ kéo dài bao nhiêu ngày đêm?", new String[]{"48", "49", "56", "57"}, 2));
            questions.add(new Question("Ai là hoàng đế đầu tiên của Việt Nam?", new String[]{"Vua Hùng", "Đinh Bộ Lĩnh", "Ngô Quyền", "Lý Nam Đế"}, 3));
            questions.add(new Question("Việt Nâm hoàn toàn giải phóng năm nào?", new String[]{"1945", "1952", "1972", "1979"}, 2));
        }

        else if(ths == 5) {
            questions.add(new Question("Đâu là 1 trong 4 con rồng kinh tế của châu á?", new String[]{"Việt Nam", "Trung Quốc", "Hong Kong", "Nhật Bản"}, 0));
            questions.add(new Question("Đồng tiền nước nào có giá trị cao nhất thế giới??", new String[]{"Mỹ", "Anh", "Kuwait", "Nhật"}, 2));
            questions.add(new Question("Đâu là trung tâm tài chính thế giới ?", new String[]{"Hong Kong", "Đài loan", "New York", "Wasington"}, 2));
        }

        else if(ths == 6) {
            questions.add(new Question("Đâu là nước có nền kinh tế phát triển nhất thế giới?", new String[]{"Mỹ", "Đức", "Trung Quốc", "Nhật Bản"}, 0));
            questions.add(new Question("Việt Nam có nền kinh tế phát triển thứ mấy Đông Nam Á?", new String[]{"1", "2", "3", "4"}, 3));
            questions.add(new Question("Đâu là ti phú giàu nhất Thế Giới?", new String[]{"Elon Musk", "Jeff Bezos", "Bill Gates", "Warren Buffet"}, 3));
        }

        else if(ths == 7) {
            questions.add(new Question("Bức tranh mona lisa của họa sĩ nào?", new String[]{"Van Gogh", "Manat", "Picasso", "Leonardo da vinci"}, 3));
            questions.add(new Question("Bài hát “Tình ca”- Hoàng Việt nói đến mùa nào trong năm?", new String[]{"Mùa Xuân", "Mùa Hạ", "Mùa Thu", "Mùa Đông"}, 0));
            questions.add(new Question("Lễ hội Canaval là lễ hội nổi tiếng ở quốc gia nào?", new String[]{"Brazil", "Ý", "Pháp", "Anh"}, 0));
        }

        else {
            questions.add(new Question("Van Gogh là một họa sĩ nước nào?", new String[]{"Ý", "Hà Lan", "Pháp", "Thụy Sĩ"}, 1));
            questions.add(new Question("Bản nhạc sonate là bản nhạc huyền thoại của nghệ sĩ nào?", new String[]{"Beethoven", "Paganini", "Mozart", "Brahms"}, 0));
            questions.add(new Question("Đâu là bộ phim có doanh thu cao nhất mọi thời đại?", new String[]{"Avenger:End Game", "Jurassic World", "Titanic", "Avatar"}, 3));
        }

        currentQuestionIndex = 0;

        displayQuestion(currentQuestionIndex);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion(int index) {
        if (index < questions.size()) {
            Question currentQuestion = questions.get(index);
            questionTextView.setText(currentQuestion.getQuestion());
            String[] answers = currentQuestion.getAnswers();
            for (int i = 0; i < answerRadioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) answerRadioGroup.getChildAt(i);
                radioButton.setText(answers[i]);


            }
        } else {
            // Hiển thị màn hình 4 nếu đã trả lời hết các câu hỏi
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("count", countRightAnswer);
            startActivity(intent);

        }
    }

    private void checkAnswer() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        int selectedAnswerIndex = answerRadioGroup.indexOfChild(findViewById(answerRadioGroup.getCheckedRadioButtonId()));

        if (selectedAnswerIndex == currentQuestion.getCorrectAnswerIndex()) {
            // Chuyển sang câu hỏi tiếp theo nếu trả lời đúng
            countRightAnswer++;
//            txtCount =(String) currentQuestion.toString();
            currentQuestionIndex++;
            answerRadioGroup.clearCheck();
            displayQuestion(currentQuestionIndex);

        } else {
            // Hiển thị màn hình 4 nếu trả lời sai
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("count", countRightAnswer);
            startActivity(intent);
        }
    }



    public class Question {
        private String question;
        private String[] answers;
        private int correctAnswerIndex;

        public Question(String question, String[] answers, int correctAnswerIndex) {
            this.question = question;
            this.answers = answers;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getAnswers() {
            return answers;
        }

        public int getCorrectAnswerIndex() {
            return correctAnswerIndex;
        }
    }

}
