package com.example.assignment.Controller;

import com.example.assignment.Entity.MauSac;
import com.example.assignment.Repositoty.MauSacInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class MauSacController {
    @Autowired
    private MauSacInterface msi;

    @GetMapping("/mau-sac/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", msi.getAll());
        return "/mau-sac/list";
    }

    @GetMapping("/delete-mau-sac/{id}")
    public String delete(@PathVariable Integer id) {
        msi.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/add-mau-sac")
    public String add(@ModelAttribute MauSac ms) {
        ms.setNgayTao(LocalDate.now());
        msi.add(ms);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/view-update-mau-sac/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("ms", msi.getById(id));
        return "/mau-sac/update";
    }

    @PostMapping("/update-mau-sac/{id}")
    public String update(MauSac ms, @PathVariable("id") Integer id) { //đừng thấy biến id ko dùng đến mà xóa
        ms.setNgaySua(LocalDate.now());
        msi.update(ms);
        return "redirect:/mau-sac/hien-thi";
    }
}
