package com.tdv.controller;

import com.tdv.dao.ChiTietHoaDonDAO;
import com.tdv.model.ChiTietHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chitiethoadon_list")
public class ChiTietHoaDonController {
    @Autowired
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    @GetMapping("")
    public String listChiTietHoaDon(Model model) {
        model.addAttribute("chiTietHoaDons", chiTietHoaDonDAO.getAllChiTietHoaDon());
        return "chitiethoadon_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("chiTietHoaDon", new ChiTietHoaDon());
        return "chitiethoadon_form";
    }

    @PostMapping("/save")
    public String saveChiTietHoaDon(@ModelAttribute("chiTietHoaDon") ChiTietHoaDon chiTietHoaDon) {
        chiTietHoaDonDAO.saveOrUpdate(chiTietHoaDon);
        return "redirect:/chitiethoadon";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("chiTietHoaDon", chiTietHoaDonDAO.getById(id));
        return "chitiethoadon_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteChiTietHoaDon(@PathVariable("id") int id) {
        chiTietHoaDonDAO.delete(id);
        return "redirect:/chitiethoadon";
    }
}
