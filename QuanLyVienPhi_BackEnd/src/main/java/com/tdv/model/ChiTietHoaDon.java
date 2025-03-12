package com.tdv.model;

public class ChiTietHoaDon {
    private int maChiTiet;
    private int maHoaDon;
    private int maDichVu;
    private int soLuong;
    private double thanhTien;

    // Constructors
    public ChiTietHoaDon() {}

    public ChiTietHoaDon(int maChiTiet, int maHoaDon, int maDichVu, int soLuong, double thanhTien) {
        this.maChiTiet = maChiTiet;
        this.maHoaDon = maHoaDon;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    // Getters and Setters
    public int getMaChiTiet() { return maChiTiet; }
    public void setMaChiTiet(int maChiTiet) { this.maChiTiet = maChiTiet; }

    public int getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(int maHoaDon) { this.maHoaDon = maHoaDon; }

    public int getMaDichVu() { return maDichVu; }
    public void setMaDichVu(int maDichVu) { this.maDichVu = maDichVu; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getThanhTien() { return thanhTien; }
    public void setThanhTien(double thanhTien) { this.thanhTien = thanhTien; }

    @Override
    public String toString() {
        return "ChiTietHoaDon [maChiTiet=" + maChiTiet + ", maHoaDon=" + maHoaDon + ", maDichVu=" + maDichVu +
               ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + "]";
    }
}