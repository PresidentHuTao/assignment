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
    <form action="/update-chi-tiet-san-pham/${ctsp.id}" method="post">
        <div class="mb-3">
            <label class="form-label">Giá bán</label>
            <input type="number" class="form-control" name="giaBan" value='${ctsp.giaBan}'>
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng tồn</label>
            <input type="number" class="form-control" name="soLuongTon" value='${ctsp.soLuongTon}'>
        </div>
        <div class="mb-3">
            <p>Trạng thái</p>
            <div class="form-check">
                <label class="form-check-label">
                    on
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='on'
                       <c:if test="${ctsp.trangThai == 'on'}">checked</c:if>
                >
            </div>
            <div class="form-check">
                <label class="form-check-label">
                    off
                </label>
                <input class="form-check-input" type="radio" name="trangThai" value='off'
                       <c:if test="${ctsp.trangThai == 'off'}">checked</c:if>
                >
            </div>
        </div>
        <div class="mb-3">
            <label for="rel1" class="form-label">Loại (sản phẩm)</label>
            <select id="rel1" class="form-select" name="sanPham">
                <c:forEach items="${SanPham}" var="sp">
                    <option value="${sp.id}"
                            <c:if test="${ctsp.sanPham.tenSanPham == sp.tenSanPham}">selected</c:if>
                    >${sp.tenSanPham}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="rel2" class="form-label">Màu sắc</label>
            <select id="rel2" class="form-select" name="mauSac">
                <c:forEach items="${MauSac}" var="ms">
                    <option value="${ms.id}"
                            <c:if test="${ctsp.mauSac.tenMau == ms.tenMau}">selected</c:if>
                    >${ms.tenMau}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="rel3" class="form-label">Size</label>
            <select id="rel3" class="form-select" name="size">
                <c:forEach items="${Size}" var="s">
                    <option value="${s.id}"
                            <c:if test="${ctsp.size.tenSize == s.tenSize}">selected</c:if>
                    >${s.tenSize}</option>
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