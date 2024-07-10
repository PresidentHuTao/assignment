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
    <form action="/add-nguoi-dung" method="post">
        <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input type="text" class="form-control" name="hoTen">
        </div>
        <div class="md-3">
            <label for="rel" class="form-label">Vai trò</label>
            <select id="rel" class="form-select" name="vaiTro">
                <option value="khách hàng">khách hàng</option>
                <option value="nhân viên">nhân viên</option>
                <option value="quản lý">quản lý</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="text" class="form-control" name="matKhau">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi">
        </div>
        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="sdt">
        </div>
        <div class="mb-3">
            <p>Trạng thái</p>
            <div class="form-check">
                <label class="form-check-label">
                    on
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='on' checked>
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    off
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='off'>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
    <br>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>Họ tên</th>
            <th>Vai trò</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nd">
            <tr>
                <td>${nd.id}</td>
                <td>${nd.hoTen}</td>
                <td>${nd.vaiTro}</td>
                <td>${nd.diaChi}</td>
                <td>${nd.sdt}</td>
                <td>
                    <c:if test="${nd.trangThai == 'on'}">on</c:if>
                    <c:if test="${nd.trangThai == 'off'}">off</c:if>
                </td>
                <td>${nd.ngayTao}</td>
                <td>${nd.ngaySua}</td>
                <td>
                    <a href="/delete-nguoi-dung/${nd.id}" class="btn btn-danger">Delete</a>
                    <a href="/view-update-nguoi-dung/${nd.id}" class="btn btn-warning">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>