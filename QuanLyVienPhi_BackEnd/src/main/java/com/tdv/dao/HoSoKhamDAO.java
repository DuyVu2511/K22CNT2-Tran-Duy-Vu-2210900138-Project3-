package com.tdv.dao;

import com.tdv.model.HoSoKham;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HoSoKhamDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HoSoKham> getAllHoSoKham() {
        String sql = "SELECT * FROM TDV_HoSoKham";
        return jdbcTemplate.query(sql, new HoSoKhamRowMapper());
    }

    public HoSoKham getHoSoKhamById(int id) {
        String sql = "SELECT * FROM TDV_HoSoKham WHERE TDV_MaHoSo = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new HoSoKhamRowMapper());
        } catch (Exception e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }

    public int save(HoSoKham hoSoKham) {
        String sql = "INSERT INTO TDV_HoSoKham (TDV_MaBenhNhan, TDV_NgayKham, TDV_ChanDoan, TDV_BacSiDieuTri, TDV_TrangThai) " +
                     "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
            hoSoKham.getMaBenhNhan(),
            hoSoKham.getNgayKham(),
            hoSoKham.getChanDoan(),
            hoSoKham.getBacSiDieuTri(),
            hoSoKham.getTrangThai()
        );
    }

    public int update(HoSoKham hoSoKham) {
        String sql = "UPDATE TDV_HoSoKham SET TDV_MaBenhNhan = ?, TDV_NgayKham = ?, TDV_ChanDoan = ?, " +
                     "TDV_BacSiDieuTri = ?, TDV_TrangThai = ? WHERE TDV_MaHoSo = ?";
        return jdbcTemplate.update(sql,
            hoSoKham.getMaBenhNhan(),
            hoSoKham.getNgayKham(),
            hoSoKham.getChanDoan(),
            hoSoKham.getBacSiDieuTri(),
            hoSoKham.getTrangThai(),
            hoSoKham.getMaHoSo()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM TDV_HoSoKham WHERE TDV_MaHoSo = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class HoSoKhamRowMapper implements RowMapper<HoSoKham> {
        @Override
        public HoSoKham mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new HoSoKham(
                rs.getInt("TDV_MaHoSo"),
                rs.getInt("TDV_MaBenhNhan"),
                rs.getTimestamp("TDV_NgayKham"),
                rs.getString("TDV_ChanDoan"),
                rs.getString("TDV_BacSiDieuTri"),
                rs.getBoolean("TDV_TrangThai")
            );
        }
    }
}