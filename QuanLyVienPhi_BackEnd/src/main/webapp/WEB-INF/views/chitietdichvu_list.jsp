<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sach chi tiet dich vu</title>
</head>
<body>
    <h2>Danh sach chi tiet dich vu</h2>
    <a href="chitietdichvu/add">Them chi tiet dich vu</a>
    <table border="1">
        <tr>
            <th>Ma Chi Tiet</th>
            <th>Ma Ho So</th>
            <th>Ma Dich Vu</th>
            <th>So Luong</th>
            <th>Thanh Tien</th>
            <th>Hanh Dong</th>
        </tr>
        <c:forEach var="ctdv" items="${chiTietDichVus}">
            <tr>
                <td>${ctdv.maChiTiet}</td>
                <td>${ctdv.maHoSo}</td>
                <td>${ctdv.maDichVu}</td>
                <td>${ctdv.soLuong}</td>
                <td>${ctdv.thanhTien}</td>
                <td>
                    <a href="chitietdichvu/edit/${ctdv.maChiTiet}">Sua</a> |
                    <a href="chitietdichvu/delete/${ctdv.maChiTiet}" onclick="return confirm('Xoa chi tiet dich vu nay?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
