package com.tdv.controller;

import com.tdv.dao.ThanhToanDAO;
import com.tdv.model.ThanhToan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ThanhToanController {

    @Autowired
    private ThanhToanDAO thanhToanDAO;

    @GetMapping("/thanhtoan_list")
    public String listThanhToan(Model model) {
        List<ThanhToan> list = thanhToanDAO.getAllThanhToan();
        model.addAttribute("thanhToans", list);
        return "thanhtoan_list";
    }

    @GetMapping("/thanhtoan_add")
    public String showAddForm(Model model) {
        model.addAttribute("thanhToan", new ThanhToan());
        return "thanhtoan_add";
    }

    @PostMapping("/thanhtoan/save")
    public String save(@ModelAttribute("thanhToan") ThanhToan thanhToan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "thanhtoan_add";
        }
        try {
            if (thanhToan.getMaHoaDon() <= 0 || thanhToan.getPhuongThuc().isEmpty() || thanhToan.getSoTien() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Hóa Đơn, Phương Thức, Số Tiền)!");
                return "thanhtoan_add";
            }

            thanhToanDAO.save(thanhToan);
            return "redirect:/thanhtoan_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "thanhtoan_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "thanhtoan_add";
        }
    }

    @GetMapping("/thanhtoan_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        ThanhToan thanhToan = thanhToanDAO.getThanhToanById(id);
        if (thanhToan == null) {
            model.addAttribute("error", "Không tìm thấy thanh toán!");
            return "redirect:/thanhtoan_list";
        }
        model.addAttribute("thanhToan", thanhToan);
        return "thanhtoan_edit";
    }

    @PostMapping("/thanhtoan/edit")
    public String editSave(@ModelAttribute("thanhToan") ThanhToan thanhToan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "thanhtoan_edit";
        }
        try {
            if (thanhToan.getMaHoaDon() <= 0 || thanhToan.getPhuongThuc().isEmpty() || thanhToan.getSoTien() <= 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Hóa Đơn, Phương Thức, Số Tiền)!");
                return "thanhtoan_edit";
            }

            thanhToanDAO.update(thanhToan);
            return "redirect:/thanhtoan_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "thanhtoan_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "thanhtoan_edit";
        }
    }

    @GetMapping("/thanhtoan_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = thanhToanDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa thanh toán này vì có ràng buộc dữ liệu!");
                return "thanhtoan_list";
            }
            return "redirect:/thanhtoan_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "thanhtoan_list";
        }
    }
}