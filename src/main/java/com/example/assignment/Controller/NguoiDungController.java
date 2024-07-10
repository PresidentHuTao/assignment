package com.example.assignment.Controller;

import com.example.assignment.Entity.NguoiDung;
import com.example.assignment.Repositoty.NguoiDungInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class NguoiDungController {
    @Autowired
    private NguoiDungInterface ndi;

    @GetMapping("/nguoi-dung/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", ndi.getAll());
        return "/nguoi-dung/list";
    }

    @GetMapping("/delete-nguoi-dung/{id}")
    public String delete(@PathVariable Integer id) {
        ndi.delete(id);
        return "redirect:/nguoi-dung/hien-thi";
    }

    @PostMapping("/add-nguoi-dung")
    public String add(@ModelAttribute NguoiDung nd) {
        nd.setNgayTao(LocalDate.now());
        ndi.add(nd);
        return "redirect:/nguoi-dung/hien-thi";
    }

    @GetMapping("/view-update-nguoi-dung/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("nd", ndi.getById(id));
        return "/nguoi-dung/update";
    }

    @PostMapping("/update-nguoi-dung/{id}")
    public String update(NguoiDung nd, @PathVariable("id") Integer id) { //đừng thấy biến id ko dùng đến mà xóa
        nd.setNgaySua(LocalDate.now());
        ndi.update(nd);
        return "redirect:/nguoi-dung/hien-thi";
    }
}
