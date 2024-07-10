package com.example.assignment.Controller;

import com.example.assignment.Entity.ChiTietSanPham;
import com.example.assignment.Entity.DanhMuc;
import com.example.assignment.Repositoty.ChiTietSanPhamInterface;
import com.example.assignment.Repositoty.MauSacInterface;
import com.example.assignment.Repositoty.SanPhamInterface;
import com.example.assignment.Repositoty.SizeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamInterface ctspi;
    @Autowired
    private SanPhamInterface spi;
    @Autowired
    private MauSacInterface msi;
    @Autowired
    private SizeInterface si;
    @GetMapping("/chi-tiet-san-pham/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", ctspi.getAll());
        model.addAttribute("SanPham", spi.getAll());
        model.addAttribute("MauSac", msi.getAll());
        model.addAttribute("Size", si.getAll());
        return "/chi-tiet-san-pham/list";
    }
    @GetMapping("/delete-chi-tiet-san-pham/{id}")
    public String delete(@PathVariable Integer id) {
        ctspi.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @PostMapping("/add-chi-tiet-san-pham")
    public String add(@ModelAttribute ChiTietSanPham ctsp) {
        ctsp.setNgayTao(LocalDate.now());
        ctspi.add(ctsp);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
    @GetMapping("/view-update-chi-tiet-san-pham/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("ctsp", ctspi.getById(id));
        model.addAttribute("SanPham", spi.getAll());
        model.addAttribute("MauSac", msi.getAll());
        model.addAttribute("Size", si.getAll());
        return "/chi-tiet-san-pham/update";
    }
    @PostMapping("/update-chi-tiet-san-pham/{id}")
    public String update(ChiTietSanPham ctsp, @PathVariable("id") Integer id) { //đừng thấy biến id ko dùng đến mà xóa
        ctsp.setNgaySua(LocalDate.now());
        ctspi.update(ctsp);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
}
