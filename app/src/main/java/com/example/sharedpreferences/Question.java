package com.example.sharedpreferences;

public class Question {
    private String Chu_de;
    private boolean do_kho;
    private int id;

    public Question(String chu_de, boolean do_kho, int id) {
        Chu_de = chu_de;
        this.do_kho = do_kho;
        this.id = id;
    }

    public String getChu_de() {
        return Chu_de;
    }

    public void setChu_de(String chu_de) {
        Chu_de = chu_de;
    }

    public boolean isDo_kho() {
        return do_kho;
    }

    public void setDo_kho(boolean do_kho) {
        this.do_kho = do_kho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
