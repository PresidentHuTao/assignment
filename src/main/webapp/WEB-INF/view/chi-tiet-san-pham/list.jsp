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
    <form action="/add-chi-tiet-san-pham" method="post">
        <div class="mb-3">
            <label class="form-label">Giá bán</label>
            <input type="number" class="form-control" name="giaBan">
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng tồn</label>
            <input type="number" class="form-control" name="soLuongTon">
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
        <div class="col-md-6">
            <label for="rel1" class="form-label">Loại (sản phẩm)</label>
            <select id="rel1" class="form-select" name="sanPham">
                <c:forEach items="${SanPham}" var="sp">
                    <option value="${sp.id}">${sp.tenSanPham}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-6">
            <label for="rel2" class="form-label">Màu sắc</label>
            <select id="rel2" class="form-select" name="mauSac">
                <c:forEach items="${MauSac}" var="ms">
                    <option value="${ms.id}">${ms.tenMau}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-6">
            <label for="rel3" class="form-label">Size</label>
            <select id="rel3" class="form-select" name="size">
                <c:forEach items="${Size}" var="s">
                    <option value="${s.id}">${s.tenSize}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
    <br>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>Giá bán</th>
            <th>Số lượng tồn</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Tên</th>
            <th>Màu sắc</th>
            <th>Size</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="ctsp">
            <tr>
                <td>${ctsp.id}</td>
                <td>${ctsp.giaBan}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>
                    <c:if test="${ctsp.trangThai == 'on'}">on</c:if>
                    <c:if test="${ctsp.trangThai == 'off'}">off</c:if>
                </td>
                <td>${ctsp.ngayTao}</td>
                <td>${ctsp.ngaySua}</td>
                <td>${ctsp.sanPham.tenSanPham}</td>
                <td>${ctsp.mauSac.tenMau}</td>
                <td>${ctsp.size.tenSize}</td>
                <td>
                    <a href="/delete-chi-tiet-san-pham/${ctsp.id}" class="btn btn-danger">Delete</a>
                    <a href="/view-update-chi-tiet-san-pham/${ctsp.id}" class="btn btn-warning">Update</a>
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