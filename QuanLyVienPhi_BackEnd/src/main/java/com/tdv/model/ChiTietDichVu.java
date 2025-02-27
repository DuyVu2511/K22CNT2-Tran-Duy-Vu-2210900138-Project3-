package com.tdv.model;

public class ChiTietDichVu {
    private int maChiTiet;
    private int maHoSo;
    private int maDichVu;
    private int soLuong;
    private double thanhTien;

    // Constructors
    public ChiTietDichVu() {}

    public ChiTietDichVu(int maChiTiet, int maHoSo, int maDichVu, int soLuong, double thanhTien) {
        this.maChiTiet = maChiTiet;
        this.maHoSo = maHoSo;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    // Getters and Setters
    public int getMaChiTiet() { return maChiTiet; }
    public void setMaChiTiet(int maChiTiet) { this.maChiTiet = maChiTiet; }

    public int getMaHoSo() { return maHoSo; }
    public void setMaHoSo(int maHoSo) { this.maHoSo = maHoSo; }

    public int getMaDichVu() { return maDichVu; }
    public void setMaDichVu(int maDichVu) { this.maDichVu = maDichVu; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getThanhTien() { return thanhTien; }
    public void setThanhTien(double thanhTien) { this.thanhTien = thanhTien; }
}
