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
        String sql = "SELECT TDV_MaChiTiet, TDV_MaHoaDon, TDV_MaDichVu, TDV_SoLuong, TDV_ThanhTien FROM TDV_ChiTietHoaDon";
        return jdbcTemplate.query(sql, new ChiTietHoaDonMapper());
    }

    public ChiTietHoaDon getById(int id) {
        String sql = "SELECT TDV_MaChiTiet, TDV_MaHoaDon, TDV_MaDichVu, TDV_SoLuong, TDV_ThanhTien FROM TDV_ChiTietHoaDon WHERE TDV_MaChiTiet = ?";
        return jdbcTemplate.queryForObject(sql, new ChiTietHoaDonMapper(), id);
    }

    public void saveOrUpdate(ChiTietHoaDon chiTiet) {
        if (chiTiet.getMaChiTiet() > 0) {
            String sql = "UPDATE TDV_ChiTietHoaDon SET TDV_MaHoaDon=?, TDV_MaDichVu=?, TDV_SoLuong=?, TDV_ThanhTien=? WHERE TDV_MaChiTiet=?";
            jdbcTemplate.update(sql, chiTiet.getMaHoaDon(), chiTiet.getMaDichVu(), chiTiet.getSoLuong(), chiTiet.getThanhTien(), chiTiet.getMaChiTiet());
        } else {
            String sql = "INSERT INTO TDV_ChiTietHoaDon (TDV_MaHoaDon, TDV_MaDichVu, TDV_SoLuong, TDV_ThanhTien) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, chiTiet.getMaHoaDon(), chiTiet.getMaDichVu(), chiTiet.getSoLuong(), chiTiet.getThanhTien());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TDV_ChiTietHoaDon WHERE TDV_MaChiTiet = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ChiTietHoaDonMapper implements RowMapper<ChiTietHoaDon> {
        @Override
        public ChiTietHoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ChiTietHoaDon(
                rs.getInt("TDV_MaChiTiet"),
                rs.getInt("TDV_MaHoaDon"),
                rs.getInt("TDV_MaDichVu"),
                rs.getInt("TDV_SoLuong"),
                rs.getBigDecimal("TDV_ThanhTien")
            );
        }
    }
}
