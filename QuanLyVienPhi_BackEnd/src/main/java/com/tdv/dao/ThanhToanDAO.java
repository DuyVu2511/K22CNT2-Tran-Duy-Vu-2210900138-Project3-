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
        return jdbcTemplate.query(sql, new ThanhToanMapper());
    }

    public ThanhToan getById(int id) {
        String sql = "SELECT * FROM TDV_ThanhToan WHERE TDV_MaThanhToan = ?";
        return jdbcTemplate.queryForObject(sql, new ThanhToanMapper(), id);
    }

    public void saveOrUpdate(ThanhToan thanhToan) {
        if (thanhToan.getMaThanhToan() > 0) {
            String sql = "UPDATE TDV_ThanhToan SET TDV_MaHoaDon=?, TDV_NgayThanhToan=?, TDV_SoTien=?, TDV_HinhThucThanhToan=? WHERE TDV_MaThanhToan=?";
            jdbcTemplate.update(sql, thanhToan.getMaHoaDon(), thanhToan.getNgayThanhToan(), thanhToan.getSoTien(), thanhToan.getHinhThucThanhToan(), thanhToan.getMaThanhToan());
        } else {
            String sql = "INSERT INTO TDV_ThanhToan (TDV_MaHoaDon, TDV_NgayThanhToan, TDV_SoTien, TDV_HinhThucThanhToan) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, thanhToan.getMaHoaDon(), thanhToan.getNgayThanhToan(), thanhToan.getSoTien(), thanhToan.getHinhThucThanhToan());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TDV_ThanhToan WHERE TDV_MaThanhToan = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ThanhToanMapper implements RowMapper<ThanhToan> {
        @Override
        public ThanhToan mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ThanhToan(
                rs.getInt("TDV_MaThanhToan"),
                rs.getInt("TDV_MaHoaDon"),
                rs.getDate("TDV_NgayThanhToan"),
                rs.getDouble("TDV_SoTien"),
                rs.getString("TDV_HinhThucThanhToan")
            );
        }
    }
}
