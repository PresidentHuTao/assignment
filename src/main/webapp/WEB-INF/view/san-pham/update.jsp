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
    <form action="/update-san-pham/${sp.id}" method="post">
        <div class="mb-3">
            <label class="form-label">Mã sản phẩm</label>
            <input type="text" class="form-control" name="maSanPham" value='${sp.maSanPham}'>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" name="tenSanPham" value='${sp.tenSanPham}'>
        </div>
        <div class="mb-3">
            <p>Trạng thái</p>
            <div class="form-check">
                <label class="form-check-label">
                    on
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='on'
                       <c:if test="${sp.trangThai == 'on'}">checked</c:if>
                >
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    off
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='off'
                       <c:if test="${sp.trangThai == 'off'}">checked</c:if>
                >
            </div>
        </div>
        <div class="mb-3">
            <label for="rel" class="form-label">Danh mục</label>
            <select id="rel" class="form-select" name="danhMuc">
                <c:forEach items="${DanhMuc}" var="dm">
                    <option value="${dm.id}"
                            <c:if test="${sp.danhMuc.tenDanhMuc == dm.tenDanhMuc}">selected</c:if>
                    >${dm.tenDanhMuc}</option>
                </c:forEach>
            </select>
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