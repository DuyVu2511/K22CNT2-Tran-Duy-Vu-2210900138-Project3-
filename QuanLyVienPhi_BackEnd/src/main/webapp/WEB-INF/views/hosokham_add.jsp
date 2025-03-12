<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Hồ Sơ Khám</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Thêm Hồ Sơ Khám</h2>
        <form:form modelAttribute="hoSoKham" action="${pageContext.request.contextPath}/hosokham/save" method="post">
            <div class="mb-3">
                <label for="maBenhNhan" class="form-label">Mã Bệnh Nhân</label>
                <form:input path="maBenhNhan" class="form-control" id="maBenhNhan" required="true"/>
            </div>
            <div class="mb-3">	
                <label for="ngayKham" class="form-label">Ngày Khám</label>
                <form:input path="ngayKham" class="form-control" id="ngayKham" type="datetime-local" required="true"/>
            </div>
            <div class="mb-3">
                <label for="chanDoan" class="form-label">Chẩn Đoán</label>
                <form:input path="chanDoan" class="form-control" id="chanDoan" required="true"/>
            </div>
            <div class="mb-3">
                <label for="bacSiDieuTri" class="form-label">Bác Sĩ Điều Trị</label>
                <form:input path="bacSiDieuTri" class="form-control" id="bacSiDieuTri" required="true"/>
            </div>
            <div class="mb-3">
                <label for="trangThai" class="form-label">Trạng Thái</label>
                <form:select path="trangThai" class="form-control" id="trangThai">
                    <form:option value="true">Hoàn Thành</form:option>
                    <form:option value="false">Chưa Hoàn Thành</form:option>
                </form:select>
            </div>
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="/hosokham_list" class="btn btn-secondary">Hủy</a>
        </form:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>