<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sach ho so kham</title>
</head>
<body>
    <h2>Danh sach ho so kham</h2>
    <a href="hosokham/add">Them ho so kham</a>
    <table border="1">
        <tr>
            <th>Ma</th>
            <th>Ma benh nhan</th>
            <th>Ngay kham</th>
            <th>Chan doan</th>
            <th>Bac si dieu tri</th>
            <th>Trang thai</th>
            <th>Hanh dong</th>
        </tr>
        <c:forEach var="hs" items="${hoSoKhams}">
            <tr>
                <td>${hs.maHoSo}</td>
                <td>${hs.maBenhNhan}</td>
                <td>${hs.ngayKham}</td>
                <td>${hs.chanDoan}</td>
                <td>${hs.bacSiDieuTri}</td>
                <td>${hs.trangThai ? 'Hoan thanh' : 'Chua hoan thanh'}</td>
                <td>
                    <a href="hosokham/edit/${hs.maHoSo}">Sua</a> |
                    <a href="hosokham/delete/${hs.maHoSo}" onclick="return confirm('Xoa ho so nay?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
