package com.tdv.dao;

import com.tdv.model.ChiTietHoaDon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ChiTietHoaDonDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ChiTietHoaDon> getAllChiTietHoaDon() {
        String sql = "SELECT * FROM TDV_ChiTietHoaDon";
        return jdbcTemplate.query(sql, new ChiTietHoaDonRowMapper());
    }

    public ChiTietHoaDon getChiTietHoaDonById(int id) {
        String sql = "SELECT * FROM TDV_ChiTietHoaDon WHERE TDV_MaChiTiet = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ChiTietHoaDonRowMapper());
        } catch (Exception e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }

    public int save(ChiTietHoaDon chiTietHoaDon) {
        String sql = "INSERT INTO TDV_ChiTietHoaDon (TDV_MaHoaDon, TDV_MaDichVu, TDV_SoLuong, TDV_ThanhTien) " +
                     "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
            chiTietHoaDon.getMaHoaDon(),
            chiTietHoaDon.getMaDichVu(),
            chiTietHoaDon.getSoLuong(),
            chiTietHoaDon.getThanhTien()
        );
    }

    public int update(ChiTietHoaDon chiTietHoaDon) {
        String sql = "UPDATE TDV_ChiTietHoaDon SET TDV_MaHoaDon = ?, TDV_MaDichVu = ?, TDV_SoLuong = ?, " +
                     "TDV_ThanhTien = ? WHERE TDV_MaChiTiet = ?";
        return jdbcTemplate.update(sql,
            chiTietHoaDon.getMaHoaDon(),
            chiTietHoaDon.getMaDichVu(),
            chiTietHoaDon.getSoLuong(),
            chiTietHoaDon.getThanhTien(),
            chiTietHoaDon.getMaChiTiet()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM TDV_ChiTietHoaDon WHERE TDV_MaChiTiet = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class ChiTietHoaDonRowMapper implements RowMapper<ChiTietHoaDon> {
        @Override
        public ChiTietHoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ChiTietHoaDon(
                rs.getInt("TDV_MaChiTiet"),
                rs.getInt("TDV_MaHoaDon"),
                rs.getInt("TDV_MaDichVu"),
                rs.getInt("TDV_SoLuong"),
                rs.getDouble("TDV_ThanhTien") // Chuyển về double để đồng bộ với CSDL
            );
        }
    }
}