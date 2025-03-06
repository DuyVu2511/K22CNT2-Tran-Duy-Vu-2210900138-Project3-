package com.tdv.model;

public class HoaDon {
    private int maHoaDon;
    private String ngayLap;
    private double tongTien;

    public HoaDon() {}

    public HoaDon(int maHoaDon, String ngayLap, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
