package com.example.sharedpreferences;

public class ChuDe {

    private int image;
    private String tenChuDe;

    private String chiTiet;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public ChuDe(int image, String tenChuDe, String chiTiet) {
        this.image = image;
        this.tenChuDe = tenChuDe;
        this.chiTiet = chiTiet;
    }
}
