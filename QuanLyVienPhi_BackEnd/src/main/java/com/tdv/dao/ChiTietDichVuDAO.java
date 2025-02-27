package com.tdv.dao;

import com.tdv.model.ChiTietDichVu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ChiTietDichVuDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ChiTietDichVu> getAllChiTietDichVu() {
        String sql = "SELECT * FROM TDV_ChiTietDichVu";
        return jdbcTemplate.query(sql, new ChiTietDichVuMapper());
    }

    public ChiTietDichVu getById(int id) {
        String sql = "SELECT * FROM TDV_ChiTietDichVu WHERE TDV_MaChiTiet = ?";
        return jdbcTemplate.queryForObject(sql, new ChiTietDichVuMapper(), id);
    }

    public void saveOrUpdate(ChiTietDichVu chiTietDichVu) {
        if (chiTietDichVu.getMaChiTiet() > 0) {
            String sql = "UPDATE TDV_ChiTietDichVu SET TDV_MaHoSo=?, TDV_MaDichVu=?, TDV_SoLuong=?, TDV_ThanhTien=? WHERE TDV_MaChiTiet=?";
            jdbcTemplate.update(sql, chiTietDichVu.getMaHoSo(), chiTietDichVu.getMaDichVu(), chiTietDichVu.getSoLuong(), chiTietDichVu.getThanhTien(), chiTietDichVu.getMaChiTiet());
        } else {
            String sql = "INSERT INTO TDV_ChiTietDichVu (TDV_MaHoSo, TDV_MaDichVu, TDV_SoLuong, TDV_ThanhTien) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, chiTietDichVu.getMaHoSo(), chiTietDichVu.getMaDichVu(), chiTietDichVu.getSoLuong(), chiTietDichVu.getThanhTien());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TDV_ChiTietDichVu WHERE TDV_MaChiTiet = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ChiTietDichVuMapper implements RowMapper<ChiTietDichVu> {
        @Override
        public ChiTietDichVu mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ChiTietDichVu(
                rs.getInt("TDV_MaChiTiet"),
                rs.getInt("TDV_MaHoSo"),
                rs.getInt("TDV_MaDichVu"),
                rs.getInt("TDV_SoLuong"),
                rs.getDouble("TDV_ThanhTien")
            );
        }
    }
}
