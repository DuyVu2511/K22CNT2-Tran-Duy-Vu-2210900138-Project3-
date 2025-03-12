package com.tdv.controller;

import com.tdv.dao.DichVuDAO;
import com.tdv.model.DichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DichVuController {

    @Autowired
    private DichVuDAO dichVuDAO;

    @GetMapping("/dichvu_list")
    public String listDichVu(Model model) {
        List<DichVu> list = dichVuDAO.getAllDichVu();
        model.addAttribute("dichVus", list);
        return "dichvu_list";
    }

    @GetMapping("/dichvu_add")
    public String showAddForm(Model model) {
        model.addAttribute("dichVu", new DichVu());
        return "dichvu_add";
    }

    @PostMapping("/dichvu/save")
    public String save(@ModelAttribute("dichVu") DichVu dichVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "dichvu_add";
        }
        try {
            if (dichVu.getTenDichVu() == null || dichVu.getTenDichVu().trim().isEmpty() || dichVu.getDonGia() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Tên Dịch Vụ, Đơn Giá)!");
                return "dichvu_add";
            }

            dichVuDAO.save(dichVu);
            return "redirect:/dichvu_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "dichvu_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "dichvu_add";
        }
    }

    @GetMapping("/dichvu_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        DichVu dichVu = dichVuDAO.getDichVuById(id);
        if (dichVu == null) {
            model.addAttribute("error", "Không tìm thấy dịch vụ!");
            return "redirect:/dichvu_list";
        }
        model.addAttribute("dichVu", dichVu);
        return "dichvu_edit";
    }

    @PostMapping("/dichvu/edit")
    public String editSave(@ModelAttribute("dichVu") DichVu dichVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "dichvu_edit";
        }
        try {
            if (dichVu.getTenDichVu() == null || dichVu.getTenDichVu().trim().isEmpty() || dichVu.getDonGia() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Tên Dịch Vụ, Đơn Giá)!");
                return "dichvu_edit";
            }

            dichVuDAO.update(dichVu);
            return "redirect:/dichvu_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "dichvu_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "dichvu_edit";
        }
    }

    @GetMapping("/dichvu_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = dichVuDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa dịch vụ này vì có ràng buộc dữ liệu!");
                return "redirect:/dichvu_list";
            }
            return "redirect:/dichvu_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "redirect:/dichvu_list";
        }
    }
}