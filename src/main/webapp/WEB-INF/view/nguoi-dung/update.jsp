<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="csrf-token" content="${_csrf.token}">
</head>
<body>
<div class="container">
    <br>
    <form action="/update-nguoi-dung/${nd.id}" method="post">
        <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input type="text" class="form-control" name="hoTen" value='${nd.hoTen}'>
        </div>
        <div class="md-3">
            <label for="rel" class="form-label">Vai trò</label>
            <select id="rel" class="form-select" name="vaiTro">
                <option value="khách hàng"
                        <c:if test="${nd.vaiTro == 'khách hàng'}">selected</c:if>
                >khách hàng
                </option>
                <option value="nhân viên"
                        <c:if test="${nd.vaiTro == 'nhân viên'}">selected</c:if>
                >nhân viên
                </option>
                <option value="quản lý"
                        <c:if test="${nd.vaiTro == 'quản lý'}">selected</c:if>
                >quản lý
                </option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="text" class="form-control" name="matKhau" value='${nd.matKhau}'>
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" value='${nd.diaChi}'>
        </div>
        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="sdt" value='${nd.sdt}'>
        </div>
        <div class="mb-3">
            <p>Trạng thái</p>
            <div class="form-check">
                <label class="form-check-label">
                    on
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='on'
                       <c:if test="${nd.trangThai == 'on'}">checked</c:if>
                >
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    off
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='off'
                       <c:if test="${nd.trangThai == 'off'}">checked</c:if>
                >
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
    <br>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>