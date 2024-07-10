<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="csrf-token" content="${_csrf.token}">
    <style>
        a {
            width: 150px;
            padding: 10px;
            margin: 5px;
            text-align: center;
            display: inline-block;
            line-height: normal;
        }
    </style>
</head>
<body>
<div class="container">
    <br>
    <a href="/chi-tiet-san-pham/hien-thi" class="btn btn-info">Chi tiết sản phẩm</a>
    <br><br>
    <a href="/danh-muc/hien-thi" class="btn btn-info">Danh mục</a>
    <br><br>
    <a href="/mau-sac/hien-thi" class="btn btn-info">Màu sắc</a>
    <br><br>
    <a href="/nguoi-dung/hien-thi" class="btn btn-info">Người dùng</a>
    <br><br>
    <a href="/san-pham/hien-thi" class="btn btn-info">Sản phẩm</a>
    <br><br>
    <a href="/size/hien-thi" class="btn btn-info">Size</a>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</html>