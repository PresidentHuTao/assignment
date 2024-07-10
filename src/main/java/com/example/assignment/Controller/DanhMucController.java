package com.example.assignment.Controller;

import com.example.assignment.Entity.DanhMuc;
import com.example.assignment.Repositoty.DanhMucInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class DanhMucController {
    @Autowired
    private DanhMucInterface dmi;

    @GetMapping("/danh-muc/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", dmi.getAll());
        return "/danh-muc/list";
    }

    @GetMapping("/delete-danh-muc/{id}")
    public String delete(@PathVariable Integer id) {
        dmi.delete(id);
        return "redirect:/danh-muc/hien-thi";
    }

    @PostMapping("/add-danh-muc")
    public String add(@ModelAttribute DanhMuc dm) {
        dm.setNgayTao(LocalDate.now());
        dmi.add(dm);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/view-update-danh-muc/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("dm", dmi.getById(id));
        return "/danh-muc/update";
    }

    @PostMapping("/update-danh-muc/{id}")
    public String update(DanhMuc dm, @PathVariable("id") Integer id) { //đừng thấy biến id ko dùng đến mà xóa
        dm.setNgaySua(LocalDate.now());
        dmi.update(dm);
        return "redirect:/danh-muc/hien-thi";
    }
}
