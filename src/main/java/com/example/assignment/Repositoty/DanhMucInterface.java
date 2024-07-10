package com.example.assignment.Repositoty;

import com.example.assignment.Entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DanhMucInterface extends JpaRepository<DanhMuc, Integer> {
    String add = "insert into danh_muc (ma_danh_muc, ten_danh_muc, trang_thai, ngay_tao)" +
            "values (:#{#dm.maDanhMuc}, :#{#dm.tenDanhMuc}, :#{#dm.trangThai}, :#{#dm.ngayTao})";
    String delete = "delete from danh_muc where id = :id";
    String update = "update danh_muc set ma_danh_muc = :#{#dm.maDanhMuc}, ten_danh_muc = :#{#dm.tenDanhMuc}," +
            "trang_thai = :#{#dm.trangThai}, ngay_sua = :#{#dm.ngaySua} where id = :#{#dm.id}";
    String getAll = "select * from danh_muc";
    String getById = "select * from danh_muc where id = :id";

    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(DanhMuc dm);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(DanhMuc dm);

    @Query(value = getAll, nativeQuery = true)
    List<DanhMuc> getAll();

    @Query(value = getById, nativeQuery = true)
    DanhMuc getById(Integer id);
}
