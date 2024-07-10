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
    <form action="/search" method="get">
        <div class="col-md-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="search">
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <form action="/add-hoa-don" method="post">
        <div class="col-md-3">
            <label class="form-label">Họ tên</label>
            <input type="text" class="form-control" value='${nd.hoTen}'>
            <a href="/add-nd-hd"><span style="color: blue">${e_null}</span></a>
            <br>
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
    <h1>Danh sách hóa đơn chờ thanh toán:</h1>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>Khách hàng</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="hd">
            <tr>
                <td>${hd.id}</td>
                <td>${hd.nguoiDung.hoTen}</td>
                <td>
                    <a href="/delete-hoa-don/${hd.id}" class="btn btn-danger">Delete</a>
                    <a href="/add-hdct/${hd.id}" class="btn btn-warning">Select</a>
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