package com.tdv.model;

public class HoaDon {
    private int maHoaDon;
    private int maHoSo;
    private String ngayLap;
    private double tongTien;

    public HoaDon() {}

    public HoaDon(int maHoaDon, int maHoSo, String ngayLap, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maHoSo = maHoSo;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(int maHoSo) {
        this.maHoSo = maHoSo;
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
