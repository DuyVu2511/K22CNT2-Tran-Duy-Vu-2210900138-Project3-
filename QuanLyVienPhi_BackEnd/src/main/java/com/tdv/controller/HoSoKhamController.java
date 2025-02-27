package com.tdv.controller;

import com.tdv.dao.HoSoKhamDAO;
import com.tdv.model.HoSoKham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HoSoKhamController {
    @Autowired
    private HoSoKhamDAO hoSoKhamDAO;

    // Hiển thị danh sách hồ sơ khám
    @GetMapping("/hosokham")
    public String listHoSoKham(Model model) {
        List<HoSoKham> list = hoSoKhamDAO.getAllHoSoKham();
        model.addAttribute("hoSoKhams", list);
        return "hosokham_list";
    }
}
