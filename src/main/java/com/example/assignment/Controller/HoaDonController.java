package com.example.assignment.Controller;

import com.example.assignment.Entity.ChiTietSanPham;
import com.example.assignment.Entity.HoaDon;
import com.example.assignment.Entity.HoaDonChiTiet;
import com.example.assignment.Entity.NguoiDung;
import com.example.assignment.Repositoty.ChiTietSanPhamInterface;
import com.example.assignment.Repositoty.HoaDonChiTietInterface;
import com.example.assignment.Repositoty.HoaDonInterface;
import com.example.assignment.Repositoty.NguoiDungInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonInterface hdi;
    @Autowired
    private NguoiDungInterface ndi;
    @Autowired
    private ChiTietSanPhamInterface ctspi;
    @Autowired
    private HoaDonChiTietInterface hdcti;
    //các biến toàn cục
    String sdtTK; //sdt của 1 tài khoản
    Integer idHoaDon; //id của 1 hóa đơn

    //mở
    @GetMapping("/hoa-don/hien-thi")
    public String show(Model model) {
        model.addAttribute("list", hdi.getAll());
        return "ban-hang";
    }

    //thêm người dùng mới
    @PostMapping("/add-nd")
    public String addND(@ModelAttribute NguoiDung nd) {
        nd.setNgayTao(LocalDate.now());
        nd.setTrangThai("on");
        nd.setVaiTro("khách hàng");
        ndi.add(nd);
        return "redirect:/hoa-don/hien-thi";
    }

    //thiết lập người dùng cho hóa đơn tương ứng
    @GetMapping("/add-nd-hd")
    public String addNDHD() {
        return "addND";
    }

    //tìm kiếm theo sdt
    @GetMapping("/search")
    public String search(Model model, @RequestParam("search") String sdt) {
        Optional<NguoiDung> nd = Optional.ofNullable(ndi.getBySdt(sdt));
        if (nd.isPresent()) {
            model.addAttribute("nd", ndi.getBySdt(sdt));
            model.addAttribute("list", hdi.getAll());
            sdtTK = ndi.getBySdt(sdt).getSdt();
            return "ban-hang";
        } else {
            model.addAttribute("e_null", "ko tìm thấy, tạo acc mới?");
            model.addAttribute("list", hdi.getAll());
            return "ban-hang";
        }
    }

    //xóa hóa đơn
    @GetMapping("/delete-hoa-don/{id}")
    public String delete(@PathVariable Integer id) {
        hdi.delete(id);
        return "redirect:/hoa-don/hien-thi";
    }

    //xóa hdct (xóa thì phải +1 slg tồn cho ctsp tương ứng)
    @GetMapping("/delete-hdct/{id}")
    public String deleteHDCT(@PathVariable Integer id, Model model) {
        //trong hdct cần xóa có lưu ctsp tương ứng, lấy id của ctsp đó để +1 slg tồn cho nó
        HoaDonChiTiet hdct = hdcti.getById(id);
        Integer idctsp = hdct.getChiTietSanPham().getId();
        ChiTietSanPham ctsp = ctspi.getById(idctsp);
        ctsp.setSoLuongTon(ctsp.getSoLuongTon() + 1);
        hdcti.delete(id);
        model.addAttribute("list", ctspi.getAll());
        model.addAttribute("listSelect", hdcti.getAllById(idHoaDon));
        return "select";
    }

    //mở form thêm sp vào giỏ hàng
    @GetMapping("/select/{id}")
    public String select(@PathVariable("id") Integer id, Model model, HoaDonChiTiet hdct) {
        HoaDon hd = hdi.getById(idHoaDon);
        ChiTietSanPham ctsp = ctspi.getById(id);
        ctsp.setSoLuongTon(ctsp.getSoLuongTon() - 1);
        hdct.setNgayTao(LocalDate.now());
        hdct.setHoaDon(hd);
        hdct.setChiTietSanPham(ctsp);
        hdct.setTrangThai("on");
        hdct.setSoLuongMua(1);
        hdct.setGiaBan(ctsp.getGiaBan());
        //tính tổng tiền sản phẩm
        BigDecimal slg = BigDecimal.valueOf(hdct.getSoLuongMua());
        BigDecimal gb = hdct.getGiaBan();
        hdct.setTongTien(slg.multiply(gb));
        hdcti.add(hdct);
        model.addAttribute("list", ctspi.getAll());
        model.addAttribute("listSelect", hdcti.getAllById(idHoaDon));
        return "select";
    }

    //tạo hóa đơn
    @PostMapping("/add-hoa-don")
    public String addHD(@ModelAttribute HoaDon hd) {
        NguoiDung nd = ndi.getBySdt(sdtTK);
        hd.setNgayTao(LocalDate.now());
        hd.setNguoiDung(nd);
        hd.setTrangThai("off");
        hdi.add(hd);
        return "redirect:/hoa-don/hien-thi";
    }

    //tạo hdct
    @GetMapping("/add-hdct/{id}")
    public String showSelectForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("list", ctspi.getAll());
        idHoaDon = id;
        model.addAttribute("listSelect", hdcti.getAllById(idHoaDon));
        return "select";
    }

    //thanh toán và setTrangThai cho hóa đơn = 'on' (on là đã thanh toán thì ko hiển thị)
    @PostMapping("/thanh-toan")
    public String thanhToan(Model model) {
        hdi.updateTrangThai(idHoaDon);
        model.addAttribute("list", hdi.getAll());
        return "redirect:/hoa-don/hien-thi";
    }
}
