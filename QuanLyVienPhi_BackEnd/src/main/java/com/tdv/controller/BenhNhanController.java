package com.tdv.controller;

import com.tdv.dao.BenhNhanDAO;
import com.tdv.model.BenhNhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BenhNhanController {

    @Autowired
    private BenhNhanDAO benhNhanDAO;

    @GetMapping("/benhnhan_list")
    public String listBenhNhan(Model model) {
        List<BenhNhan> list = benhNhanDAO.getAllBenhNhan();
        model.addAttribute("benhNhans", list);
        return "benhnhan_list";
    }

    @GetMapping("/benhnhan_add")
    public String showAddForm(Model model) {
        model.addAttribute("benhNhan", new BenhNhan());
        return "benhnhan_add";
    }

    @PostMapping("/benhnhan/save")
    public String save(@ModelAttribute("benhNhan") BenhNhan benhNhan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "benhnhan_add";
        }
        try {
            if (benhNhan.getHoTen().trim().isEmpty() || benhNhan.getNgaySinh() == null ||
                benhNhan.getCmndCccd().trim().isEmpty() || benhNhan.getSoDienThoai().trim().isEmpty() ||
                benhNhan.getDiaChi().trim().isEmpty()) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
                return "benhnhan_add";
            }

            benhNhanDAO.save(benhNhan);
            return "redirect:/benhnhan_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "CMND/CCCD hoặc Mã Bảo Hiểm đã tồn tại!");
            return "benhnhan_add";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "benhnhan_add";
        }
    }

    @GetMapping("/benhnhan_edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        BenhNhan benhNhan = benhNhanDAO.getBenhNhanById(id);
        if (benhNhan == null) {
            model.addAttribute("error", "Không tìm thấy bệnh nhân!");
            return "redirect:/benhnhan_list";
        }
        model.addAttribute("benhNhan", benhNhan);
        return "benhnhan_edit";
    }

    @PostMapping("/benhnhan/edit")
    public String editSave(@ModelAttribute("benhNhan") BenhNhan benhNhan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Dữ liệu không hợp lệ: " + result.getAllErrors());
            return "benhnhan_edit";
        }
        try {
            if (benhNhan.getHoTen().trim().isEmpty() || benhNhan.getNgaySinh() == null ||
                benhNhan.getCmndCccd().trim().isEmpty() || benhNhan.getSoDienThoai().trim().isEmpty() ||
                benhNhan.getDiaChi().trim().isEmpty()) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
                return "benhnhan_edit";
            }

            benhNhanDAO.update(benhNhan);
            return "redirect:/benhnhan_list";
        } catch (org.springframework.dao.DuplicateKeyException e) {
            model.addAttribute("error", "CMND/CCCD hoặc Mã Bảo Hiểm đã tồn tại!");
            return "benhnhan_edit";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi xảy ra: " + e.getMessage());
            return "benhnhan_edit";
        }
    }

    @GetMapping("/benhnhan_delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            int affectedRows = benhNhanDAO.delete(id);
            if (affectedRows == 0) {
                model.addAttribute("error", "Không thể xóa bệnh nhân này vì có ràng buộc dữ liệu!");
                return "benhnhan_list";
            }
            return "redirect:/benhnhan_list";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xóa: " + e.getMessage());
            return "benhnhan_list";
        }
    }
}