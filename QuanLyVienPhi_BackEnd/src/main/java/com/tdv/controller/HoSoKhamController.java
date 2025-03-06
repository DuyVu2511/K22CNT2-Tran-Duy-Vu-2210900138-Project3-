package com.tdv.controller;

import com.tdv.dao.HoSoKhamDAO;
import com.tdv.model.HoSoKham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hosokham_list")
public class HoSoKhamController {
    @Autowired
    private HoSoKhamDAO hoSoKhamDAO;

    @GetMapping("")
    public String listHoSoKham(Model model) {
        model.addAttribute("hoSoKhams", hoSoKhamDAO.getAllHoSoKham());
        return "hosokham_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hoSoKham", new HoSoKham());
        return "hosokham_form";
    }

    @PostMapping("/save")
    public String saveHoSoKham(@ModelAttribute("hoSoKham") HoSoKham hoSoKham) {
        hoSoKhamDAO.saveOrUpdate(hoSoKham);
        return "redirect:/hosokham";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("hoSoKham", hoSoKhamDAO.getById(id));
        return "hosokham_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteHoSoKham(@PathVariable("id") int id) {
        hoSoKhamDAO.delete(id);
        return "redirect:/hosokham";
    }
}
