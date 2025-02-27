package com.tdv.controller;

import com.tdv.dao.ChiTietDichVuDAO;
import com.tdv.model.ChiTietDichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chitietdichvu")
public class ChiTietDichVuController {
    @Autowired
    private ChiTietDichVuDAO chiTietDichVuDAO;

    @GetMapping("")
    public String listChiTietDichVu(Model model) {
        model.addAttribute("chiTietDichVus", chiTietDichVuDAO.getAllChiTietDichVu());
        return "chitietdichvu_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("chiTietDichVu", new ChiTietDichVu());
        return "chitietdichvu_form";
    }

    @PostMapping("/save")
    public String saveChiTietDichVu(@ModelAttribute("chiTietDichVu") ChiTietDichVu chiTietDichVu) {
        chiTietDichVuDAO.saveOrUpdate(chiTietDichVu);
        return "redirect:/chitietdichvu";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("chiTietDichVu", chiTietDichVuDAO.getById(id));
        return "chitietdichvu_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteChiTietDichVu(@PathVariable("id") int id) {
        chiTietDichVuDAO.delete(id);
        return "redirect:/chitietdichvu";
    }
}
