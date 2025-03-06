package com.tdv.model;

public class DichVu {
    private int maDichVu;
    private String tenDichVu;
    private String moTa;
    private double donGia;
    private String trangThai;

    public DichVu() {}

    public DichVu(int maDichVu, String tenDichVu, String moTa, double donGia, String trangThai) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.moTa = moTa;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public int getMaDichVu() { return maDichVu; }
    public void setMaDichVu(int maDichVu) { this.maDichVu = maDichVu; }

    public String getTenDichVu() { return tenDichVu; }
    public void setTenDichVu(String tenDichVu) { this.tenDichVu = tenDichVu; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}
