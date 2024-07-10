package com.example.assignment.Repositoty;

import com.example.assignment.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NguoiDungInterface extends JpaRepository<NguoiDung, Integer> {
    String add = "insert into nguoi_dung (ho_ten, vai_tro, mat_khau, dia_chi, sdt, trang_thai, ngay_tao)" +
            "values (:#{#nd.hoTen}, :#{#nd.vaiTro}, :#{#nd.matKhau}, :#{#nd.diaChi}, :#{#nd.sdt}, " +
            ":#{#nd.trangThai}, :#{#nd.ngayTao})";
    String delete = "delete from nguoi_dung where id = :id";
    String update = "update nguoi_dung set ho_ten = :#{#nd.hoTen}, vai_tro = :#{#nd.vaiTro}," +
            "mat_khau = :#{#nd.matKhau}, dia_chi = :#{#nd.diaChi}, sdt = :#{#nd.sdt}, trang_thai = :#{#nd.trangThai}," +
            "ngay_sua = :#{#nd.ngaySua} where id = :#{#nd.id}";
    String getAll = "select * from nguoi_dung";
    String getById = "select * from nguoi_dung where id = :id";
    String getBySdt = "select * from nguoi_dung where sdt = :sdt";

    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(NguoiDung nd);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(NguoiDung nd);

    @Query(value = getAll, nativeQuery = true)
    List<NguoiDung> getAll();

    @Query(value = getById, nativeQuery = true)
    NguoiDung getById(Integer id);

    @Query(value = getBySdt, nativeQuery = true)
    NguoiDung getBySdt(String sdt);
}
