package com.tdv.controller;

import com.tdv.dao.DichVuDAO;
import com.tdv.model.DichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {
    @Autowired
    private DichVuDAO dichVuDAO;

    // Hiển thị danh sách dịch vụ
    @GetMapping
    public String listDichVu(Model model) {
        List<DichVu> list = dichVuDAO.getAllDichVu();
        model.addAttribute("dichVus", list);
        return "dichvu_list";
    }

    // Hiển thị form thêm dịch vụ
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dichVu", new DichVu());
        return "dichvu_form";
    }

    // Xử lý thêm dịch vụ
    @PostMapping("/add")
    public String addDichVu(@ModelAttribute DichVu dichVu) {
        dichVuDAO.addDichVu(dichVu);
        return "redirect:/dichvu";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        DichVu dichVu = dichVuDAO.getDichVuById(id);
        model.addAttribute("dichVu", dichVu);
        return "dichvu_form";
    }

    // Xử lý cập nhật dịch vụ
    @PostMapping("/edit")
    public String updateDichVu(@ModelAttribute DichVu dichVu) {
        dichVuDAO.updateDichVu(dichVu);
        return "redirect:/dichvu";
    }

    // Xóa dịch vụ
    @GetMapping("/delete/{id}")
    public String deleteDichVu(@PathVariable int id) {
        dichVuDAO.deleteDichVu(id);
        return "redirect:/dichvu";
    }
}
