package com.tdv.controller;

import com.tdv.dao.DichVuDAO;
import com.tdv.model.DichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dichvu_list")
public class DichVuController {
    @Autowired
    private DichVuDAO dichVuDAO;

    @GetMapping("")
    public String listDichVu(Model model) {
        model.addAttribute("dichVus", dichVuDAO.getAllDichVu());
        return "dichvu_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dichVu", new DichVu());
        return "dichvu_form";
    }

    @PostMapping("/save")
    public String saveDichVu(@ModelAttribute("dichVu") DichVu dichVu) {
        dichVuDAO.saveOrUpdate(dichVu);
        return "redirect:/dichvu";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("dichVu", dichVuDAO.getById(id));
        return "dichvu_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDichVu(@PathVariable("id") int id) {
        dichVuDAO.delete(id);
        return "redirect:/dichvu";
    }
}
