package com.tdv.controller;

import com.tdv.dao.HoSoKhamDAO;
import com.tdv.model.HoSoKham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HoSoKhamController {

    @Autowired
    private HoSoKhamDAO hoSoKhamDAO;

    @GetMapping("/hosokham_list")
    public String listHoSoKham(Model model) {
        List<HoSoKham> list = hoSoKhamDAO.getAllHoSoKham();
        model.addAttribute("hoSoKhams", list);
        return "hosokham_list";
    }

    @GetMapping("/hosokham_add")
    public String showAddForm(Model model) {
        model.addAttribute("hoSoKham", new HoSoKham());
        return "hosokham_add";
    }

    @PostMapping("/hosokham/save")
    public String save(@ModelAttribute("hoSoKham") HoSoKham hoSoKham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "hosokham_add";
        }
        try {
            if (hoSoKham.getMaBenhNhan() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Bệnh Nhân)!");
                return "hosokham_add";
            }

            hoSoKhamDAO.save(hoSoKham);
            return "redirect:/hosokham_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "hosokham_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "hosokham_add";
        }
    }

    @GetMapping("/hosokham_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        HoSoKham hoSoKham = hoSoKhamDAO.getHoSoKhamById(id);
        if (hoSoKham == null) {
            model.addAttribute("error", "Không tìm thấy hồ sơ khám!");
            return "redirect:/hosokham_list";
        }
        model.addAttribute("hoSoKham", hoSoKham);
        return "hosokham_edit";
    }

    @PostMapping("/hosokham/edit")
    public String editSave(@ModelAttribute("hoSoKham") HoSoKham hoSoKham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "hosokham_edit";
        }
        try {
            if (hoSoKham.getMaBenhNhan() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Bệnh Nhân)!");
                return "hosokham_edit";
            }

            hoSoKhamDAO.update(hoSoKham);
            return "redirect:/hosokham_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "hosokham_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "hosokham_edit";
        }
    }

    @GetMapping("/hosokham_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = hoSoKhamDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa hồ sơ khám này vì có ràng buộc dữ liệu!");
                return "hosokham_list";
            }
            return "redirect:/hosokham_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "hosokham_list";
        }
    }
}