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
        return jdbcTemplate.query(sql, new ChiTietDichVuRowMapper());
    }

    public ChiTietDichVu getChiTietDichVuById(int id) {
        String sql = "SELECT * FROM TDV_ChiTietDichVu WHERE TDV_MaChiTiet = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ChiTietDichVuRowMapper());
        } catch (Exception e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }

    public int save(ChiTietDichVu chiTietDichVu) {
        String sql = "INSERT INTO TDV_ChiTietDichVu (TDV_MaHoSo, TDV_MaDichVu, TDV_SoLuong, TDV_ThanhTien) " +
                     "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
            chiTietDichVu.getMaHoSo(),
            chiTietDichVu.getMaDichVu(),
            chiTietDichVu.getSoLuong(),
            chiTietDichVu.getThanhTien()
        );
    }

    public int update(ChiTietDichVu chiTietDichVu) {
        String sql = "UPDATE TDV_ChiTietDichVu SET TDV_MaHoSo = ?, TDV_MaDichVu = ?, TDV_SoLuong = ?, " +
                     "TDV_ThanhTien = ? WHERE TDV_MaChiTiet = ?";
        return jdbcTemplate.update(sql,
            chiTietDichVu.getMaHoSo(),
            chiTietDichVu.getMaDichVu(),
            chiTietDichVu.getSoLuong(),
            chiTietDichVu.getThanhTien(),
            chiTietDichVu.getMaChiTiet()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM TDV_ChiTietDichVu WHERE TDV_MaChiTiet = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class ChiTietDichVuRowMapper implements RowMapper<ChiTietDichVu> {
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