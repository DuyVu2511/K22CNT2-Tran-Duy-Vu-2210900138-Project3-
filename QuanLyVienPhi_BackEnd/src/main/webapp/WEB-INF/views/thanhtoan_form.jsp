<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thanh Toan</title>
</head>
<body>
    <h2>Nhap Thanh Toan</h2>

    <form action="save" method="post">
        <input type="hidden" name="maThanhToan" value="${thanhToan.maThanhToan}" />

        <label>Ma Hoa Don:</label>
        <input type="number" name="maHoaDon" value="${thanhToan.maHoaDon}" required />
        <br/>

        <label>Ngay Thanh Toan:</label>
        <input type="date" name="ngayThanhToan" value="${thanhToan.ngayThanhToan}" required />
        <br/>

        <label>So Tien:</label>
        <input type="text" name="soTien" value="${thanhToan.soTien}" required />
        <br/>

        <label>Hinh Thuc Thanh Toan:</label>
        <input type="text" name="hinhThucThanhToan" value="${thanhToan.hinhThucThanhToan}" required />
        <br/>

        <input type="submit" value="Luu" />
        <a href="../thanhtoan">Huy</a>
    </form>
</body>
</html>
