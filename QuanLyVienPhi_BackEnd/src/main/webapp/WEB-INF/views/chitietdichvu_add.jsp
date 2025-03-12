<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Chi Tiết Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Thêm Chi Tiết Dịch Vụ</h2>
        <form:form modelAttribute="chiTietDichVu" action="${pageContext.request.contextPath}/chitietdichvu/save" method="post">
            <div class="mb-3">
                <label for="maHoSo" class="form-label">Mã Hồ Sơ</label>
                <form:input path="maHoSo" class="form-control" id="maHoSo" required="true"/>
            </div>
            <div class="mb-3">
                <label for="maDichVu" class="form-label">Mã Dịch Vụ</label>
                <form:input path="maDichVu" class="form-control" id="maDichVu" required="true"/>
            </div>
            <div class="mb-3">
                <label for="soLuong" class="form-label">Số Lượng</label>
                <form:input path="soLuong" class="form-control" id="soLuong" required="true"/>
            </div>
            <div class="mb-3">
                <label for="thanhTien" class="form-label">Thành Tiền</label>
                <form:input path="thanhTien" class="form-control" id="thanhTien" required="true"/>
            </div>
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="/chitietdichvu_list" class="btn btn-secondary">Hủy</a>
        </form:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>