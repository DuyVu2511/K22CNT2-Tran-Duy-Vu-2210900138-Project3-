<html>
<head>
    <title>Quan ly benh nhan</title>
</head>
<body>
    <h2>Quan ly benh nhan</h2>
    <form action="${benhNhan.maBenhNhan == 0 ? 'add' : 'edit'}" method="post">
        <input type="hidden" name="maBenhNhan" value="${benhNhan.maBenhNhan}"/>
        Ho ten: <input type="text" name="hoTen" value="${benhNhan.hoTen}" required/><br/>
        Ngay sinh: <input type="date" name="ngaySinh" value="${benhNhan.ngaySinh}"/><br/>
        Gioi tinh: 
        <select name="gioiTinh">
            <option value="Nam" ${benhNhan.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
            <option value="Nu" ${benhNhan.gioiTinh == 'Nu' ? 'selected' : ''}>Nu</option>
        </select><br/>
        CMND/CCCD: <input type="text" name="cmndCccd" value="${benhNhan.cmndCccd}" required/><br/>
        So dien thoai: <input type="text" name="soDienThoai" value="${benhNhan.soDienThoai}"/><br/>
        Dia chi: <input type="text" name="diaChi" value="${benhNhan.diaChi}"/><br/>
        Ma bao hiem: <input type="text" name="maBaoHiem" value="${benhNhan.maBaoHiem}"/><br/>
        <input type="submit" value="Luu"/>
    </form>
</body>
</html>
