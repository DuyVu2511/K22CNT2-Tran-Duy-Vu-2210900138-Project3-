package com.tdv.controller;

import com.tdv.dao.HoaDonDAO;
import com.tdv.model.HoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hoadon_list")
public class HoaDonController {
    @Autowired
    private HoaDonDAO hoaDonDAO;

    @GetMapping("")
    public String listHoaDon(Model model) {
        model.addAttribute("hoaDons", hoaDonDAO.getAllHoaDon());
        return "hoadon_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hoaDon", new HoaDon());
        return "hoadon_form";
    }

    @PostMapping("/save")
    public String saveHoaDon(@ModelAttribute("hoaDon") HoaDon hoaDon) {
        hoaDonDAO.saveOrUpdate(hoaDon);
        return "redirect:/hoadon";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("hoaDon", hoaDonDAO.getById(id));
        return "hoadon_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteHoaDon(@PathVariable("id") int id) {
        hoaDonDAO.delete(id);
        return "redirect:/hoadon";
    }
}
