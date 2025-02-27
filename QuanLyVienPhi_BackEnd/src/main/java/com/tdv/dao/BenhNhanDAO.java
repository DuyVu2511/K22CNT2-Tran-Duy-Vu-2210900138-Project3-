package com.tdv.dao;

import com.tdv.model.BenhNhan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BenhNhanDAO {
    private JdbcTemplate jdbcTemplate;

    // Setter để Spring tiêm dữ liệu
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lấy danh sách bệnh nhân
    public List<BenhNhan> getAllBenhNhan() {
        String sql = "SELECT * FROM TDV_BenhNhan";
        return jdbcTemplate.query(sql, new RowMapper<BenhNhan>() {
            @Override
            public BenhNhan mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new BenhNhan(
                    rs.getInt("TDV_MaBenhNhan"),
                    rs.getString("TDV_HoTen"),
                    rs.getDate("TDV_NgaySinh"),
                    rs.getString("TDV_GioiTinh"),
                    rs.getString("TDV_CMND_CCCD"),
                    rs.getString("TDV_SoDienThoai"),
                    rs.getString("TDV_DiaChi"),
                    rs.getString("TDV_MaBaoHiem"),
                    rs.getDate("TDV_NgayTao")
                );
            }
        });
    }

    // Lấy thông tin bệnh nhân theo ID
    public BenhNhan getBenhNhanById(int id) {
        String sql = "SELECT * FROM TDV_BenhNhan WHERE TDV_MaBenhNhan = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<BenhNhan>() {
            @Override
            public BenhNhan mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new BenhNhan(
                    rs.getInt("TDV_MaBenhNhan"),
                    rs.getString("TDV_HoTen"),
                    rs.getDate("TDV_NgaySinh"),
                    rs.getString("TDV_GioiTinh"),
                    rs.getString("TDV_CMND_CCCD"),
                    rs.getString("TDV_SoDienThoai"),
                    rs.getString("TDV_DiaChi"),
                    rs.getString("TDV_MaBaoHiem"),
                    rs.getDate("TDV_NgayTao")
                );
            }
        });
    }

    // Lưu bệnh nhân mới
    public int save(BenhNhan benhNhan) {
        String sql = "INSERT INTO TDV_BenhNhan (TDV_HoTen, TDV_NgaySinh, TDV_GioiTinh, TDV_CMND_CCCD, " +
                     "TDV_SoDienThoai, TDV_DiaChi, TDV_MaBaoHiem, TDV_NgayTao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, benhNhan.getHoTen(), benhNhan.getNgaySinh(), benhNhan.getGioiTinh(),
                                   benhNhan.getCmndCccd(), benhNhan.getSoDienThoai(), benhNhan.getDiaChi(),
                                   benhNhan.getMaBaoHiem(), benhNhan.getNgayTao());
    }

    // Cập nhật thông tin bệnh nhân
    public int update(BenhNhan benhNhan) {
        String sql = "UPDATE TDV_BenhNhan SET TDV_HoTen = ?, TDV_NgaySinh = ?, TDV_GioiTinh = ?, " +
                     "TDV_CMND_CCCD = ?, TDV_SoDienThoai = ?, TDV_DiaChi = ?, TDV_MaBaoHiem = ? " +
                     "WHERE TDV_MaBenhNhan = ?";
        return jdbcTemplate.update(sql, benhNhan.getHoTen(), benhNhan.getNgaySinh(), benhNhan.getGioiTinh(),
                                   benhNhan.getCmndCccd(), benhNhan.getSoDienThoai(), benhNhan.getDiaChi(),
                                   benhNhan.getMaBaoHiem(), benhNhan.getMaBenhNhan());
    }

    // Xóa bệnh nhân theo ID
    public int delete(int id) {
        String sql = "DELETE FROM TDV_BenhNhan WHERE TDV_MaBenhNhan = ?";
        return jdbcTemplate.update(sql, id);
    }
}
