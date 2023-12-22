package com.example.sharedpreferences;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChuDeAdapter extends BaseAdapter {

    private ArrayList<ChuDe> danhSachChuDe;

    public ChuDeAdapter(ArrayList<ChuDe> danhSachChuDe) {this.danhSachChuDe = danhSachChuDe; }

    public ArrayList<ChuDe> getDanhSachChuDe() {
        return danhSachChuDe;
    }

    public void setDanhSachChuDe(ArrayList<ChuDe> danhSachChuDe) {
        this.danhSachChuDe = danhSachChuDe;
    }


    @Override
    public int getCount() {
        return danhSachChuDe.size();
    }

    @Override
    public Object getItem(int position) {
        return danhSachChuDe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return danhSachChuDe.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View viewItem;
        if(view==null)viewItem =View.inflate(viewGroup.getContext(), R.layout.activitymain2_1, null);
        else viewItem =view;
        ChuDe chuDe = danhSachChuDe.get(i);
        //ten chu de

        ImageView img_palace =viewItem.findViewById(R.id.product_image);
        img_palace.setImageResource(chuDe.getImage());

        ((TextView) viewItem.findViewById(R.id.product_name)).setText(chuDe.getTenChuDe());
        ((TextView) viewItem.findViewById(R.id.product_gt)).setText(chuDe.getChiTiet());

      
        return viewItem;
    }
}
