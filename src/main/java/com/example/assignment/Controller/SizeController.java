package com.example.assignment.Controller;

import com.example.assignment.Entity.Size;
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
public class SizeController {
    @Autowired
    private SizeInterface si;

    @GetMapping("/size/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", si.getAll());
        return "/size/list";
    }

    @GetMapping("/delete-size/{id}")
    public String delete(@PathVariable Integer id) {
        si.delete(id);
        return "redirect:/size/hien-thi";
    }

    @PostMapping("/add-size")
    public String add(@ModelAttribute Size s) {
        s.setNgayTao(LocalDate.now());
        si.add(s);
        return "redirect:/size/hien-thi";
    }

    @GetMapping("/view-update-size/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("s", si.getById(id));
        return "/size/update";
    }

    @PostMapping("/update-size/{id}")
    public String update(Size s, @PathVariable("id") Integer id) { //đừng thấy biến id ko dùng đến mà xóa
        s.setNgaySua(LocalDate.now());
        si.update(s);
        return "redirect:/size/hien-thi";
    }
}
