<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="csrf-token" content="${_csrf.token}">
    <style>
        a {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            display: inline-flex;
            justify-content: center;
            align-items: center;
            width: 80px;
            height: 50px;
            border: 1px solid #ccc;
            padding: 0 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <br>
    <h1>Danh sách sản phẩm trong kho:</h1>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Id</th>
            <th>Giá bán</th>
            <th>Số lượng tồn</th>
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
                <td>${ctsp.sanPham.tenSanPham}</td>
                <td>${ctsp.mauSac.tenMau}</td>
                <td>${ctsp.size.tenSize}</td>
                <td>
                        <%--                    gọi ra cái hàm tính tiền ở dưới--%>
                    <a href="/select/${ctsp.id}" onclick="calculateInvoiceTotal()" class="btn btn-success">Select</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h1>Giỏ hàng:</h1>
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Màu sắc</th>
            <th>Size</th>
            <th>Đơn giá</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSelect}" var="select">
            <tr>
                <td>${select.chiTietSanPham.sanPham.tenSanPham}</td>
                <td>${select.chiTietSanPham.mauSac.tenMau}</td>
                <td>${select.chiTietSanPham.size.tenSize}</td>
                    <%--                tolalPrice: 1 biến trong hàm--%>
                <td class="totalPrice">${select.tongTien}</td>
                <td>
<%--                    <a href="/add1/${select.id}" class="btn btn-success">+1</a>--%>
<%--                    <a href="/minus1/${select.id}" class="btn btn-primary">-1</a>--%>
                    <a href="/delete-hdct/${select.id}" class="btn btn-warning">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/thanh-toan" method="post">
        <div class="col-md-3">
            <label class="form-label">Tổng tiền (hóa đơn)</label>
            <%--            ô input tổng tiền hóa đơn--%>
            <input type="number" class="form-control" name="tongTienHoaDon" id="invoiceTotal" readonly>
            <br>
            <button type="submit" class="btn btn-success">Thanh toán</button>
        </div>
    </form>
    <a href="/hoa-don/hien-thi" style="float: right" class="btn btn-primary">Back</a>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    //hàm này lấy ra giá trị của tất cả các ô thuộc cột tổng tiền sản phẩm cộng lại với nhau thành tổng tiền hóa đơn
    //rồi truyền vào ô input
    function calculateInvoiceTotal() {
        const totalPrices = document.querySelectorAll('.totalPrice');
        let total = 0;
        totalPrices.forEach(priceCell => {
            total += parseFloat(priceCell.textContent);
        });
        document.getElementById('invoiceTotal').value = total.toFixed(2);
    }

    window.onload = calculateInvoiceTotal;
</script>
</html>