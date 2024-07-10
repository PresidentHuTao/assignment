package com.example.assignment.Repositoty;

import com.example.assignment.Entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HoaDonInterface extends JpaRepository<HoaDon, Integer> {
    String add = "insert into hoa_don (id_nguoi_dung, trang_thai, ngay_tao, dia_chi, so_dien_thoai)" +
            "values (:#{#hd.nguoiDung.id}, :#{#hd.trangThai}, :#{#hd.ngayTao}, :#{#hd.diaChi}, :#{#hd.soDienThoai})";
    String delete = "delete from hoa_don where id = :id";
    String update = "update hoa_don set id_nguoi_dung = :#{#hd.nguoiDung.id}, trang_thai = :#{#hd.trangThai}," +
            "ngay_sua = :#{#hd.ngaySua}, dia_chi = :#{#hd.diaChi}, so_dien_thoai = :#{#hd.soDienThoai}" +
            "where id = :#{#hd.id}";
    //on là đã thanh toán và ngược lại, những hd đã thanh toán thì ko hiển thị trên danh sách
    String updateTrangThai = "update hoa_don set trang_thai = 'on' where id = :id";
    String getAll = "select * from hoa_don where trang_thai = 'off'";
    String getById = "select * from hoa_don where id = :id";

    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(HoaDon hd);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(HoaDon hd);
    @Transactional
    @Modifying
    @Query(value = updateTrangThai, nativeQuery = true)
    void updateTrangThai(Integer id);

    @Query(value = getAll, nativeQuery = true)
    List<HoaDon> getAll();

    @Query(value = getById, nativeQuery = true)
    HoaDon getById(Integer id);
}
