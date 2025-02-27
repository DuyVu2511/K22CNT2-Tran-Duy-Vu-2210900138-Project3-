package com.tdv.controller;

import com.tdv.dao.BenhNhanDAO;
import com.tdv.model.BenhNhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BenhNhanController {

    @Autowired
    private BenhNhanDAO benhNhanDAO;

    // Hiển thị danh sách bệnh nhân
    @GetMapping("/benhnhan")
    public String listBenhNhan(Model model) {
        List<BenhNhan> list = benhNhanDAO.getAllBenhNhan();
        model.addAttribute("benhNhans", list);
        return "benhnhan_list"; // Tên view cho danh sách bệnh nhân
    }

    // Hiển thị form nhập thông tin bệnh nhân
    @GetMapping("/benhnhan/saveform")
    public String showForm(Model model) {
        model.addAttribute("command", new BenhNhan());
        return "benhnhan_form"; // Tên view cho form nhập
    }

    // Lưu thông tin bệnh nhân vào cơ sở dữ liệu
    @PostMapping("/benhnhan/save")
    public String save(@ModelAttribute("user") BenhNhan benhNhan) {
        benhNhanDAO.save(benhNhan);
        return "redirect:/benhnhan"; // Chuyển hướng về danh sách bệnh nhân
    }

    // Hiển thị form sửa thông tin bệnh nhân
    @RequestMapping(value = "/benhnhan/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        BenhNhan benhNhan = benhNhanDAO.getBenhNhanById(id);
        model.addAttribute("command", benhNhan);
        return "benhnhan_edit"; // Tên view cho form sửa
    }

    // Lưu thông tin bệnh nhân sau khi sửa
    @RequestMapping(value = "/benhnhan/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("user") BenhNhan benhNhan) {
        benhNhanDAO.update(benhNhan);
        return "redirect:/benhnhan"; // Chuyển hướng về danh sách bệnh nhân
    }

    // Xóa thông tin bệnh nhân
    @RequestMapping(value = "/benhnhan/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        benhNhanDAO.delete(id);
        return "redirect:/benhnhan"; // Chuyển hướng về danh sách bệnh nhân
    }
}
