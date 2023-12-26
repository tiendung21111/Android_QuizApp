package com.example.sharedpreferences;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LQuestionAdapter extends BaseAdapter {
    private ArrayList<Question> listQuestion;
    public LQuestionAdapter(ArrayList<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    @Override
    public int getCount() {
        return listQuestion.size();
    }

    @Override
    public Object getItem(int position) {
        return listQuestion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listQuestion.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewItem;//View cua 1 cau hoi
        if(convertView==null)
            viewItem=  View.inflate(parent.getContext(),R.layout.question_view,null);
        else
            viewItem = convertView;
        Question question = listQuestion.get(position);
        //hien thi chu de va do kho cua no
        ((TextView)viewItem.findViewById(R.id.chu_de)).setText(question.getChu_de());
        ((TextView)viewItem.findViewById(R.id.do_kho)).setText(question.getDo_kho());
        ((TextView)viewItem.findViewById(R.id.review_cau_hoi)).setText(question.getQuestion());
        ((TextView)viewItem.findViewById(R.id.stt)).setText("STT: "+ String.valueOf(question.getId()));
        return viewItem;
    }
}
