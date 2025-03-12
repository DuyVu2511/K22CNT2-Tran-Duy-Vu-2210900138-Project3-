package com.tdv.controller;

import com.tdv.dao.ChiTietDichVuDAO;
import com.tdv.model.ChiTietDichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChiTietDichVuController {

    @Autowired
    private ChiTietDichVuDAO chiTietDichVuDAO;

    @GetMapping("/chitietdichvu_list")
    public String listChiTietDichVu(Model model) {
        List<ChiTietDichVu> list = chiTietDichVuDAO.getAllChiTietDichVu();
        model.addAttribute("chiTietDichVus", list);
        return "chitietdichvu_list";
    }

    @GetMapping("/chitietdichvu_add")
    public String showAddForm(Model model) {
        model.addAttribute("chiTietDichVu", new ChiTietDichVu());
        return "chitietdichvu_add";
    }

    @PostMapping("chitietdichvu/save")
    public String save(@ModelAttribute("chiTietDichVu") ChiTietDichVu chiTietDichVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "chitietdichvu_add";
        }
        try {
            if (chiTietDichVu.getMaHoSo() <= 0 || chiTietDichVu.getMaDichVu() <= 0 || chiTietDichVu.getSoLuong() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Hồ Sơ, Mã Dịch Vụ, Số Lượng)!");
                return "chitietdichvu_add";
            }

            chiTietDichVuDAO.save(chiTietDichVu);
            return "redirect:/chitietdichvu_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "chitietdichvu_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "chitietdichvu_add";
        }
    }

    @GetMapping("/chitietdichvu_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        ChiTietDichVu chiTietDichVu = chiTietDichVuDAO.getChiTietDichVuById(id);
        if (chiTietDichVu == null) {
            model.addAttribute("error", "Không tìm thấy chi tiết dịch vụ!");
            return "redirect:/chitietdichvu_list";
        }
        model.addAttribute("chiTietDichVu", chiTietDichVu);
        return "chitietdichvu_edit";
    }

    @PostMapping("/chitietdichvu/edit")
    public String editSave(@ModelAttribute("chiTietDichVu") ChiTietDichVu chiTietDichVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "chitietdichvu_edit";
        }
        try {
            if (chiTietDichVu.getMaHoSo() <= 0 || chiTietDichVu.getMaDichVu() <= 0 || chiTietDichVu.getSoLuong() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Hồ Sơ, Mã Dịch Vụ, Số Lượng)!");
                return "chitietdichvu_edit";
            }

            chiTietDichVuDAO.update(chiTietDichVu);
            return "redirect:/chitietdichvu_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "chitietdichvu_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "chitietdichvu_edit";
        }
    }

    @GetMapping("/chitietdichvu_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = chiTietDichVuDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa chi tiết dịch vụ này vì có ràng buộc dữ liệu!");
                return "chitietdichvu_list";
            }
            return "redirect:/chitietdichvu_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "chitietdichvu_list";
        }
    }
}