<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Hồ Sơ Khám</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Danh Sách Hồ Sơ Khám</h2>
        <a href="hosokham_add" class="btn btn-primary mb-3">Thêm Hồ Sơ Khám</a>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Mã Hồ Sơ</th>
                    <th>Mã Bệnh Nhân</th>
                    <th>Ngày Khám</th>
                    <th>Chẩn Đoán</th>
                    <th>Bác Sĩ Điều Trị</th>
                    <th>Trạng Thái</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="hoSo" items="${hoSoKhams}">
                    <tr>
                        <td>${hoSo.maHoSo}</td>
                        <td>${hoSo.maBenhNhan}</td>
                        <td>${hoSo.ngayKham}</td>
                        <td>${hoSo.chanDoan}</td>
                        <td>${hoSo.bacSiDieuTri}</td>
                        <td>${hoSo.trangThai ? 'Hoàn Thành' : 'Chưa Hoàn Thành'}</td>
                        <td>
                            <a href="hosokham_edit/${hoSo.maHoSo}" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="hosokham_delete/${hoSo.maHoSo}" class="btn btn-danger btn-sm" 
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