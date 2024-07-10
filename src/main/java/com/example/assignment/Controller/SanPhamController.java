package com.example.assignment.Controller;

import com.example.assignment.Entity.SanPham;
import com.example.assignment.Repositoty.DanhMucInterface;
import com.example.assignment.Repositoty.SanPhamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class SanPhamController {
    @Autowired
    private DanhMucInterface dmi;
    @Autowired
    private SanPhamInterface spi;

    @GetMapping("/san-pham/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", spi.getAll());
        model.addAttribute("DanhMuc", dmi.getAll());
        return "/san-pham/list";
    }

    @GetMapping("/delete-san-pham/{id}")
    public String delete(@PathVariable Integer id) {
        spi.delete(id);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/add-san-pham")
    public String add(@ModelAttribute SanPham sp) {
        sp.setNgayTao(LocalDate.now());
        spi.add(sp);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/view-update-san-pham/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("sp", spi.getById(id));
        model.addAttribute("DanhMuc", dmi.getAll());
        return "/san-pham/update";
    }

    @PostMapping("/update-san-pham/{id}")
    public String update(SanPham sp, @PathVariable("id") Integer id) { //đừng thấy biến id ko dùng đến mà xóa
        sp.setNgaySua(LocalDate.now());
        spi.update(sp);
        return "redirect:/san-pham/hien-thi";
    }
}
