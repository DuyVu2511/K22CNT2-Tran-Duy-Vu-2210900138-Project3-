<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Hóa Đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Thêm Hóa Đơn</h2>
        <form:form modelAttribute="hoaDon" action="${pageContext.request.contextPath}/hoadon/save" method="post">
            <div class="mb-3">
                <label for="maBenhNhan" class="form-label">Mã Bệnh Nhân</label>
                <form:input path="maBenhNhan" class="form-control" id="maBenhNhan" required="true"/>
            </div>
            <div class="mb-3">
                <label for="ngayLap" class="form-label">Ngày Lập</label>
                <form:input path="ngayLap" class="form-control" id="ngayLap" type="datetime-local" required="true"/>
            </div>
            <div class="mb-3">
                <label for="tongTien" class="form-label">Tổng Tiền</label>
                <form:input path="tongTien" class="form-control" id="tongTien" required="true"/>
            </div>
            <div class="mb-3">
                <label for="baoHiemHoTro" class="form-label">Bảo Hiểm Hỗ Trợ</label>
                <form:input path="baoHiemHoTro" class="form-control" id="baoHiemHoTro" required="true"/>
            </div>
            <div class="mb-3">
                <label for="soTienPhaiTra" class="form-label">Số Tiền Phải Trả</label>
                <form:input path="soTienPhaiTra" class="form-control" id="soTienPhaiTra" required="true"/>
            </div>
            <div class="mb-3">
                <label for="trangThaiThanhToan" class="form-label">Trạng Thái Thanh Toán</label>
                <form:input path="trangThaiThanhToan" class="form-control" id="trangThaiThanhToan" required="true"/>
            </div>
            <button type="submit" class="btn btn-success">Lưu</button>
            <a href="/hoadon_list" class="btn btn-secondary">Hủy</a>
        </form:form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>