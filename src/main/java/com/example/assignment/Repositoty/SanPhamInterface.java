package com.example.assignment.Repositoty;

import com.example.assignment.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SanPhamInterface extends JpaRepository<SanPham, Integer> {
    String add = "insert into san_pham (ma_san_pham, ten_san_pham, trang_thai, ngay_tao, id_danh_muc)" +
            "values (:#{#sp.maSanPham}, :#{#sp.tenSanPham}, :#{#sp.trangThai}, :#{#sp.ngayTao}, :#{#sp.danhMuc.id})";
    String delete = "delete from san_pham where id = :id";
    String update = "update san_pham set ma_san_pham = :#{#sp.maSanPham}, ten_san_pham = :#{#sp.tenSanPham}," +
            "trang_thai = :#{#sp.trangThai}, ngay_sua = :#{#sp.ngaySua}, id_danh_muc = :#{#sp.danhMuc.id} where id = :#{#sp.id}";
    String getAll = "select * from san_pham";
    String getById = "select * from san_pham where id = :id";
    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(SanPham sp);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(SanPham sp);

    @Query(value = getAll, nativeQuery = true)
    List<SanPham> getAll();

    @Query(value = getById, nativeQuery = true)
    SanPham getById(Integer id);
}
