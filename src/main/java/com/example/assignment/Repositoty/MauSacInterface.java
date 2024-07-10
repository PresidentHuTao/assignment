package com.example.assignment.Repositoty;

import com.example.assignment.Entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MauSacInterface extends JpaRepository<MauSac, Integer> {
    String add = "insert into mau_sac (ma_mau, ten_mau, trang_thai, ngay_tao)" +
            "values (:#{#ms.maMau}, :#{#ms.tenMau}, :#{#ms.trangThai}, :#{#ms.ngayTao})";
    String delete = "delete from mau_sac where id = :id";
    String update = "update mau_sac set ma_mau = :#{#ms.maMau}, ten_mau = :#{#ms.tenMau}," +
            "trang_thai = :#{#ms.trangThai}, ngay_sua = :#{#ms.ngaySua} where id = :#{#ms.id}";
    String getAll = "select * from mau_sac";
    String getById = "select * from mau_sac where id = :id";

    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(MauSac ms);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(MauSac ms);

    @Query(value = getAll, nativeQuery = true)
    List<MauSac> getAll();

    @Query(value = getById, nativeQuery = true)
    MauSac getById(Integer id);
}
