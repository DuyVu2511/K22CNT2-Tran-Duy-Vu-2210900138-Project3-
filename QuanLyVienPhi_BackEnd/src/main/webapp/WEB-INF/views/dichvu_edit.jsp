<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Dịch Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .error { color: red; }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Sửa Dịch Vụ</h2>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <form:form modelAttribute="dichVu" action="${pageContext.request.contextPath}/dichvu/edit" method="post">
            <form:hidden path="maDichVu"/>
            <div class="mb-3">
                <label for="tenDichVu" class="form-label">Tên Dịch Vụ</label>
                <form:input path="tenDichVu" class="form-control" id="tenDichVu" required="true"/>
                <form:errors path="tenDichVu" cssClass="error"/>
            </div>
            <div class="mb-3">
                <label for="moTa" class="form-label">Mô Tả</label>
                <form:input path="moTa" class="form-control" id="moTa"/>
                <form:errors path="moTa" cssClass="error"/>
            </div>
            <div class="mb-3">
                <label for="donGia" class="form-label">Đơn Giá</label>
                <form:input path="donGia" class="form-control" id="donGia" required="true" type="number" step="0.01"/>
                <form:errors path="donGia" cssClass="error"/>
            </div>
            <div class="mb-3">
                <label for="trangThai" class="form-label">Trạng Thái</label>
                <form:input path="trangThai" class="form-control" id="trangThai"/>
                <form:errors path="trangThai" cssClass="error"/>
            </div>
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="${pageContext.request.contextPath}/dichvu_list" class="btn btn-secondary">Quay lại danh sách</a>
        </form:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>