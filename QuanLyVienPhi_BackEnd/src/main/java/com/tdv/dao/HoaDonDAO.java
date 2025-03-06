package com.tdv.dao;

import com.tdv.model.HoaDon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HoaDonDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HoaDon> getAllHoaDon() {
        String sql = "SELECT TDV_MaHoaDon, TDV_NgayLap, TDV_TongTien FROM TDV_HoaDon";
        return jdbcTemplate.query(sql, new HoaDonMapper());
    }

    public HoaDon getById(int id) {
        String sql = "SELECT TDV_MaHoaDon, TDV_NgayLap, TDV_TongTien FROM TDV_HoaDon WHERE TDV_MaHoaDon = ?";
        return jdbcTemplate.queryForObject(sql, new HoaDonMapper(), id);
    }

    public void saveOrUpdate(HoaDon hoaDon) {
        if (hoaDon.getMaHoaDon() > 0) {
            String sql = "UPDATE TDV_HoaDon SET TDV_NgayLap=?, TDV_TongTien=? WHERE TDV_MaHoaDon=?";
            jdbcTemplate.update(sql, hoaDon.getNgayLap(), hoaDon.getTongTien(), hoaDon.getMaHoaDon());
        } else {
            String sql = "INSERT INTO TDV_HoaDon (TDV_NgayLap, TDV_TongTien) VALUES (?, ?)";
            jdbcTemplate.update(sql, hoaDon.getNgayLap(), hoaDon.getTongTien());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TDV_HoaDon WHERE TDV_MaHoaDon = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class HoaDonMapper implements RowMapper<HoaDon> {
        @Override
        public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new HoaDon(
                rs.getInt("TDV_MaHoaDon"),
                rs.getString("TDV_NgayLap"),
                rs.getDouble("TDV_TongTien")
            );
        }
    }
}
