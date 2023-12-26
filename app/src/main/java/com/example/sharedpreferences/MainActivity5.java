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
        questionList.add(new Question("Địa lý","khó",2,"Biểu hiện nào của hiện tượng khí hậu biến đổi toàn cầu đang gây ảnh hưởng lớn nhất đến đại dương?", "Tăng mực nước biển", "Hiện tượng El Niño", "Sự phân hóa nước biển", "Tăng cường tác động của sóng","Tăng mực nước biển"));
        questionList.add(new Question("Địa lý","khó",3,"Khu vực nào trên thế giới chịu ảnh hưởng nặng nề từ hiện tượng ô nhiễm không khí?", "Scandinavia", "Amazon", "Ruhr Valley", "Himalaya","Ruhr Valley"));
        questionList.add(new Question("Địa lý","khó",4,"Đặc điểm nào của sa mạc châu Phi làm nó trở thành một trong những môi trường khắc nghiệt nhất trên Trái Đất?","Thực vật xanh quanh năm", "Nhiệt độ cao và khô", "Lượng mưa hàng năm lớn", "Đất màu đỏ chứa nhiều dưỡng","Đất màu đỏ chứa nhiều dưỡng"));
        questionList.add(new Question("Địa lý","khó",5,"Việt Nam có bao nhiêu dân tộc thiểu số?", "51", "53", "54", "55","54"));
        questionList.add(new Question("Địa lý","khó",6,"Cột mốc biên giới Việt Nam - Lào- Campuchia ở đâu?", "Hà Giang", "Điện Biên", "Kon Tum", "Lào Cai","Kon Tum"));



        questionList.add(new Question("Địa lý","dễ",7,"Hang động lớn nhất Việt Nam?","Phong Nha- Kẻ Bàng", "Sơn Đòong", "Hang Én", "Tràng An","Sơn Đòong"));
        questionList.add(new Question("Địa lý","dễ",8,"Giờ Việt Nam theo múi giờ nào?", "GMT+7", "GMT+8", "GMT+11", "GMT+12","GMT+7"));
        questionList.add(new Question("Địa lý","dễ",9,"Vịnh nào Việt Nam lot top 7 kỳ quan thế giới?","Cát Bà", "Côtô", "Hạ Long", "Lan Hạ","Hạ Long"));

        questionList.add(new Question("Địa lý","dễ",10,"Dòng sông nào là con sông dài nhất thế giới?", "Sông Nile", "Sông Amazon", "Sông Mekong", "Sông Mississippi","Sông Nile"));
        questionList.add(new Question("Địa lý","dễ",11,"Thành phố nào được biết đến với tên gọi Thủ đô ánh sáng?", "Paris", "New York", "Tokyo", "Seoul","Paris"));
        questionList.add(new Question("Địa lý","dễ",12,"Dãy núi nào tạo thành ranh giới tự nhiên giữa châu Âu và châu Á?", "Dãy Alps", "Dãy Ural", "Dãy Carpathian", "Dãy Andes","Dãy Ural"));



        questionList.add(new Question("Lịch sử","khó",13,"Trong lịch sử, Nhà Trần đã 3 lần đánh thắng quân xâm lược nào?", "Nam Hán", "Nhà Thanh", "Nhà Tần", "Mông Nguyên","Nhà Tần"));
        questionList.add(new Question("Lịch sử","khó",14,"Quốc hiệu Việt Nam dưới thời nhà Hồ?", "Đại Ngu", "Đại Việt", "Văn Lang", "Âu Lac","Đại Ngu"));
        questionList.add(new Question("Lịch sử","khó",15,"Vị vua cuối cùng của chế độ quân chủ", "Gia Long", "Bảo Đại", "Duy Tân", "Hàm Nghi","Bảo Đại"));

        questionList.add(new Question("Lịch sử","khó",16,"Sự kiện nào đã đánh dấu sự kết thúc của Chiến tranh thế giới thứ nhất?","Hiệp ước Versailles", "Hiệp ước Munich", "Hiệp ước Rapallo", "Hiệp ước Trianon","Hiệp ước Versailles"));
        questionList.add(new Question("Lịch sử","khó",17,"Ai là người đầu tiên đặt chân lên Mặt Trăng?", "Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "John Glenn","Neil Armstrong"));
        questionList.add(new Question("Lịch sử","khó",18,"Sự kiện nào đã gắn liền với câu nói Let them eat cake Hãy để họ ăn bánh?", "Cách mạng Pháp", "Chiến tranh thế giới thứ nhất", "Cuộc Cách mạng Nga", "Nội chiến Hoa Kỳ","Cách mạng Pháp"));



        questionList.add(new Question("Lịch sử","dễ",19,"Chiến dịch Điện Biên Phủ kéo dài bao nhiêu ngày đêm?", "48", "49", "56", "57","56"));
        questionList.add(new Question("Lịch sử","dễ",20,"Ai là hoàng đế đầu tiên của Việt Nam?", "Vua Hùng", "Đinh Bộ Lĩnh", "Ngô Quyền", "Lý Nam Đế","Lý Nam Đế"));
        questionList.add(new Question("Lịch sử","dễ",21,"Việt Nâm hoàn toàn giải phóng năm nào?", "1945", "1952", "1972", "1979","1972"));

        questionList.add(new Question("Lịch sử","dễ",22,"Năm 1492, Christopher Columbus khám phá ra đất nước nào?", "India", "China", "Mỹ", "Nga","Mỹ"));
        questionList.add(new Question("Lịch sử","dễ",23,"Ai là người đứng đầu của Đồng minh trong Thế chiến II?", "Adolf Hitler", "Winston Churchill", "Joseph Stalin", "Franklin D. Roosevelt","Winston Churchill"));
        questionList.add(new Question("Lịch sử","dễ",24,"Cuộc Cách mạng Công nghiệp bắt đầu ở quốc gia nào?", "Anh", "Pháp", "Đức", "Mỹ","Anh"));


        questionList.add(new Question("Tài chính","khó",25,"Đâu là 1 trong 4 con rồng kinh tế của châu á?", "Việt Nam", "Trung Quốc", "Hong Kong", "Nhật Bản","Hong Kong"));
        questionList.add(new Question("Tài chính","khó",26,"Đồng tiền nước nào có giá trị cao nhất thế giới??","Mỹ", "Anh", "Kuwait", "Nhật","Kuwait"));
        questionList.add(new Question("Tài chính","khó",27,"Đâu là trung tâm tài chính thế giới ?", "Hong Kong", "Đài loan", "New York", "Wasington","New York"));

        questionList.add(new Question("Tài chính","khó",28,"Khái niệm Quantitative Easing (Giãn cách Số liệu) liên quan đến phương thức nào của ngân hàng trung ương để duy trì nền kinh tế?","Tăng lãi suất", "Giảm cung tiền tệ", "Tăng cung tiền tệ", "Giảm lãi suất","Tăng cung tiền tệ"));
        questionList.add(new Question("Tài chính","khó",29,"Khái niệm \"Ponzi Scheme\" (Kế hoạch Ponzi) liên quan đến gì trong lĩnh vực tài chính?","Quảng cáo và tiếp thị", "Giao dịch chứng khoán", "Thuế thu nhập cá nhân", "Chiến lược đầu tư giao dịch hối đoái","Quảng cáo và tiếp thị"));
        questionList.add(new Question("Tài chính","khó",30,"Đồng tiền ảo nào được sử dụng như một phương tiện thanh toán trong thương mại quốc tế và không thuộc quy định của bất kỳ quốc gia nào?", "Bitcoin", "Ethereum", "Ripple", "Litecoin","Bitcoin"));



        questionList.add(new Question("Tài chính","dễ",31,"Đâu là nước có nền kinh tế phát triển nhất thế giới?", "Mỹ", "Đức", "Trung Quốc", "Nhật Bản","Mỹ"));
        questionList.add(new Question("Tài chính","dễ",32,"Việt Nam có nền kinh tế phát triển thứ mấy Đông Nam Á?", "1", "2", "3", "4","4"));
        questionList.add(new Question("Tài chính","dễ",33,"Đâu là ti phú giàu nhất Thế Giới?", "Elon Musk", "Jeff Bezos", "Bill Gates", "Warren Buffet","Elon Musk"));

        questionList.add(new Question("Tài chính","dễ",34,"Khái niệm \"lãi suất\" trong tài chính được định nghĩa như thế nào?", "Phí mở tài khoản ngân hàng", "Tỉ lệ giữa thu nhập và chi phí", "Phần trăm tiền lãi hàng năm", "Giá trị của một đồng tiền","Phần trăm tiền lãi hàng năm"));
        questionList.add(new Question("Tài chính","dễ",35,"Định nghĩa \"chứng khoán\" là gì trong ngữ cảnh tài chính?", "Chứng chỉ khen ngợi từ ngân hàng", "Tài sản có thể chuyển đổi thành tiền mặt", "Giấy tờ chứng minh nhân dân", "Chứng chỉ biểu hiện quyền sở hữu trong công ty","Chứng chỉ biểu hiện quyền sở hữu trong công ty"));
        questionList.add(new Question("Tài chính","dễ",36,"Thu nhập chủ yếu của chính phủ đến từ đâu?", "Tiền thuế thu nhập cá nhân", "Doanh thu từ bán dầu", "Thuế VAT (Thuế giá trị gia tăng)", "Tiền phạt giao thông","Doanh thu từ bán dầu"));



        questionList.add(new Question("Nghệ thuật","khó",37,"Bức tranh mona lisa của họa sĩ nào?", "Van Gogh", "Manat", "Picasso", "Leonardo da vinci","Leonardo da vinci"));
        questionList.add(new Question("Nghệ thuật","khó",38,"Bài hát “Tình ca”- Hoàng Việt nói đến mùa nào trong năm?", "Mùa Xuân", "Mùa Hạ", "Mùa Thu", "Mùa Đông","Mùa Xuân"));
        questionList.add(new Question("Nghệ thuật","khó",39,"Lễ hội Canaval là lễ hội nổi tiếng ở quốc gia nào?", "Brazil", "Ý", "Pháp", "Anh","Brazil"));

        questionList.add(new Question("Nghệ thuật","khó",40,"Làm thế nào nghệ sĩ có thể truyền đạt cảm xúc sâu sắc và phức tạp thông qua tác phẩm của mình?", "Sử dụng màu sắc đa dạng", "Tạo ra hình ảnh đơn giản", "Tránh sự phức tạp", "Sử dụng chỉ một loại chất liệu","Sử dụng màu sắc đa dạng"));
        questionList.add(new Question("Nghệ thuật","khó",41,"Làm thế nào nghệ sĩ có thể thách thức quan điểm truyền thống và tạo ra điều mới mẻ, độc đáo trong nghệ thuật của họ?", "Tuân theo quy tắc cũ", "Sử dụng phong cách cổ điển", "Đổi mới và tìm kiếm sự độc đáo", "Giữ nguyên quy tắc truyền thống","Sử dụng phong cách cổ điển"));
        questionList.add(new Question("Nghệ thuật","khó",42,"Tại sao một số tác phẩm nghệ thuật được đánh giá cao, trong khi những tác phẩm khác với chất lượng tương đương lại không được công nhận?", "Do sự may mắn", "Ảnh hưởng của quảng bá", "Sự độc đáo và sáng tạo", "Tuân theo nguyên tắc truyền thống","Sự độc đáo và sáng tạo"));


        questionList.add(new Question("Nghệ thuật","dễ",43,"Van Gogh là một họa sĩ nước nào?", "Ý", "Hà Lan", "Pháp", "Thụy Sĩ","Warren Buffet"));
        questionList.add(new Question("Nghệ thuật","dễ",44,"Bản nhạc sonate là bản nhạc huyền thoại của nghệ sĩ nào?", "Beethoven", "Paganini", "Mozart", "Brahms","Beethoven"));
        questionList.add(new Question("Nghệ thuật","dễ",45,"Đâu là bộ phim có doanh thu cao nhất mọi thời đại?", "Avenger:End Game", "Jurassic World", "Titanic", "Avatar","Avatar"));

        questionList.add(new Question("Nghệ thuật","dễ",46,"Nghệ thuật có thể là một phương tiện hiệu quả để thể hiện và chia sẻ cảm xúc. Bạn nghĩ sao về điều này?", "Không liên quan", "Đồng ý", "Chưa rõ", "Phản đối","Đồng ý"));
        questionList.add(new Question("Nghệ thuật","dễ",47,"Làm thế nào nghệ sĩ có thể sử dụng màu sắc và ánh sáng để tạo ra ảnh hưởng tích cực trong tác phẩm của họ?", "Tránh sử dụng màu sắc", "Tăng cường ánh sáng mạnh mẽ", "Sử dụng màu sắc phù hợp", "Chỉ sử dụng màu đen trắng","Sử dụng màu sắc phù hợp"));
        questionList.add(new Question("Nghệ thuật","dễ",48,"Bạn có thể mô tả sự khác biệt giữa nghệ thuật truyền thống và nghệ thuật hiện đại, và cái nào bạn thích hơn? Tại sao?", "Không có sự khác biệt", "Nghệ thuật hiện đại táo bạo hơn", "Nghệ thuật truyền thống tốt hơn", "Cả hai đều có nhược điểm","Nghệ thuật hiện đại táo bạo hơn"));


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
