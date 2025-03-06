package com.tdv.model;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class BenhNhan {
    private int maBenhNhan;
    private String hoTen;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;
    
    private String gioiTinh;
    private String cmndCccd;
    private String soDienThoai;
    private String diaChi;
    private String maBaoHiem;
    private Timestamp ngayTao;

    // Constructors
    public BenhNhan() {}

    public BenhNhan(int maBenhNhan, String hoTen, Date ngaySinh, String gioiTinh, String cmndCccd, 
                    String soDienThoai, String diaChi, String maBaoHiem, Timestamp ngayTao) {
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

    public Timestamp getNgayTao() { return ngayTao; }
    public void setNgayTao(Timestamp ngayTao) { this.ngayTao = ngayTao; }

    @Override
    public String toString() {
        return "BenhNhan [maBenhNhan=" + maBenhNhan + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + 
               ", gioiTinh=" + gioiTinh + ", cmndCccd=" + cmndCccd + ", soDienThoai=" + soDienThoai + 
               ", diaChi=" + diaChi + ", maBaoHiem=" + maBaoHiem + ", ngayTao=" + ngayTao + "]";
    }
}