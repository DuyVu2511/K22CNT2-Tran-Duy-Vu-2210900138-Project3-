<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sach Benh Nhan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Danh Sach Benh Nhan</h2>
        <a href="benhnhan_add" class="btn btn-primary mb-3">Them Benh Nhan</a>
        
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Ma</th>
                    <th>Ho Ten</th>
                    <th>Ngay Sinh</th>
                    <th>Gioi Tinh</th>
                    <th>CMND/CCCD</th>
                    <th>So Dien Thoai</th>
                    <th>Dia Chi</th>
                    <th>Ma Bao Hiem</th>
                    <th>Hanh Dong</th>
                </tr>
            </thead>
            <tbody>
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
                            <a href="benhnhan_edit/${bn.maBenhNhan}" class="btn btn-warning btn-sm">Sua</a>
                            <a href="benhnhan_delete/${bn.maBenhNhan}" 
                               class="btn btn-danger btn-sm" 
                               onclick="return confirm('Xoa benh nhan nay?')">Xoa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
