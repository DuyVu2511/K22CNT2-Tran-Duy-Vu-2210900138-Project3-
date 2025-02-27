<html>
<head>
    <title>Quan ly dich vu</title>
</head>
<body>
    <h2>Quan ly dich vu</h2>
    <form action="${dichVu.maDichVu == 0 ? 'add' : 'edit'}" method="post">
        <input type="hidden" name="maDichVu" value="${dichVu.maDichVu}"/>
        Ten dich vu: <input type="text" name="tenDichVu" value="${dichVu.tenDichVu}" required/><br/>
        Mo ta: <input type="text" name="moTa" value="${dichVu.moTa}"/><br/>
        Don gia: <input type="number" name="donGia" value="${dichVu.donGia}" required/><br/>
        Trang thai: <input type="text" name="trangThai" value="${dichVu.trangThai}"/><br/>
        <input type="submit" value="Luu"/>
    </form>
</body>
</html>
