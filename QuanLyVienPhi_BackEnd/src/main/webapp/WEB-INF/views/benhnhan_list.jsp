<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sach benh nhan</title>
</head>
<body>
    <h2>Danh sach benh nhan</h2>
    <a href="benhnhan/add">Them benh nhan</a>
    <table border="1">
        <tr>
            <th>Ma</th>
            <th>Ho ten</th>
            <th>Ngay sinh</th>
            <th>Gioi tinh</th>
            <th>CMND/CCCD</th>
            <th>So dien thoai</th>
            <th>Dia chi</th>
            <th>Ma bao hiem</th>
            <th>Hanh dong</th>
        </tr>
        <c:forEach var="bn" items="${benhNhans}">
            <tr>
                <td>${bn.maBenhNhan}</td>
                <td>${bn.hoTen}</td>
                <td>${bn.ngaySinh}</td>
                <td>${bn.gioiTinh}</td>
                <td>${bn.cmndCccd}</td>
                <td>${bn.soDienThoai}</td>
                <td>${bn.diaChi}</td>
                <td>${bn.maBaoHiem}</td>
                <td>
                    <a href="benhnhan/edit/${bn.maBenhNhan}">Sua</a> |
                    <a href="benhnhan/delete/${bn.maBenhNhan}" onclick="return confirm('Xoa benh nhan nay?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
