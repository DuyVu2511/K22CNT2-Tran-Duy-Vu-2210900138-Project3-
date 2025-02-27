<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hoa Don</title>
</head>
<body>
    <h2><c:if test="${hoaDon.maHoaDon == 0}">Them Moi</c:if><c:if test="${hoaDon.maHoaDon != 0}">Chinh Sua</c:if> Hoa Don</h2>
    
    <form action="save" method="post">
        <input type="hidden" name="maHoaDon" value="${hoaDon.maHoaDon}" />

        <label>Ma Ho So:</label>
        <input type="number" name="maHoSo" value="${hoaDon.maHoSo}" required />
        <br/>

        <label>Ngay Lap:</label>
        <input type="date" name="ngayLap" value="${hoaDon.ngayLap}" required />
        <br/>

        <label>Tong Tien:</label>
        <input type="text" name="tongTien" value="${hoaDon.tongTien}" required />
        <br/>

        <input type="submit" value="Luu" />
        <a href="../hoadon">Huy</a>
    </form>
</body>
</html>
