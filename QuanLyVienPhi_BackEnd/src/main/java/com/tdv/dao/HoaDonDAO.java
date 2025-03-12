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
        String sql = "SELECT * FROM TDV_HoaDon";
        return jdbcTemplate.query(sql, new HoaDonRowMapper());
    }

    public HoaDon getHoaDonById(int id) {
        String sql = "SELECT * FROM TDV_HoaDon WHERE TDV_MaHoaDon = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new HoaDonRowMapper());
        } catch (Exception e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }

    public int save(HoaDon hoaDon) {
        String sql = "INSERT INTO TDV_HoaDon (TDV_MaBenhNhan, TDV_NgayLap, TDV_TongTien, TDV_BaoHiemHoTro, TDV_SoTienPhaiTra, TDV_TrangThaiThanhToan) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
            hoaDon.getMaBenhNhan(),
            hoaDon.getNgayLap(),
            hoaDon.getTongTien(),
            hoaDon.getBaoHiemHoTro(),
            hoaDon.getSoTienPhaiTra(),
            hoaDon.getTrangThaiThanhToan()
        );
    }

    public int update(HoaDon hoaDon) {
        String sql = "UPDATE TDV_HoaDon SET TDV_MaBenhNhan = ?, TDV_NgayLap = ?, TDV_TongTien = ?, " +
                     "TDV_BaoHiemHoTro = ?, TDV_SoTienPhaiTra = ?, TDV_TrangThaiThanhToan = ? " +
                     "WHERE TDV_MaHoaDon = ?";
        return jdbcTemplate.update(sql,
            hoaDon.getMaBenhNhan(),
            hoaDon.getNgayLap(),
            hoaDon.getTongTien(),
            hoaDon.getBaoHiemHoTro(),
            hoaDon.getSoTienPhaiTra(),
            hoaDon.getTrangThaiThanhToan(),
            hoaDon.getMaHoaDon()
        );
    }

    public int delete(int id) {
        String sql = "DELETE FROM TDV_HoaDon WHERE TDV_MaHoaDon = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class HoaDonRowMapper implements RowMapper<HoaDon> {
        @Override
        public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new HoaDon(
                rs.getInt("TDV_MaHoaDon"),
                rs.getInt("TDV_MaBenhNhan"),
                rs.getTimestamp("TDV_NgayLap"),
                rs.getDouble("TDV_TongTien"),
                rs.getDouble("TDV_BaoHiemHoTro"),
                rs.getDouble("TDV_SoTienPhaiTra"),
                rs.getString("TDV_TrangThaiThanhToan")
            );
        }
    }
}