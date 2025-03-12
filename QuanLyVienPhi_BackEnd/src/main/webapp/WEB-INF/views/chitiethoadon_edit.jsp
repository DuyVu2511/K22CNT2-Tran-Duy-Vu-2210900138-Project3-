<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Chi Tiết Hóa Đơn</title>
    <style>
        .error { color: red; }
        table { border-collapse: collapse; }
        td { padding: 5px; }
    </style>
</head>
<body>
    <h2>Sửa Chi Tiết Hóa Đơn</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form:form action="${pageContext.request.contextPath}/chitiethoadon/edit" 
               method="post" 
               modelAttribute="chiTietHoaDon">
        <form:hidden path="maChiTiet"/>
        <table>
            <tr>
                <td>Mã Hóa Đơn:</td>
                <td>
                    <form:input path="maHoaDon" required="true"/>
                    <form:errors path="maHoaDon" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Mã Dịch Vụ:</td>
                <td>
                    <form:input path="maDichVu" required="true"/>
                    <form:errors path="maDichVu" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Số Lượng:</td>
                <td>
                    <form:input path="soLuong" required="true"/>
                    <form:errors path="soLuong" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Thành Tiền:</td>
                <td>
                    <form:input path="thanhTien" required="true"/>
                    <form:errors path="thanhTien" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Lưu</button></td>
            </tr>
        </table>
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/chitiethoadon_list">Quay lại danh sách</a>
</body>
</html>