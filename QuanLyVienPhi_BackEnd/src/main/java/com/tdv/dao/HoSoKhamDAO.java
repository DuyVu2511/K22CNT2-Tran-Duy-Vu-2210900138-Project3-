package com.tdv.dao;

import com.tdv.model.HoSoKham;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HoSoKhamDAO {
    private JdbcTemplate jdbcTemplate;

    // Setter để Spring tiêm dữ liệu
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lấy danh sách hồ sơ khám
    public List<HoSoKham> getAllHoSoKham() {
        String sql = "SELECT * FROM TDV_HoSoKham";
        return jdbcTemplate.query(sql, new RowMapper<HoSoKham>() {
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
        });
    }
}
