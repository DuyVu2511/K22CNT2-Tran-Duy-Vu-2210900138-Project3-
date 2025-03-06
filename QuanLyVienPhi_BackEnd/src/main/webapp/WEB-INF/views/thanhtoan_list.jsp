<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sach Thanh Toan</title>
</head>
<body>
    <h2>Danh Sach Thanh Toan</h2>
    <a href="thanhtoan/add">Them Thanh Toan</a>
    <table border="1">
        <tr>
            <th>Ma Thanh Toan</th>
            <th>Ma Hoa Don</th>
            <th>Ngay Thanh Toan</th>
            <th>So Tien</th>
            <th>Hanh Dong</th>
        </tr>
        <c:forEach var="thanhToan" items="${thanhToans}">
            <tr>
                <td>${thanhToan.maThanhToan}</td>
                <td>${thanhToan.maHoaDon}</td>
                <td>${thanhToan.ngayThanhToan}</td>
                <td>${thanhToan.soTien}</td>
                <td>
                    <a href="thanhtoan/edit/${thanhToan.maThanhToan}">Sua</a>
                    <a href="thanhtoan/delete/${thanhToan.maThanhToan}" onclick="return confirm('Ban co chac chan muon xoa?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
