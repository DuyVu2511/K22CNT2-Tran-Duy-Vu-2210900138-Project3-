package com.tdv.model;

import java.util.Date;

public class ThanhToan {
    private int maThanhToan;
    private int maHoaDon;
    private String phuongThuc;
    private double soTien;
    private Date ngayThanhToan;
    private String ghiChu;

    // Constructors
    public ThanhToan() {}

    public ThanhToan(int maThanhToan, int maHoaDon, String phuongThuc, double soTien, Date ngayThanhToan, String ghiChu) {
        this.maThanhToan = maThanhToan;
        this.maHoaDon = maHoaDon;
        this.phuongThuc = phuongThuc;
        this.soTien = soTien;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
    }

    // Getters and Setters
    public int getMaThanhToan() { return maThanhToan; }
    public void setMaThanhToan(int maThanhToan) { this.maThanhToan = maThanhToan; }

    public int getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(int maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getPhuongThuc() { return phuongThuc; }
    public void setPhuongThuc(String phuongThuc) { this.phuongThuc = phuongThuc; }

    public double getSoTien() { return soTien; }
    public void setSoTien(double soTien) { this.soTien = soTien; }

    public Date getNgayThanhToan() { return ngayThanhToan; }
    public void setNgayThanhToan(Date ngayThanhToan) { this.ngayThanhToan = ngayThanhToan; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

    @Override
    public String toString() {
        return "ThanhToan [maThanhToan=" + maThanhToan + ", maHoaDon=" + maHoaDon + ", phuongThuc=" + phuongThuc +
               ", soTien=" + soTien + ", ngayThanhToan=" + ngayThanhToan + ", ghiChu=" + ghiChu + "]";
    }
}