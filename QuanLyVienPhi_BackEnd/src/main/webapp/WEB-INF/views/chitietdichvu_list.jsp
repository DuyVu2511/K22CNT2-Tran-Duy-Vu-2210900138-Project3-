<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Chi Tiết Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Danh Sách Chi Tiết Dịch Vụ</h2>
        <a href="chitietdichvu_add" class="btn btn-primary mb-3">Thêm Chi Tiết Dịch Vụ</a>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Mã Chi Tiết</th>
                    <th>Mã Hồ Sơ</th>
                    <th>Mã Dịch Vụ</th>
                    <th>Số Lượng</th>
                    <th>Thành Tiền</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="chiTiet" items="${chiTietDichVus}">
                    <tr>
                        <td>${chiTiet.maChiTiet}</td>
                        <td>${chiTiet.maHoSo}</td>
                        <td>${chiTiet.maDichVu}</td>
                        <td>${chiTiet.soLuong}</td>
                        <td>${chiTiet.thanhTien}</td>
                        <td>
                            <a href="chitietdichvu_edit/${chiTiet.maChiTiet}" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="chitietdichvu_delete/${chiTiet.maChiTiet}" class="btn btn-danger btn-sm" 
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
