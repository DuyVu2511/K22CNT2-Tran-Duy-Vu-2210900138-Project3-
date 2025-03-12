<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Hồ Sơ Khám</title>
    <style>
        .error { color: red; }
        table { border-collapse: collapse; }
        td { padding: 5px; }
    </style>
</head>
<body>
    <h2>Sửa Hồ Sơ Khám</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form:form action="${pageContext.request.contextPath}/hosokham/edit" 
               method="post" 
               modelAttribute="hoSoKham">
        <form:hidden path="maHoSo"/>
        <table>
            <tr>
                <td>Mã Bệnh Nhân:</td>
                <td>
                    <form:input path="maBenhNhan" required="true"/>
                    <form:errors path="maBenhNhan" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Ngày Khám:</td>
                <td>
                    <form:input path="ngayKham" type="datetime-local" required="true"/>
                    <form:errors path="ngayKham" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Chẩn Đoán:</td>
                <td>
                    <form:input path="chanDoan" required="true"/>
                    <form:errors path="chanDoan" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Bác Sĩ Điều Trị:</td>
                <td>
                    <form:input path="bacSiDieuTri" required="true"/>
                    <form:errors path="bacSiDieuTri" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Trạng Thái:</td>
                <td>
                    <form:select path="trangThai">
                        <form:option value="true">Hoàn Thành</form:option>
                        <form:option value="false">Chưa Hoàn Thành</form:option>
                    </form:select>
                    <form:errors path="trangThai" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Lưu</button></td>
            </tr>
        </table>
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/hosokham_list">Quay lại danh sách</a>
</body>
</html>