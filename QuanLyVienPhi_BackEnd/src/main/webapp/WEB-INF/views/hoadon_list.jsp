<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sach Hoa Don</title>
</head>
<body>
    <h2>Danh Sach Hoa Don</h2>
    <a href="hoadon/add">Them Hoa Don</a>
    <table border="1">
        <tr>
            <th>Ma Hoa Don</th>
            <th>Ma Ho So</th>
            <th>Ngay Lap</th>
            <th>Tong Tien</th>
            <th>Hanh Dong</th>
        </tr>
        <c:forEach var="hoaDon" items="${hoaDons}">
            <tr>
                <td>${hoaDon.maHoaDon}</td>
                <td>${hoaDon.maHoSo}</td>
                <td>${hoaDon.ngayLap}</td>
                <td>${hoaDon.tongTien}</td>
                <td>
                    <a href="hoadon/edit/${hoaDon.maHoaDon}">Sua</a>
                    <a href="hoadon/delete/${hoaDon.maHoaDon}" onclick="return confirm('Ban co chac chan muon xoa?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
