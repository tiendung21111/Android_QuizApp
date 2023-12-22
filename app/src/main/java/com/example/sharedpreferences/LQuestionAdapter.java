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
        View viewItem;//View cua 1 san pham
        if(convertView==null)
            viewItem=  View.inflate(parent.getContext(),R.layout.question_view,null);
        else
            viewItem = convertView;
        Question question = listQuestion.get(position);
        //ten sap pham
        ((TextView)viewItem.findViewById(R.id.chu_de)).setText(question.getChu_de());
//        ((TextView)viewItem.findViewById(R.id.do_kho)).setText(String.valueOf(question.isDo_kho()));
        return viewItem;
    }
}
