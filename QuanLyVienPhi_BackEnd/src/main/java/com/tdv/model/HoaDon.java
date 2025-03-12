package com.tdv.model;

import java.sql.Timestamp;

public class HoaDon {
    private int maHoaDon;
    private int maBenhNhan;
    private Timestamp ngayLap;
    private double tongTien;
    private double baoHiemHoTro;
    private double soTienPhaiTra;
    private String trangThaiThanhToan;

    // Constructors
    public HoaDon() {}

    public HoaDon(int maHoaDon, int maBenhNhan, Timestamp ngayLap, double tongTien, 
                  double baoHiemHoTro, double soTienPhaiTra, String trangThaiThanhToan) {
        this.maHoaDon = maHoaDon;
        this.maBenhNhan = maBenhNhan;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.baoHiemHoTro = baoHiemHoTro;
        this.soTienPhaiTra = soTienPhaiTra;
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    // Getters and Setters
    public int getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(int maHoaDon) { this.maHoaDon = maHoaDon; }

    public int getMaBenhNhan() { return maBenhNhan; }
    public void setMaBenhNhan(int maBenhNhan) { this.maBenhNhan = maBenhNhan; }

    public Timestamp getNgayLap() { return ngayLap; }
    public void setNgayLap(Timestamp ngayLap) { this.ngayLap = ngayLap; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    public double getBaoHiemHoTro() { return baoHiemHoTro; }
    public void setBaoHiemHoTro(double baoHiemHoTro) { this.baoHiemHoTro = baoHiemHoTro; }

    public double getSoTienPhaiTra() { return soTienPhaiTra; }
    public void setSoTienPhaiTra(double soTienPhaiTra) { this.soTienPhaiTra = soTienPhaiTra; }

    public String getTrangThaiThanhToan() { return trangThaiThanhToan; }
    public void setTrangThaiThanhToan(String trangThaiThanhToan) { this.trangThaiThanhToan = trangThaiThanhToan; }

    @Override
    public String toString() {
        return "HoaDon [maHoaDon=" + maHoaDon + ", maBenhNhan=" + maBenhNhan + ", ngayLap=" + ngayLap +
               ", tongTien=" + tongTien + ", baoHiemHoTro=" + baoHiemHoTro + ", soTienPhaiTra=" + soTienPhaiTra +
               ", trangThaiThanhToan=" + trangThaiThanhToan + "]";
    }
}