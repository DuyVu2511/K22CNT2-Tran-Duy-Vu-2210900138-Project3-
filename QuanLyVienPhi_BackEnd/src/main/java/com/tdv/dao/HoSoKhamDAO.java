package com.tdv.dao;

import com.tdv.model.HoSoKham;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HoSoKhamDAO {
    private JdbcTemplate jdbcTemplate;

    // Setter để Spring tiêm JdbcTemplate
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lấy danh sách hồ sơ khám
    public List<HoSoKham> getAllHoSoKham() {
        String sql = "SELECT * FROM TDV_HoSoKham";
        return jdbcTemplate.query(sql, new HoSoKhamMapper());
    }

    // Lấy hồ sơ khám theo ID
    public HoSoKham getById(int id) {
        String sql = "SELECT * FROM TDV_HoSoKham WHERE TDV_MaHoSo = ?";
        return jdbcTemplate.queryForObject(sql, new HoSoKhamMapper(), id);
    }

    // Thêm hoặc cập nhật hồ sơ khám
    public void saveOrUpdate(HoSoKham hoSoKham) {
        if (hoSoKham.getMaHoSo() > 0) {
            // Cập nhật
            String sql = "UPDATE TDV_HoSoKham SET TDV_MaBenhNhan=?, TDV_NgayKham=?, TDV_ChanDoan=?, TDV_BacSiDieuTri=?, TDV_TrangThai=? WHERE TDV_MaHoSo=?";
            jdbcTemplate.update(sql, hoSoKham.getMaBenhNhan(), hoSoKham.getNgayKham(), hoSoKham.getChanDoan(), hoSoKham.getBacSiDieuTri(), hoSoKham.isTrangThai(), hoSoKham.getMaHoSo());
        } else {
            // Thêm mới
            String sql = "INSERT INTO TDV_HoSoKham (TDV_MaBenhNhan, TDV_NgayKham, TDV_ChanDoan, TDV_BacSiDieuTri, TDV_TrangThai) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, hoSoKham.getMaBenhNhan(), hoSoKham.getNgayKham(), hoSoKham.getChanDoan(), hoSoKham.getBacSiDieuTri(), hoSoKham.isTrangThai());
        }
    }

    // Xóa hồ sơ khám theo ID
    public void delete(int id) {
        String sql = "DELETE FROM TDV_HoSoKham WHERE TDV_MaHoSo = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper để ánh xạ dữ liệu từ ResultSet
    private static class HoSoKhamMapper implements RowMapper<HoSoKham> {
        @Override
        public HoSoKham mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new HoSoKham(
                rs.getInt("TDV_MaHoSo"),
                rs.getInt("TDV_MaBenhNhan"),
                rs.getDate("TDV_NgayKham"),
                rs.getString("TDV_ChanDoan"),
                rs.getString("TDV_BacSiDieuTri"),
                rs.getBoolean("TDV_TrangThai")
            );
        }
    }
}
