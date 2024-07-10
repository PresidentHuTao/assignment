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
    <form action="/add-size" method="post">
        <div class="mb-3">
            <label class="form-label">Mã size</label>
            <input type="text" class="form-control" name="maSize">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên size</label>
            <input type="text" class="form-control" name="tenSize">
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
            <th>Mã size</th>
            <th>Tên size</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.maSize}</td>
                <td>${s.tenSize}</td>
                <td>
                    <c:if test="${s.trangThai == 'on'}">on</c:if>
                    <c:if test="${s.trangThai == 'off'}">off</c:if>
                </td>
                <td>${s.ngayTao}</td>
                <td>${s.ngaySua}</td>
                <td>
                    <a href="/delete-size/${s.id}" class="btn btn-danger">Delete</a>
                    <a href="/view-update-size/${s.id}" class="btn btn-warning">Update</a>
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