<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Danh Sách Hóa Đơn</h2>
        <a href="hoadon_add" class="btn btn-primary mb-3">Thêm Hóa Đơn</a>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Mã Hóa Đơn</th>
                    <th>Mã Bệnh Nhân</th>
                    <th>Ngày Lập</th>
                    <th>Tổng Tiền</th>
                    <th>Bảo Hiểm Hỗ Trợ</th>
                    <th>Số Tiền Phải Trả</th>
                    <th>Trạng Thái Thanh Toán</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="hoaDon" items="${hoaDons}">
                    <tr>
                        <td>${hoaDon.maHoaDon}</td>
                        <td>${hoaDon.maBenhNhan}</td>
                        <td>${hoaDon.ngayLap}</td>
                        <td>${hoaDon.tongTien}</td>
                        <td>${hoaDon.baoHiemHoTro}</td>
                        <td>${hoaDon.soTienPhaiTra}</td>
                        <td>${hoaDon.trangThaiThanhToan}</td>
                        <td>
                            <a href="hoadon_edit/${hoaDon.maHoaDon}" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="hoadon_delete/${hoaDon.maHoaDon}" class="btn btn-danger btn-sm" 
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