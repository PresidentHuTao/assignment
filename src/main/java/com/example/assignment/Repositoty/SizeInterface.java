package com.example.assignment.Repositoty;

import com.example.assignment.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SizeInterface extends JpaRepository<Size, Integer> {
    String add = "insert into size (ma_size, ten_size, trang_thai, ngay_tao)" +
            "values (:#{#s.maSize}, :#{#s.tenSize}, :#{#s.trangThai}, :#{#s.ngayTao})";
    String delete = "delete from size where id = :id";
    String update = "update size set ma_size = :#{#s.maSize}, ten_size = :#{#s.tenSize}," +
            "trang_thai = :#{#s.trangThai}, ngay_sua = :#{#s.ngaySua} where id = :#{#s.id}";
    String getAll = "select * from size";
    String getById = "select * from size where id = :id";

    //truy vấn thì thêm annotation transaction và modifying còn ko thì thôi
    @Transactional
    @Modifying
    @Query(value = add, nativeQuery = true)
    void add(Size s);

    @Transactional
    @Modifying
    @Query(value = delete, nativeQuery = true)
    void delete(Integer id);

    @Transactional
    @Modifying
    @Query(value = update, nativeQuery = true)
    void update(Size s);

    @Query(value = getAll, nativeQuery = true)
    List<Size> getAll();

    @Query(value = getById, nativeQuery = true)
    Size getById(Integer id);
}
