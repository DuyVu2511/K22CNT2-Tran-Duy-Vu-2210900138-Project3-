<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chi Tiet Hoa Don</title>
</head>
<body>
    <h2>Nhap Chi Tiet Hoa Don</h2>
    
    <form action="save" method="post">
        <input type="hidden" name="maChiTiet" value="${chiTiet.maChiTiet}" />

        <label>Ma Hoa Don:</label>
        <input type="number" name="maHoaDon" value="${chiTiet.maHoaDon}" required />
        <br/>

        <label>Ma Dich Vu:</label>
        <input type="number" name="maDichVu" value="${chiTiet.maDichVu}" required />
        <br/>

        <label>So Luong:</label>
        <input type="number" name="soLuong" value="${chiTiet.soLuong}" required />
        <br/>

        <label>Thanh Tien:</label>
        <input type="text" name="thanhTien" value="${chiTiet.thanhTien}" required />
        <br/>

        <input type="submit" value="Luu" />
        <a href="../chitiethoadon">Huy</a>
    </form>
</body>
</html>
