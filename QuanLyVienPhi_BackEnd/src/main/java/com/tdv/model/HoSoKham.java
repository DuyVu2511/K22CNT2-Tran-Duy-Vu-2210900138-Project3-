package com.tdv.model;

import java.sql.Timestamp;

public class HoSoKham {
    private int maHoSo;
    private int maBenhNhan;
    private Timestamp ngayKham;
    private String chanDoan;
    private String bacSiDieuTri;
    private boolean trangThai;

    // Constructors
    public HoSoKham() {}

    public HoSoKham(int maHoSo, int maBenhNhan, Timestamp ngayKham, String chanDoan, String bacSiDieuTri, boolean trangThai) {
        this.maHoSo = maHoSo;
        this.maBenhNhan = maBenhNhan;
        this.ngayKham = ngayKham;
        this.chanDoan = chanDoan;
        this.bacSiDieuTri = bacSiDieuTri;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getMaHoSo() { return maHoSo; }
    public void setMaHoSo(int maHoSo) { this.maHoSo = maHoSo; }

    public int getMaBenhNhan() { return maBenhNhan; }
    public void setMaBenhNhan(int maBenhNhan) { this.maBenhNhan = maBenhNhan; }

    public Timestamp getNgayKham() { return ngayKham; }
    public void setNgayKham(Timestamp ngayKham) { this.ngayKham = ngayKham; }

    public String getChanDoan() { return chanDoan; }
    public void setChanDoan(String chanDoan) { this.chanDoan = chanDoan; }

    public String getBacSiDieuTri() { return bacSiDieuTri; }
    public void setBacSiDieuTri(String bacSiDieuTri) { this.bacSiDieuTri = bacSiDieuTri; }

    public boolean getTrangThai() { return trangThai; }
    public void setTrangThai(boolean trangThai) { this.trangThai = trangThai; }

    @Override
    public String toString() {
        return "HoSoKham [maHoSo=" + maHoSo + ", maBenhNhan=" + maBenhNhan + ", ngayKham=" + ngayKham +
               ", chanDoan=" + chanDoan + ", bacSiDieuTri=" + bacSiDieuTri + ", trangThai=" + trangThai + "]";
    }
}