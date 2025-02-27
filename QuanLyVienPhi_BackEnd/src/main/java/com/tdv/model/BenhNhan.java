package com.tdv.model;

import java.util.Date;

public class BenhNhan {
    private int maBenhNhan;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String cmndCccd;
    private String soDienThoai;
    private String diaChi;
    private String maBaoHiem;
    private Date ngayTao;

    // Constructors
    public BenhNhan() {}

    public BenhNhan(int maBenhNhan, String hoTen, Date ngaySinh, String gioiTinh, String cmndCccd, 
                    String soDienThoai, String diaChi, String maBaoHiem, Date ngayTao) {
        this.maBenhNhan = maBenhNhan;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmndCccd = cmndCccd;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.maBaoHiem = maBaoHiem;
        this.ngayTao = ngayTao;
    }

    // Getters and Setters
    public int getMaBenhNhan() { return maBenhNhan; }
    public void setMaBenhNhan(int maBenhNhan) { this.maBenhNhan = maBenhNhan; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public String getCmndCccd() { return cmndCccd; }
    public void setCmndCccd(String cmndCccd) { this.cmndCccd = cmndCccd; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getMaBaoHiem() { return maBaoHiem; }
    public void setMaBaoHiem(String maBaoHiem) { this.maBaoHiem = maBaoHiem; }

    public Date getNgayTao() { return ngayTao; }
    public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
}
