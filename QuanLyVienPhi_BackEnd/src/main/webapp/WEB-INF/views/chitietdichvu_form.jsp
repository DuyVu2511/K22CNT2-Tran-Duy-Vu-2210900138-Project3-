<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chi Tiet Dich Vu</title>
</head>
<body>
    <h2><c:if test="${chiTietDichVu.maChiTiet == 0}">Them Moi</c:if><c:if test="${chiTietDichVu.maChiTiet != 0}">Chinh Sua</c:if> Chi Tiet Dich Vu</h2>
    
    <form action="save" method="post">
        <input type="hidden" name="maChiTiet" value="${chiTietDichVu.maChiTiet}" />

        <label>Ma Ho So:</label>
        <input type="number" name="maHoSo" value="${chiTietDichVu.maHoSo}" required />
        <br/>

        <label>Ma Dich Vu:</label>
        <input type="number" name="maDichVu" value="${chiTietDichVu.maDichVu}" required />
        <br/>

        <label>So Luong:</label>
        <input type="number" name="soLuong" value="${chiTietDichVu.soLuong}" required />
        <br/>

        <label>Thanh Tien:</label>
        <input type="text" name="thanhTien" value="${chiTietDichVu.thanhTien}" required />
        <br/>

        <input type="submit" value="Luu" />
        <a href="../chitietdichvu">Huy</a>
    </form>
</body>
</html>
