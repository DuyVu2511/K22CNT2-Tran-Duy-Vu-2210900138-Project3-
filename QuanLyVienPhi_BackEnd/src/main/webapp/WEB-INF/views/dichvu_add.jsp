<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Thêm Dịch Vụ</h2>
        <form:form modelAttribute="dichVu" action="${pageContext.request.contextPath}/dichvu/save" method="post">
            <div class="mb-3">
                <label for="tenDichVu" class="form-label">Tên Dịch Vụ</label>
                <form:input path="tenDichVu" class="form-control" id="tenDichVu" required="true"/>
            </div>
            <div class="mb-3">
                <label for="moTa" class="form-label">Mô Tả</label>
                <form:input path="moTa" class="form-control" id="moTa"/>
            </div>
            <div class="mb-3">
                <label for="donGia" class="form-label">Đơn Giá</label>
                <form:input path="donGia" class="form-control" id="donGia" required="true" type="number" step="0.01"/>
            </div>
            <div class="mb-3">
                <label for="trangThai" class="form-label">Trạng Thái</label>
                <form:input path="trangThai" class="form-control" id="trangThai"/>
            </div>
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="/dichvu_list" class="btn btn-secondary">Hủy</a>
        </form:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>