<html>
<head>
    <title>Quan ly ho so kham</title>
</head>
<body>
    <h2>Quan ly ho so kham</h2>
    <form action="${hoSoKham.maHoSo == 0 ? 'add' : 'edit'}" method="post">
        <input type="hidden" name="maHoSo" value="${hoSoKham.maHoSo}"/>
        Ma benh nhan: <input type="number" name="maBenhNhan" value="${hoSoKham.maBenhNhan}" required/><br/>
        Ngay kham: <input type="date" name="ngayKham" value="${hoSoKham.ngayKham}"/><br/>
        Chan doan: <input type="text" name="chanDoan" value="${hoSoKham.chanDoan}" required/><br/>
        Bac si dieu tri: <input type="text" name="bacSiDieuTri" value="${hoSoKham.bacSiDieuTri}" required/><br/>
        Trang thai: 
        <select name="trangThai">
            <option value="true" ${hoSoKham.trangThai ? 'selected' : ''}>Hoan thanh</option>
            <option value="false" ${!hoSoKham.trangThai ? 'selected' : ''}>Chua hoan thanh</option>
        </select><br/>
        <input type="submit" value="Luu"/>
    </form>
</body>
</html>
