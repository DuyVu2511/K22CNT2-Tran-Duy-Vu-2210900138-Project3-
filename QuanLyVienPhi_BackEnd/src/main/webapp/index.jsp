<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>He Thong Quan Ly Vien Phi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            margin: 0;
        }
        .sidebar {
            width: 250px;
            background: #2c3e50;
            color: white;
            height: 100vh;
            padding: 20px;
            box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.2);
        }
        .sidebar h2 {
            text-align: center;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
        }
        .sidebar ul li {
            padding: 10px;
            border-bottom: 1px solid #34495e;
        }
        .sidebar ul li a {
            color: white;
            text-decoration: none;
            display: block;
        }
        .sidebar ul li a:hover {
            background: #1abc9c;
        }
        .content {
            flex-grow: 1;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h2>Quan Ly Vien Phi</h2>
   <ul>
    <li><a href="benhnhan_list">Quan ly Benh Nhan</a></li>
    <li><a href="chitietdichvu_list">Chi Tiet Dich Vu</a></li>
    <li><a href="chitiethoadon_list">Chi Tiet Hoa Don</a></li>
    <li><a href="dichvu_list">Quan ly Dich Vu</a></li>
    <li><a href="hoadon_list">Quan ly Hoa Don</a></li>
    <li><a href="hosokham_list">Ho So Kham</a></li>
    <li><a href="thanhtoan_list">Quan ly Thanh Toan</a></li>
</ul>


    </div>

    <div class="content">
        <h1>Chao mung den voi he thong quan ly vien phi</h1>
        <p>Vui long chon mot danh muc tu menu ben trai de thao tac.</p>
    </div>
</body>
</html>
