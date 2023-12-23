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


    private int ths1;

    private int ths1FromM4 = 0;

    private int tmp = 0;

    private int tmp1;





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
        ths1=ths;
        Intent intent2 = getIntent();
        ths1FromM4 = intent2.getIntExtra("ths1FromM4", 0);
        tmp1 = intent2.getIntExtra("tmp1", 0);





        if(tmp1 == 0) {
            if (ths == 1) {
                questions.add(new Question("Quần Đảo Hoàng Sa thuộc tỉnh/ tp nào?", new String[]{"Đà Nẵng", "Nha Trang", "Phan Thiết", "Hải Phòng"}, 0));
                questions.add(new Question("Việt Nam có bao nhiêu dân tộc thiểu số?", new String[]{"51", "53", "54", "55"}, 2));
                questions.add(new Question("Cột mốc biên giới Việt Nam - Lào- Campuchia ở đâu?", new String[]{"Hà Giang", "Điện Biên", "Kon Tum", "Lào Cai"}, 2));
            } else if (ths == 2) {
                questions.add(new Question("Hang động lớn nhất Việt Nam?", new String[]{"Phong Nha- Kẻ Bàng", "Sơn Đòong", "Hang Én", "Tràng An"}, 1));
                questions.add(new Question("Giờ Việt Nam theo múi giờ nào?", new String[]{"GMT+7", "GMT+8", "GMT+11", "GMT+12"}, 0));
                questions.add(new Question("Vịnh nào Việt Nam lot top 7 kỳ quan thế giới?", new String[]{"Cát Bà", "Côtô", "Hạ Long", "Lan Hạ"}, 3));
            } else if (ths == 3) {
                questions.add(new Question("Trong lịch sử, Nhà Trần đã 3 lần đánh thắng quân xâm lược nào?", new String[]{"Nam Hán", "Nhà Thanh", "Nhà Tần", "Mông Nguyên"}, 3));
                questions.add(new Question("Quốc hiệu Việt Nam dưới thời nhà Hồ?", new String[]{"Đại Ngu", "Đại Việt", "Văn Lang", "Âu Lac"}, 0));
                questions.add(new Question("Vị vua cuối cùng của chế độ quân chủ", new String[]{"Gia Long", "Bảo Đại", "Duy Tân", "Hàm Nghi"}, 1));
            } else if (ths == 4) {
                questions.add(new Question("Chiến dịch Điện Biên Phủ kéo dài bao nhiêu ngày đêm?", new String[]{"48", "49", "56", "57"}, 2));
                questions.add(new Question("Ai là hoàng đế đầu tiên của Việt Nam?", new String[]{"Vua Hùng", "Đinh Bộ Lĩnh", "Ngô Quyền", "Lý Nam Đế"}, 3));
                questions.add(new Question("Việt Nâm hoàn toàn giải phóng năm nào?", new String[]{"1945", "1952", "1972", "1979"}, 2));
            } else if (ths == 5) {
                questions.add(new Question("Đâu là 1 trong 4 con rồng kinh tế của châu á?", new String[]{"Việt Nam", "Trung Quốc", "Hong Kong", "Nhật Bản"}, 2));
                questions.add(new Question("Đồng tiền nước nào có giá trị cao nhất thế giới??", new String[]{"Mỹ", "Anh", "Kuwait", "Nhật"}, 2));
                questions.add(new Question("Đâu là trung tâm tài chính thế giới ?", new String[]{"Hong Kong", "Đài loan", "New York", "Wasington"}, 2));
            } else if (ths == 6) {
                questions.add(new Question("Đâu là nước có nền kinh tế phát triển nhất thế giới?", new String[]{"Mỹ", "Đức", "Trung Quốc", "Nhật Bản"}, 0));
                questions.add(new Question("Việt Nam có nền kinh tế phát triển thứ mấy Đông Nam Á?", new String[]{"1", "2", "3", "4"}, 3));
                questions.add(new Question("Đâu là ti phú giàu nhất Thế Giới?", new String[]{"Elon Musk", "Jeff Bezos", "Bill Gates", "Warren Buffet"}, 3));
            } else if (ths == 7) {
                questions.add(new Question("Bức tranh mona lisa của họa sĩ nào?", new String[]{"Van Gogh", "Manat", "Picasso", "Leonardo da vinci"}, 3));
                questions.add(new Question("Bài hát “Tình ca”- Hoàng Việt nói đến mùa nào trong năm?", new String[]{"Mùa Xuân", "Mùa Hạ", "Mùa Thu", "Mùa Đông"}, 0));
                questions.add(new Question("Lễ hội Canaval là lễ hội nổi tiếng ở quốc gia nào?", new String[]{"Brazil", "Ý", "Pháp", "Anh"}, 0));
            } else {
                questions.add(new Question("Van Gogh là một họa sĩ nước nào?", new String[]{"Ý", "Hà Lan", "Pháp", "Thụy Sĩ"}, 1));
                questions.add(new Question("Bản nhạc sonate ánh trăng là bản nhạc huyền thoại của nghệ sĩ nào?", new String[]{"Beethoven", "Paganini", "Mozart", "Brahms"}, 0));
                questions.add(new Question("Đâu là bộ phim có doanh thu cao nhất mọi thời đại?", new String[]{"Avenger:End Game", "Jurassic World", "Titanic", "Avatar"}, 3));
            }
        }

        else  {
            if (ths1FromM4 == 9) {
                questions.add(new Question("Biểu hiện nào của hiện tượng khí hậu biến đổi toàn cầu đang gây ảnh hưởng lớn nhất đến đại dương?", new String[]{"Tăng mực nước biển", "Hiện tượng El Niño", "Sự phân hóa nước biển", "Tăng cường tác động của sóng"}, 0));
                questions.add(new Question("Khu vực nào trên thế giới chịu ảnh hưởng nặng nề từ hiện tượng ô nhiễm không khí?", new String[]{"Scandinavia", "Amazon", "Ruhr Valley", "Himalaya"}, 2));
                questions.add(new Question("Đặc điểm nào của sa mạc châu Phi làm nó trở thành một trong những môi trường khắc nghiệt nhất trên Trái Đất?", new String[]{"Thực vật xanh quanh năm", "Nhiệt độ cao và khô(đúng)", "Lượng mưa hàng năm lớn", "Đất màu đỏ chứa nhiều dưỡng"}, 3));
            } else if (ths1FromM4 == 10) {
                questions.add(new Question("Dòng sông nào là con sông dài nhất thế giới?", new String[]{"Sông Nile", "Sông Amazon(đúng)", "Sông Mekong", "Sông Mississippi"}, 1));
                questions.add(new Question("Thành phố nào được biết đến với tên gọi Thủ đô ánh sáng?", new String[]{"Paris", "New York", "Tokyo", "Seoul"}, 2));
                questions.add(new Question("Dãy núi nào tạo thành ranh giới tự nhiên giữa châu Âu và châu Á?", new String[]{"Dãy Alps", "Dãy Ural", "Dãy Carpathian", "Dãy Andes"}, 1));
            } else if (ths1FromM4 == 11) {
                questions.add(new Question("Sự kiện nào đã đánh dấu sự kết thúc của Chiến tranh thế giới thứ nhất?", new String[]{"Hiệp ước Versailles", "Hiệp ước Munich", "Hiệp ước Rapallo", "Hiệp ước Trianon"}, 0));
                questions.add(new Question("Ai là người đầu tiên đặt chân lên Mặt Trăng?", new String[]{"Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "John Glenn"}, 1));
                questions.add(new Question("Sự kiện nào đã gắn liền với câu nói Let them eat cake Hãy để họ ăn bánh?", new String[]{"Cách mạng Pháp", "Chiến tranh thế giới thứ nhất", "Cuộc Cách mạng Nga", "Nội chiến Hoa Kỳ"}, 0));
            } else if (ths1FromM4 == 12) {
                questions.add(new Question("Năm 1492, Christopher Columbus khám phá ra đất nước nào?", new String[]{"India", "China", "Mỹ", "Nga"}, 2));
                questions.add(new Question("Ai là người đứng đầu của Đồng minh trong Thế chiến II?", new String[]{"Adolf Hitler", "Winston Churchill", "Joseph Stalin", "Franklin D. Roosevelt"}, 1));
                questions.add(new Question("Cuộc Cách mạng Công nghiệp bắt đầu ở quốc gia nào?", new String[]{"Anh", "Pháp", "Đức", "Mỹ"}, 0));
            } else if (ths1FromM4 == 13) {
                questions.add(new Question("Khái niệm Quantitative Easing (Giãn cách Số liệu) liên quan đến phương thức nào của ngân hàng trung ương để duy trì nền kinh tế?", new String[]{"Tăng lãi suất", "Giảm cung tiền tệ", "Tăng cung tiền tệ", "Giảm lãi suất"}, 2));
                questions.add(new Question("Khái niệm \"Ponzi Scheme\" (Kế hoạch Ponzi) liên quan đến gì trong lĩnh vực tài chính?", new String[]{"Quảng cáo và tiếp thị", "Giao dịch chứng khoán", "Thuế thu nhập cá nhân", "Chiến lược đầu tư giao dịch hối đoái"}, 0));
                questions.add(new Question("Đồng tiền ảo nào được sử dụng như một phương tiện thanh toán trong thương mại quốc tế và không thuộc quy định của bất kỳ quốc gia nào?", new String[]{"Bitcoin", "Ethereum", "Ripple", "Litecoin"}, 0));
            } else if (ths1FromM4 == 14) {
                questions.add(new Question("Khái niệm \"lãi suất\" trong tài chính được định nghĩa như thế nào?", new String[]{"Phí mở tài khoản ngân hàng", "Tỉ lệ giữa thu nhập và chi phí", "Phần trăm tiền lãi hàng năm", "Giá trị của một đồng tiền"}, 2));
                questions.add(new Question("Định nghĩa \"chứng khoán\" là gì trong ngữ cảnh tài chính?", new String[]{"Chứng chỉ khen ngợi từ ngân hàng", "Tài sản có thể chuyển đổi thành tiền mặt", "Giấy tờ chứng minh nhân dân", "Chứng chỉ biểu hiện quyền sở hữu trong công ty"}, 3));
                questions.add(new Question("Thu nhập chủ yếu của chính phủ đến từ đâu?", new String[]{"Tiền thuế thu nhập cá nhân", "Doanh thu từ bán dầu", "Thuế VAT (Thuế giá trị gia tăng)", "Tiền phạt giao thông"}, 2));
            } else if (ths1FromM4 == 15) {
                questions.add(new Question("Làm thế nào nghệ sĩ có thể truyền đạt cảm xúc sâu sắc và phức tạp thông qua tác phẩm của mình?", new String[]{"Sử dụng màu sắc đa dạng", "Tạo ra hình ảnh đơn giản", "Tránh sự phức tạp", "Sử dụng chỉ một loại chất liệu"}, 0));
                questions.add(new Question("Làm thế nào nghệ sĩ có thể thách thức quan điểm truyền thống và tạo ra điều mới mẻ, độc đáo trong nghệ thuật của họ?", new String[]{"Tuân theo quy tắc cũ", "Sử dụng phong cách cổ điển", "Đổi mới và tìm kiếm sự độc đáo", "Giữ nguyên quy tắc truyền thống"}, 2));
                questions.add(new Question("Tại sao một số tác phẩm nghệ thuật được đánh giá cao, trong khi những tác phẩm khác với chất lượng tương đương lại không được công nhận?", new String[]{"Do sự may mắn", "Ảnh hưởng của quảng bá", "Sự độc đáo và sáng tạo", "Tuân theo nguyên tắc truyền thống"}, 2));
            } else if(ths1FromM4 == 16)  {
                questions.add(new Question("Nghệ thuật có thể là một phương tiện hiệu quả để thể hiện và chia sẻ cảm xúc. Bạn nghĩ sao về điều này?", new String[]{"Không liên quan", "Đồng ý", "Chưa rõ", "Phản đối"}, 1));
                questions.add(new Question("Làm thế nào nghệ sĩ có thể sử dụng màu sắc và ánh sáng để tạo ra ảnh hưởng tích cực trong tác phẩm của họ?", new String[]{"Tránh sử dụng màu sắc", "Tăng cường ánh sáng mạnh mẽ", "Sử dụng màu sắc phù hợp", "Chỉ sử dụng màu đen trắng"}, 2));
                questions.add(new Question("Bạn có thể mô tả sự khác biệt giữa nghệ thuật truyền thống và nghệ thuật hiện đại, và cái nào bạn thích hơn? Tại sao?", new String[]{"Không có sự khác biệt", "Nghệ thuật hiện đại táo bạo hơn", "Nghệ thuật truyền thống tốt hơn", "Cả hai đều có nhược điểm"}, 1));
            }
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
            tmp++;
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("tmp", tmp);
            intent.putExtra("thsFromM3", ths1);
            intent.putExtra("count", countRightAnswer);
            startActivity(intent);


        }
    }

    private void checkAnswer() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        int selectedAnswerIndex = answerRadioGroup.indexOfChild(findViewById(answerRadioGroup.getCheckedRadioButtonId()));

        if (selectedAnswerIndex == currentQuestion.getCorrectAnswerIndex()) {

                countRightAnswer++;



            // Chuyển sang câu hỏi tiếp theo nếu trả lời đúng

            currentQuestionIndex++;
            answerRadioGroup.clearCheck();
            displayQuestion(currentQuestionIndex);

        } else {
            // Hiển thị màn hình 4 nếu trả lời sai
            tmp++;
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("tmp", tmp);
            intent.putExtra("thsFromM3", ths1);
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
