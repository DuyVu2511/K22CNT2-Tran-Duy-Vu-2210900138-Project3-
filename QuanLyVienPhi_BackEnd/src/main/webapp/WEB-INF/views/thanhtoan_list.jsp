<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Thanh Toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Danh Sách Thanh Toán</h2>
        <a href="thanhtoan_add" class="btn btn-primary mb-3">Thêm Thanh Toán</a>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Mã Thanh Toán</th>
                    <th>Mã Hóa Đơn</th>
                    <th>Phương Thức</th>
                    <th>Số Tiền</th>
                    <th>Ngày Thanh Toán</th>
                    <th>Ghi Chú</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="thanhToan" items="${thanhToans}">
                    <tr>
                        <td>${thanhToan.maThanhToan}</td>
                        <td>${thanhToan.maHoaDon}</td>
                        <td>${thanhToan.phuongThuc}</td>
                        <td>${thanhToan.soTien}</td>
                        <td>${thanhToan.ngayThanhToan}</td>
                        <td>${thanhToan.ghiChu}</td>
                        <td>
                            <a href="thanhtoan_edit/${thanhToan.maThanhToan}" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="thanhtoan_delete/${thanhToan.maThanhToan}" class="btn btn-danger btn-sm" 
                               onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>