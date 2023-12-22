package com.example.sharedpreferences;

import java.util.ArrayList;
import java.util.List;


public class Question {
    private String Chu_de;
    private String do_kho;
    private int id;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;


    private String rightAnswer;

    public Question(String chu_de, String do_kho, int id, String question, String optionA, String optionB, String optionC, String optionD, String rightAnswer) {
        Chu_de = chu_de;
        this.do_kho = do_kho;
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.rightAnswer = rightAnswer;
    }

    public String getChu_de() {
        return Chu_de;
    }

    public void setChu_de(String chu_de) {
        Chu_de = chu_de;
    }

    public String getDo_kho() {
        return do_kho;
    }

    public void setDo_kho(String do_kho) {
        this.do_kho = do_kho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}

