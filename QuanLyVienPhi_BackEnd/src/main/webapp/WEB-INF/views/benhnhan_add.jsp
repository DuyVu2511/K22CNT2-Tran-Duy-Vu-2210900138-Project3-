<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Them Benh Nhan</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
    <h2>Them Benh Nhan</h2>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <form action="<c:url value='/benhnhan/save'/>" method="post">
        <table>
            <tr>
                <td>Ho Ten:</td>
                <td><input type="text" name="hoTen" value="${benhNhan.hoTen}" required/></td>
            </tr>
            <tr>
                <td>Ngay Sinh:</td>
                <td>
                    <input type="date" name="ngaySinh" 
                           value="<fmt:formatDate value='${benhNhan.ngaySinh}' pattern='yyyy-MM-dd'/>" required/>
                </td>
            </tr>
            <tr>
                <td>Gioi Tinh:</td>
                <td>
                    <select name="gioiTinh" required>
                        <option value="" ${benhNhan.gioiTinh == null ? 'selected' : ''}>Chon gioi tinh</option>
                        <option value="Nam" ${benhNhan.gioiTinh == 'Nam' ? 'selected' : ''}>Nam</option>
                        <option value="Nu" ${benhNhan.gioiTinh == 'Nu' ? 'selected' : ''}>Nu</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>CMND/CCCD:</td>
                <td><input type="text" name="cmndCccd" value="${benhNhan.cmndCccd}" required/></td>
            </tr>
            <tr>
                <td>So Dien Thoai:</td>
                <td><input type="text" name="soDienThoai" value="${benhNhan.soDienThoai}" required/></td>
            </tr>
            <tr>
                <td>Dia Chi:</td>
                <td><input type="text" name="diaChi" value="${benhNhan.diaChi}" required/></td>
            </tr>
            <tr>
                <td>Ma Bao Hiem:</td>
                <td><input type="text" name="maBaoHiem" value="${benhNhan.maBaoHiem}"/></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">Them</button></td>
            </tr>
        </table>
    </form>
    <br>
    <a href="<c:url value='/benhnhan_list'/>">Quay lai danh sach</a>
</body>
</html>