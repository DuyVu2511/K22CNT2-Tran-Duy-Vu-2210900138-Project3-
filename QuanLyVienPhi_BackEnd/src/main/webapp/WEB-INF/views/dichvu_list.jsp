<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sach dich vu</title>
</head>
<body>
    <h2>Danh sach dich vu y te</h2>
    <a href="dichvu/add">Them dich vu</a>
    <table border="1">
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Mo ta</th>
            <th>Don gia</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
        </tr>
        <c:forEach var="dv" items="${dichVus}">
            <tr>
                <td>${dv.maDichVu}</td>
                <td>${dv.tenDichVu}</td>
                <td>${dv.moTa}</td>
                <td>${dv.donGia}</td>
                <td>${dv.trangThai}</td>
                <td>
                    <a href="dichvu/edit/${dv.maDichVu}">Sua</a> |
                    <a href="dichvu/delete/${dv.maDichVu}" onclick="return confirm('Xoa dich vu nay?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
