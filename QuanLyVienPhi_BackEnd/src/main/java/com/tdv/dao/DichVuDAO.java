package com.tdv.dao;

import com.tdv.model.DichVu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DichVuDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DichVu> getAllDichVu() {
        String sql = "SELECT * FROM TDV_DichVu";
        return jdbcTemplate.query(sql, new DichVuMapper());
    }

    public DichVu getById(int id) {
        String sql = "SELECT * FROM TDV_DichVu WHERE TDV_MaDichVu = ?";
        return jdbcTemplate.queryForObject(sql, new DichVuMapper(), id);
    }

    public void saveOrUpdate(DichVu dichVu) {
        if (dichVu.getMaDichVu() > 0) {
            String sql = "UPDATE TDV_DichVu SET TDV_TenDichVu=?, TDV_MoTa=?, TDV_DonGia=?, TDV_TrangThai=? WHERE TDV_MaDichVu=?";
            jdbcTemplate.update(sql, dichVu.getTenDichVu(), dichVu.getMoTa(), dichVu.getDonGia(), dichVu.getTrangThai(), dichVu.getMaDichVu());
        } else {
            String sql = "INSERT INTO TDV_DichVu (TDV_TenDichVu, TDV_MoTa, TDV_DonGia, TDV_TrangThai) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, dichVu.getTenDichVu(), dichVu.getMoTa(), dichVu.getDonGia(), dichVu.getTrangThai());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TDV_DichVu WHERE TDV_MaDichVu = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class DichVuMapper implements RowMapper<DichVu> {
        @Override
        public DichVu mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new DichVu(
                rs.getInt("TDV_MaDichVu"),
                rs.getString("TDV_TenDichVu"),
                rs.getString("TDV_MoTa"),
                rs.getDouble("TDV_DonGia"),
                rs.getString("TDV_TrangThai")
            );
        }
    }
}
