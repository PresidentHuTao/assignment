package com.example.assignment.Repositoty;

import com.example.assignment.Entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChiTietSanPhamInterface extends JpaRepository<ChiTietSanPham, Integer> {
    String add = "insert into ctsp (gia_ban, so_luong_ton, trang_thai, ngay_tao, id_sp, id_mau_sac, id_size)" +
            "values (:#{#ctsp.giaBan}, :#{#ctsp.soLuongTon}, :#{#ctsp.trangThai}, :#{#ctsp.ngayTao}," +
            ":#{#ctsp.sanPham.id}, :#{#ctsp.mauSac.id}, :#{#ctsp.size.id})";
    String delete = "delete from ctsp where id = :id";
    String update = "update ctsp set gia_ban = :#{#ctsp.giaBan}, so_luong_ton = :#{#ctsp.soLuongTon}," +
            "trang_thai = :#{#ctsp.trangThai}, ngay_sua = :#{#ctsp.ngaySua}, id_sp = :#{#ctsp.sanPham.id}," +
            "id_mau_sac = :#{#ctsp.mauSac.id}, id_size = :#{#ctsp.size.id} where id = :#{#ctsp.id}";
    String getAll = "select * from ctsp";
    String getById = "select * from ctsp where id = :id";

    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(ChiTietSanPham ctsp);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(ChiTietSanPham ctsp);

    @Query(value = getAll, nativeQuery = true)
    List<ChiTietSanPham> getAll();

    @Query(value = getById, nativeQuery = true)
    ChiTietSanPham getById(Integer id);
}
