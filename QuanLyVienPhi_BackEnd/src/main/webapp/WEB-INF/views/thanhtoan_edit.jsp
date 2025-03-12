<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Thanh Toán</title>
    <style>
        .error { color: red; }
        table { border-collapse: collapse; }
        td { padding: 5px; }
    </style>
</head>
<body>
    <h2>Sửa Thanh Toán</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form:form action="${pageContext.request.contextPath}/thanhtoan/edit" 
               method="post" 
               modelAttribute="thanhToan">
        <form:hidden path="maThanhToan"/>
        <table>
            <tr>
                <td>Mã Hóa Đơn:</td>
                <td>
                    <form:input path="maHoaDon" required="true"/>
                    <form:errors path="maHoaDon" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Phương Thức:</td>
                <td>
                    <form:input path="phuongThuc" required="true"/>
                    <form:errors path="phuongThuc" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Số Tiền:</td>
                <td>
                    <form:input path="soTien" required="true"/>
                    <form:errors path="soTien" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Ngày Thanh Toán:</td>
                <td>
                    <form:input path="ngayThanhToan" type="datetime-local"/>
                    <form:errors path="ngayThanhToan" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Ghi Chú:</td>
                <td>
                    <form:input path="ghiChu"/>
                    <form:errors path="ghiChu" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Lưu</button></td>
            </tr>
        </table>
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/thanhtoan_list">Quay lại danh sách</a>
</body>
</html>