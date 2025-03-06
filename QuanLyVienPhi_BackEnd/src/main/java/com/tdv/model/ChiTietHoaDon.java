package com.tdv.model;

import java.math.BigDecimal;

public class ChiTietHoaDon {
    private int maChiTiet;
    private int maHoaDon;
    private int maDichVu;
    private int soLuong;
    private BigDecimal thanhTien; // Chỉ giữ lại thanhTien

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(int maChiTiet, int maHoaDon, int maDichVu, int soLuong, BigDecimal thanhTien) {
        this.maChiTiet = maChiTiet;
        this.maHoaDon = maHoaDon;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }
}
