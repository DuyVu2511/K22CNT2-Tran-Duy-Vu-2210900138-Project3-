<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Danh Sách Dịch Vụ</h2>
        <a href="dichvu_add" class="btn btn-primary mb-3">Thêm Dịch Vụ</a>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Mã Dịch Vụ</th>
                    <th>Tên Dịch Vụ</th>
                    <th>Mô Tả</th>
                    <th>Đơn Giá</th>
                    <th>Trạng Thái</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dichVu" items="${dichVus}">
                    <tr>
                        <td>${dichVu.maDichVu}</td>
                        <td>${dichVu.tenDichVu}</td>
                        <td>${dichVu.moTa}</td>
                        <td>${dichVu.donGia}</td>
                        <td>${dichVu.trangThai}</td>
                        <td>
                            <a href="dichvu_edit/${dichVu.maDichVu}" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="dichvu_delete/${dichVu.maDichVu}" class="btn btn-danger btn-sm" 
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