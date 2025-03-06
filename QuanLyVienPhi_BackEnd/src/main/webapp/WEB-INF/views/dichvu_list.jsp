<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sach Dich Vu</title>
</head>
<body>
    <h2>Danh Sach Dich Vu</h2>
    <a href="dichvu/add">Them Dich Vu</a>
    <table border="1">
        <tr>
            <th>Ma Dich Vu</th>
            <th>Ten Dich Vu</th>
            <th>Mo Ta</th>
            <th>Don Gia</th>
            <th>Trang Thai</th>
            <th>Hanh Dong</th>
        </tr>
        <c:forEach var="dichVu" items="${dichVus}">
            <tr>
                <td>${dichVu.maDichVu}</td>
                <td>${dichVu.tenDichVu}</td>
                <td>${dichVu.moTa}</td>
                <td>${dichVu.donGia}</td>
                <td>${dichVu.trangThai}</td>
                <td>
                    <a href="dichvu/edit/${dichVu.maDichVu}">Sua</a>
                    <a href="dichvu/delete/${dichVu.maDichVu}" onclick="return confirm('Ban co chac chan muon xoa?')">Xoa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
