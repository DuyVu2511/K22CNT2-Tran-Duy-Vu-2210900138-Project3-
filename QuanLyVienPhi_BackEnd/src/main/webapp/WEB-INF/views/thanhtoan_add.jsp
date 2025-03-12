<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Thanh Toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Thêm Thanh Toán</h2>
        <form:form modelAttribute="thanhToan" action="${pageContext.request.contextPath}/thanhtoan/save" method="post">
            <div class="mb-3">
                <label for="maHoaDon" class="form-label">Mã Hóa Đơn</label>
                <form:input path="maHoaDon" class="form-control" id="maHoaDon" required="true"/>
            </div>
            <div class="mb-3">
                <label for="phuongThuc" class="form-label">Phương Thức</label>
                <form:input path="phuongThuc" class="form-control" id="phuongThuc" required="true"/>
            </div>
            <div class="mb-3">
                <label for="soTien" class="form-label">Số Tiền</label>
                <form:input path="soTien" class="form-control" id="soTien" required="true"/>
            </div>
            <div class="mb-3">
                <label for="ngayThanhToan" class="form-label">Ngày Thanh Toán</label>
                <form:input path="ngayThanhToan" type="datetime-local" class="form-control" id="ngayThanhToan"/>
            </div>
            <div class="mb-3">
                <label for="ghiChu" class="form-label">Ghi Chú</label>
                <form:input path="ghiChu" class="form-control" id="ghiChu"/>
            </div>
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="/thanhtoan_list" class="btn btn-secondary">Hủy</a>
        </form:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>