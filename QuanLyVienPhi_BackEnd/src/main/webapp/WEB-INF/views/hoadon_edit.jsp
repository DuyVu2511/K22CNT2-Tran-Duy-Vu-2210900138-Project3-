<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Hóa Đơn</title>
    <style>
        .error { color: red; }
        table { border-collapse: collapse; }
        td { padding: 5px; }
    </style>
</head>
<body>
    <h2>Sửa Hóa Đơn</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form:form action="${pageContext.request.contextPath}/hoadon/edit" 
               method="post" 
               modelAttribute="hoaDon">
        <form:hidden path="maHoaDon"/>
        <table>
            <tr>
                <td>Mã Bệnh Nhân:</td>
                <td>
                    <form:input path="maBenhNhan" required="true"/>
                    <form:errors path="maBenhNhan" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Ngày Lập:</td>
                <td>
                    <form:input path="ngayLap" type="datetime-local" required="true"/>
                    <form:errors path="ngayLap" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Tổng Tiền:</td>
                <td>
                    <form:input path="tongTien" required="true"/>
                    <form:errors path="tongTien" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Bảo Hiểm Hỗ Trợ:</td>
                <td>
                    <form:input path="baoHiemHoTro" required="true"/>
                    <form:errors path="baoHiemHoTro" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Số Tiền Phải Trả:</td>
                <td>
                    <form:input path="soTienPhaiTra" required="true"/>
                    <form:errors path="soTienPhaiTra" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Trạng Thái Thanh Toán:</td>
                <td>
                    <form:input path="trangThaiThanhToan" required="true"/>
                    <form:errors path="trangThaiThanhToan" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Lưu</button></td>
            </tr>
        </table>
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/hoadon_list">Quay lại danh sách</a>
</body>
</html>