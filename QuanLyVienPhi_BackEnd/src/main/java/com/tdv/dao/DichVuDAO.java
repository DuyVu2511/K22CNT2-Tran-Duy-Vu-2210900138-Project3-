package com.tdv.dao;

import com.tdv.model.DichVu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DichVuDAO {
    private final JdbcTemplate jdbcTemplate;

    public DichVuDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lấy danh sách tất cả dịch vụ
    public List<DichVu> getAllDichVu() {
        String sql = "SELECT * FROM TDV_DichVu";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DichVu.class));
    }

    // Lấy dịch vụ theo ID
    public DichVu getDichVuById(int id) {
        String sql = "SELECT * FROM TDV_DichVu WHERE TDV_MaDichVu = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(DichVu.class), id);
    }

    // Thêm dịch vụ mới
    public int addDichVu(DichVu dichVu) {
        String sql = "INSERT INTO TDV_DichVu (TDV_TenDichVu, TDV_MoTa, TDV_DonGia, TDV_TrangThai) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, dichVu.getTenDichVu(), dichVu.getMoTa(), dichVu.getDonGia(), dichVu.getTrangThai());
    }

    // Cập nhật dịch vụ
    public int updateDichVu(DichVu dichVu) {
        String sql = "UPDATE TDV_DichVu SET TDV_TenDichVu = ?, TDV_MoTa = ?, TDV_DonGia = ?, TDV_TrangThai = ? WHERE TDV_MaDichVu = ?";
        return jdbcTemplate.update(sql, dichVu.getTenDichVu(), dichVu.getMoTa(), dichVu.getDonGia(), dichVu.getTrangThai(), dichVu.getMaDichVu());
    }

    // Xóa dịch vụ
    public int deleteDichVu(int id) {
        String sql = "DELETE FROM TDV_DichVu WHERE TDV_MaDichVu = ?";
        return jdbcTemplate.update(sql, id);
    }
}
