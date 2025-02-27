<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sach Chi Tiet Hoa Don</title>
</head>
<body>
    <h2>Danh Sach Chi Tiet Hoa Don</h2>
    <a href="chitiethoadon/add">Them Chi Tiet</a>
    <table border="1">
        <tr>
            <th>Ma Chi Tiet</th>
            <th>Ma Hoa Don</th>
            <th>Ma Dich Vu</th>
            <th>So Luong</th>
            <th>Thanh Tien</th>
            <th>Hanh Dong</th>
        </tr>
        <c:forEach var="chiTiet" items="${chiTietHoaDons}">
            <tr>
                <td>${chiTiet.maChiTiet}</td>
                <td>${chiTiet.maHoaDon}</td>
                <td>${chiTiet.maDichVu}</td>
                <td>${chiTiet.soLuong}</td>
                <td>${chiTiet.thanhTien}</td>
                <td>
                    <a href="chitiethoadon/edit/${chiTiet.maChiTiet}">Sua</a>
                    <a href="chitiethoadon/delete/${chiTiet.maChiTiet}" onclick="return confirm('Ban co chac chan muon xoa?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
