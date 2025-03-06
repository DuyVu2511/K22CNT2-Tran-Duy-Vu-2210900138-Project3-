<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Chinh Sua Benh Nhan</title>
    <style>
        .error { color: red; }
        table { border-collapse: collapse; }
        td { padding: 5px; }
    </style>
</head>
<body>
    <h2>Chinh Sua Benh Nhan</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form:form action="${pageContext.request.contextPath}/benhnhan/edit" 
               method="post" 
               modelAttribute="benhNhan">
        <form:hidden path="maBenhNhan"/>
        <table>
            <tr>
                <td>Ho Ten:</td>
                <td><form:input path="hoTen" required="true"/><form:errors path="hoTen" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Ngay Sinh:</td>
                <td><form:input path="ngaySinh" type="date" required="true"/><form:errors path="ngaySinh" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Gioi Tinh:</td>
                <td>
                    <form:select path="gioiTinh" required="true">
                        <form:option value="">Chon gioi tinh</form:option>
                        <form:option value="Nam">Nam</form:option>
                        <form:option value="Nu">Nu</form:option>
                    </form:select>
                    <form:errors path="gioiTinh" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>CMND/CCCD:</td>
                <td><form:input path="cmndCccd" required="true"/><form:errors path="cmndCccd" cssClass="error"/></td>
            </tr>
            <tr>
                <td>So Dien Thoai:</td>
                <td><form:input path="soDienThoai" required="true"/><form:errors path="soDienThoai" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Dia Chi:</td>
                <td><form:input path="diaChi" required="true"/><form:errors path="diaChi" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Ma Bao Hiem:</td>
                <td><form:input path="maBaoHiem"/></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Luu</button></td>
            </tr>
        </table>
    </form:form>
    <br>
    <a href="${pageContext.request.contextPath}/benhnhan_list">Quay lai danh sach</a>
</body>
</html>