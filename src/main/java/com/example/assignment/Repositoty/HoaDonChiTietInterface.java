package com.example.assignment.Repositoty;

import com.example.assignment.Entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HoaDonChiTietInterface extends JpaRepository<HoaDonChiTiet, Integer> {
    String getAll = "select * from hdct";

    String add = "insert into hdct (id_hoa_don, id_ctsp, so_luong_mua, gia_ban, tong_tien, trang_thai, ngay_tao)" +
            "values (:#{#hdct.hoaDon.id}, :#{#hdct.chiTietSanPham.id}, :#{#hdct.soLuongMua}, :#{#hdct.giaBan}," +
            ":#{#hdct.tongTien}, :#{#hdct.trangThai}, :#{#hdct.ngayTao})";

    String delete = "delete from hdct where id = :id";
    String getAllById = "select * from hdct where id_hoa_don = :id";
    String getById = "select * from hdct where id = :id";

    @Query(value = getAll, nativeQuery = true)
    List<HoaDonChiTiet> getAll();

    @Query(value = getAllById, nativeQuery = true)
    List<HoaDonChiTiet> getAllById(Integer id);

    @Query(value = getById, nativeQuery = true)
    HoaDonChiTiet getById(Integer id);

    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(HoaDonChiTiet hdct);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);
}
