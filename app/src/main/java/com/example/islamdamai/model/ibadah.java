package com.example.islamdamai.model;

public class ibadah {

    private String nama, desk;
    private int img;

    public ibadah(String nama, String desk, int img) {
        this.nama = nama;
        this.desk = desk;
        this.img = img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
