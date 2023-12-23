package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
    private static final String KEY_CHU_DE = "Chu_de";
    private static final String[] PRODUCTS = {"Địa lý", "Lịch sử", "Tài chính", "Nghệ thuật"};

    private ArrayList<Question> questionList;
    private ListView questionListView;

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
        autoCompleteChuDe.post(() -> autoCompleteChuDe.showDropDown());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, PRODUCTS);

        autoCompleteChuDe.setAdapter(adapter);
        autoCompleteChuDe.setThreshold(0); // Đặt ngưỡng tìm kiếm xuống 0

        // Thêm TextWatcher để theo dõi sự thay đổi trong AutoCompleteTextView
        autoCompleteChuDe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Nếu bạn muốn thực hiện các hành động trước khi văn bản thay đổi
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Gọi phương thức để cập nhật danh sách hiển thị dựa trên từ khóa tìm kiếm
                updateQuestionList(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Nếu bạn muốn thực hiện các hành động sau khi văn bản đã thay đổi
            }
        });
    }

    private void initializeQuestionList() {
        // Các câu hỏi đã được khởi tạo ở đây
        questionList = new ArrayList<>();
        questionList.add(new Question("Địa lý","khó",1,"Quần Đảo Hoàng Sa thuộc tỉnh/ tp nào?", "Đà Nẵng", "Nha Trang", "Phan Thiết", "Hải Phòng","Đà Nẵng"));
        questionList.add(new Question("Địa lý","khó",2,"Việt Nam có bao nhiêu dân tộc thiểu số?", "51", "53", "54", "55","54"));
        questionList.add(new Question("Địa lý","khó",3,"Cột mốc biên giới Việt Nam - Lào- Campuchia ở đâu?", "Hà Giang", "Điện Biên", "Kon Tum", "Lào Cai","Kon Tum"));
        questionList.add(new Question("Địa lý","dễ",4,"Hang động lớn nhất Việt Nam?","Phong Nha- Kẻ Bàng", "Sơn Đòong", "Hang Én", "Tràng An","Sơn Đòong"));
        questionList.add(new Question("Địa lý","dễ",5,"Giờ Việt Nam theo múi giờ nào?", "GMT+7", "GMT+8", "GMT+11", "GMT+12","GMT+7"));
        questionList.add(new Question("Địa lý","dễ",6,"Vịnh nào Việt Nam lot top 7 kỳ quan thế giới?","Cát Bà", "Côtô", "Hạ Long", "Lan Hạ","Lan Hạ"));
        questionList.add(new Question("Lịch sử","khó",7,"Trong lịch sử, Nhà Trần đã 3 lần đánh thắng quân xâm lược nào?", "Nam Hán", "Nhà Thanh", "Nhà Tần", "Mông Nguyên","Nhà Tần"));
        questionList.add(new Question("Lịch sử","khó",8,"Quốc hiệu Việt Nam dưới thời nhà Hồ?", "Đại Ngu", "Đại Việt", "Văn Lang", "Âu Lac","Đại Ngu"));
        questionList.add(new Question("Lịch sử","khó",9,"Vị vua cuối cùng của chế độ quân chủ", "Gia Long", "Bảo Đại", "Duy Tân", "Hàm Nghi","Bảo Đại"));
        questionList.add(new Question("Lịch sử","dễ",10,"Chiến dịch Điện Biên Phủ kéo dài bao nhiêu ngày đêm?", "48", "49", "56", "57","56"));
        questionList.add(new Question("Lịch sử","dễ",11,"Ai là hoàng đế đầu tiên của Việt Nam?", "Vua Hùng", "Đinh Bộ Lĩnh", "Ngô Quyền", "Lý Nam Đế","Lý Nam Đế"));
        questionList.add(new Question("Lịch sử","dễ",12,"Việt Nâm hoàn toàn giải phóng năm nào?", "1945", "1952", "1972", "1979","1972"));
        questionList.add(new Question("Tài chính","khó",13,"Đâu là 1 trong 4 con rồng kinh tế của châu á?", "Việt Nam", "Trung Quốc", "Hong Kong", "Nhật Bản","Hong Kong"));
        questionList.add(new Question("Tài chính","khó",14,"Đồng tiền nước nào có giá trị cao nhất thế giới??","Mỹ", "Anh", "Kuwait", "Nhật","Kuwait"));
        questionList.add(new Question("Tài chính","khó",15,"Đâu là trung tâm tài chính thế giới ?", "Hong Kong", "Đài loan", "New York", "Wasington","New York"));
        questionList.add(new Question("Tài chính","dễ",16,"Đâu là nước có nền kinh tế phát triển nhất thế giới?", "Mỹ", "Đức", "Trung Quốc", "Nhật Bản","Mỹ"));
        questionList.add(new Question("Tài chính","dễ",17,"Việt Nam có nền kinh tế phát triển thứ mấy Đông Nam Á?", "1", "2", "3", "4","4"));
        questionList.add(new Question("Tài chính","dễ",18,"Đâu là ti phú giàu nhất Thế Giới?", "Elon Musk", "Jeff Bezos", "Bill Gates", "Warren Buffet","Warren Buffet"));
        questionList.add(new Question("Nghệ thuật","khó",19,"Bức tranh mona lisa của họa sĩ nào?", "Van Gogh", "Manat", "Picasso", "Leonardo da vinci","Leonardo da vinci"));
        questionList.add(new Question("Nghệ thuật","khó",20,"Bài hát “Tình ca”- Hoàng Việt nói đến mùa nào trong năm?", "Mùa Xuân", "Mùa Hạ", "Mùa Thu", "Mùa Đông","Mùa Xuân"));
        questionList.add(new Question("Nghệ thuật","khó",21,"Lễ hội Canaval là lễ hội nổi tiếng ở quốc gia nào?", "Brazil", "Ý", "Pháp", "Anh","Brazil"));
        questionList.add(new Question("Nghệ thuật","dễ",22,"Van Gogh là một họa sĩ nước nào?", "Ý", "Hà Lan", "Pháp", "Thụy Sĩ","Warren Buffet"));
        questionList.add(new Question("Nghệ thuật","dễ",23,"Bản nhạc sonate là bản nhạc huyền thoại của nghệ sĩ nào?", "Beethoven", "Paganini", "Mozart", "Brahms","Beethoven"));
        questionList.add(new Question("Nghệ thuật","dễ",24,"Đâu là bộ phim có doanh thu cao nhất mọi thời đại?", "Avenger:End Game", "Jurassic World", "Titanic", "Avatar","Avatar"));


    }

    private void setupQuestionListView() {
        questionListView = findViewById(R.id.listQuestion);
        questionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Question selectedQuestion = questionList.get(position);

                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                intent.putExtra("cauhoi", selectedQuestion.getQuestion());
                intent.putExtra("dokho","Độ khó: " + selectedQuestion.getDo_kho());
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

    private void updateQuestionList(String keyword) {
        ArrayList<Question> filteredList = new ArrayList<>();

        if (keyword.isEmpty()) {
            // Hiển thị toàn bộ danh sách khi không có từ khóa tìm kiếm
            filteredList.addAll(questionList);
        } else {
            // Lọc danh sách theo từ khóa tìm kiếm
            for (Question question : questionList) {
                if (question.getChu_de().toLowerCase().contains(keyword.toLowerCase())) {
                    filteredList.add(question);
                }
            }
        }

        // Cập nhật danh sách hiển thị
        LQuestionAdapter questionAdapter = new LQuestionAdapter(filteredList);
        questionListView.setAdapter(questionAdapter);
    }
}
