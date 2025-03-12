package com.tdv.controller;

import com.tdv.dao.ChiTietHoaDonDAO;
import com.tdv.model.ChiTietHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChiTietHoaDonController {

    @Autowired
    private ChiTietHoaDonDAO chiTietHoaDonDAO;

    @GetMapping("/chitiethoadon_list")
    public String listChiTietHoaDon(Model model) {
        List<ChiTietHoaDon> list = chiTietHoaDonDAO.getAllChiTietHoaDon();
        model.addAttribute("chiTietHoaDons", list);
        return "chitiethoadon_list";
    }

    @GetMapping("/chitiethoadon_add")
    public String showAddForm(Model model) {
        model.addAttribute("chiTietHoaDon", new ChiTietHoaDon());
        return "chitiethoadon_add";
    }

    @PostMapping("/chitiethoadon/save")
    public String save(@ModelAttribute("chiTietHoaDon") ChiTietHoaDon chiTietHoaDon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "chitiethoadon_add";
        }
        try {
            if (chiTietHoaDon.getMaHoaDon() <= 0 || chiTietHoaDon.getMaDichVu() <= 0 || chiTietHoaDon.getSoLuong() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Hóa Đơn, Mã Dịch Vụ, Số Lượng)!");
                return "chitiethoadon_add";
            }

            chiTietHoaDonDAO.save(chiTietHoaDon);
            return "redirect:/chitiethoadon_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "chitiethoadon_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "chitiethoadon_add";
        }
    }

    @GetMapping("/chitiethoadon_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        ChiTietHoaDon chiTietHoaDon = chiTietHoaDonDAO.getChiTietHoaDonById(id);
        if (chiTietHoaDon == null) {
            model.addAttribute("error", "Không tìm thấy chi tiết hóa đơn!");
            return "redirect:/chitiethoadon_list";
        }
        model.addAttribute("chiTietHoaDon", chiTietHoaDon);
        return "chitiethoadon_edit";
    }

    @PostMapping("/chitiethoadon/edit")
    public String editSave(@ModelAttribute("chiTietHoaDon") ChiTietHoaDon chiTietHoaDon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "chitiethoadon_edit";
        }
        try {
            if (chiTietHoaDon.getMaHoaDon() <= 0 || chiTietHoaDon.getMaDichVu() <= 0 || chiTietHoaDon.getSoLuong() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Hóa Đơn, Mã Dịch Vụ, Số Lượng)!");
                return "chitiethoadon_edit";
            }

            chiTietHoaDonDAO.update(chiTietHoaDon);
            return "redirect:/chitiethoadon_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "chitiethoadon_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "chitiethoadon_edit";
        }
    }

    @GetMapping("/chitiethoadon_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = chiTietHoaDonDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa chi tiết hóa đơn này vì có ràng buộc dữ liệu!");
                return "chitiethoadon_list";
            }
            return "redirect:/chitiethoadon_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "chitiethoadon_list";
        }
    }
}