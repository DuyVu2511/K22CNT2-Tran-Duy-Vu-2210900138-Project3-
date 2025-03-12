package com.tdv.controller;

import com.tdv.dao.HoaDonDAO;
import com.tdv.model.HoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HoaDonController {

    @Autowired
    private HoaDonDAO hoaDonDAO;

    @GetMapping("/hoadon_list")
    public String listHoaDon(Model model) {
        List<HoaDon> list = hoaDonDAO.getAllHoaDon();
        model.addAttribute("hoaDons", list);
        return "hoadon_list";
    }

    @GetMapping("/hoadon_add")
    public String showAddForm(Model model) {
        model.addAttribute("hoaDon", new HoaDon());
        return "hoadon_add";
    }

    @PostMapping("/hoadon/save")
    public String save(@ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "hoadon_add";
        }
        try {
            if (hoaDon.getMaBenhNhan() <= 0 || hoaDon.getTongTien() < 0 || hoaDon.getSoTienPhaiTra() < 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Bệnh Nhân, Tổng Tiền, Số Tiền Phải Trả)!");
                return "hoadon_add";
            }

            hoaDonDAO.save(hoaDon);
            return "redirect:/hoadon_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "hoadon_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "hoadon_add";
        }
    }

    @GetMapping("/hoadon_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        HoaDon hoaDon = hoaDonDAO.getHoaDonById(id);
        if (hoaDon == null) {
            model.addAttribute("error", "Không tìm thấy hóa đơn!");
            return "redirect:/hoadon_list";
        }
        model.addAttribute("hoaDon", hoaDon);
        return "hoadon_edit";
    }

    @PostMapping("/hoadon/edit")
    public String editSave(@ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "hoadon_edit";
        }
        try {
            if (hoaDon.getMaBenhNhan() <= 0 || hoaDon.getTongTien() < 0 || hoaDon.getSoTienPhaiTra() < 0) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ và hợp lệ thông tin (Mã Bệnh Nhân, Tổng Tiền, Số Tiền Phải Trả)!");
                return "hoadon_edit";
            }

            hoaDonDAO.update(hoaDon);
            return "redirect:/hoadon_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "Dữ liệu đã tồn tại!");
            return "hoadon_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "hoadon_edit";
        }
    }

    @GetMapping("/hoadon_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = hoaDonDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa hóa đơn này vì có ràng buộc dữ liệu!");
                return "hoadon_list";
            }
            return "redirect:/hoadon_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "hoadon_list";
        }
    }
}