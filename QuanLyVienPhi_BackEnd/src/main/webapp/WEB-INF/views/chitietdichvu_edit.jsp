	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<!DOCTYPE html>
	<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Sua Chi Tiet Dich Vu</title>
	    <style>
	        .error { color: red; }
	        table { border-collapse: collapse; }
	        td { padding: 5px; }
	    </style>
	</head>
	<body>
	    <h2>Sua Chi Tiet Dich Vu</h2>
	    <c:if test="${not empty error}">
	        <p class="error">${error}</p>
	    </c:if>
	    <form:form action="${pageContext.request.contextPath}/chitietdichvu/edit" 
	               method="post" 
	               modelAttribute="chiTietDichVu">
	        <form:hidden path="maChiTiet"/>
	        <table>
	            <tr>
	                <td>Ma Ho So:</td>
	                <td>
	                    <form:input path="maHoSo" required="true"/>
	                    <form:errors path="maHoSo" cssClass="error"/>
	                </td>
	            </tr>
	            <tr>
	                <td>Ma Dich Vu:</td>
	                <td>
	                    <form:input path="maDichVu" required="true"/>
	                    <form:errors path="maDichVu" cssClass="error"/>
	                </td>
	            </tr>
	            <tr>
	                <td>So Luong:</td>
	                <td>
	                    <form:input path="soLuong" required="true"/>
	                    <form:errors path="soLuong" cssClass="error"/>
	                </td>
	            </tr>
	            <tr>
	                <td>Thanh Tien:</td>
	                <td>
	                    <form:input path="thanhTien" required="true"/>
	                    <form:errors path="thanhTien" cssClass="error"/>
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2"><button type="submit">Luu</button></td>
	            </tr>
	        </table>
	    </form:form>
	    <br>
	    <a href="${pageContext.request.contextPath}/chitietdichvu_list">Quay lai danh sach</a>
	</body>
	</html>