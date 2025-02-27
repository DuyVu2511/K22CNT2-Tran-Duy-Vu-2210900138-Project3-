package com.tdv.controller;

import com.tdv.dao.ThanhToanDAO;
import com.tdv.model.ThanhToan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/thanhtoan")
public class ThanhToanController {
    @Autowired
    private ThanhToanDAO thanhToanDAO;

    @GetMapping("")
    public String listThanhToan(Model model) {
        model.addAttribute("thanhToans", thanhToanDAO.getAllThanhToan());
        return "thanhtoan_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("thanhToan", new ThanhToan());
        return "thanhtoan_form";
    }

    @PostMapping("/save")
    public String saveThanhToan(@ModelAttribute("thanhToan") ThanhToan thanhToan) {
        thanhToanDAO.saveOrUpdate(thanhToan);
        return "redirect:/thanhtoan";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("thanhToan", thanhToanDAO.getById(id));
        return "thanhtoan_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteThanhToan(@PathVariable("id") int id) {
        thanhToanDAO.delete(id);
        return "redirect:/thanhtoan";
    }
}
