package com.tdv.dao;

import com.tdv.model.ThanhToan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ThanhToanDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ThanhToan> getAllThanhToan() {
        String sql = "SELECT * FROM TDV_ThanhToan";
        return jdbcTemplate.query(sql, new ThanhToanRowMapper());
    }

    public ThanhToan getThanhToanById(int id) {
        String sql = "SELECT * FROM TDV_ThanhToan WHERE TDV_MaThanhToan = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ThanhToanRowMapper());
        } catch (Exception e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }

    public int save(ThanhToan thanhToan) {
        String sql = "INSERT INTO TDV_ThanhToan (TDV_MaHoaDon, TDV_PhuongThuc, TDV_SoTien, TDV_NgayThanhToan, TDV_GhiChu) " +
                     "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
            thanhToan.getMaHoaDon(),
            thanhToan.getPhuongThuc(),
            thanhToan.getSoTien(),
            thanhToan.getNgayThanhToan(),
            thanhToan.getGhiChu()
        );
    }

    public int update(ThanhToan thanhToan) {
        String sql = "UPDATE TDV_ThanhToan SET TDV_MaHoaDon = ?, TDV_PhuongThuc = ?, TDV_SoTien = ?, " +
                     "TDV_NgayThanhToan = ?, TDV_GhiChu = ? WHERE TDV_MaThanhToan = ?";
        return jdbcTemplate.update(sql,
            thanhToan.getMaHoaDon(),
            thanhToan.getPhuongThuc(),
            thanhToan.getSoTien(),
            thanhToan.getNgayThanhToan(),
            thanhToan.getGhiChu(),
            thanhToan.getMaThanhToan()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM TDV_ThanhToan WHERE TDV_MaThanhToan = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class ThanhToanRowMapper implements RowMapper<ThanhToan> {
        @Override
        public ThanhToan mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ThanhToan(
                rs.getInt("TDV_MaThanhToan"),
                rs.getInt("TDV_MaHoaDon"),
                rs.getString("TDV_PhuongThuc"),
                rs.getDouble("TDV_SoTien"),
                rs.getTimestamp("TDV_NgayThanhToan"),
                rs.getString("TDV_GhiChu")
            );
        }
    }
}