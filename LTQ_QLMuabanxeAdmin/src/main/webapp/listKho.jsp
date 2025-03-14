<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Kho" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website Bán Xe Máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/listKhachHang.css" rel="stylesheet" type="text/css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">MUAXEMAY.VN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active" href="XeMayServlet">Xe máy</a></li>
                <li class="nav-item"><a class="nav-link" href="KhachHangServlet">Khách hàng</a></li>
                <li class="nav-item"><a class="nav-link" href="DonHangServlet">Đơn Hàng</a></li>
                <li class="nav-item"><a class="nav-link" href="KhoServlet">Kho </a></li>
                <li class="nav-item"><a class="nav-link" href="ThanhToanServlet">Thanh Toán</a></li>
                
            </ul>
        </div>
    </div>
</nav>

<!-- Carousel (Banner) -->
<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="images/images1.jpg" class="d-block w-100" alt="Image 1">
        </div>
        <div class="carousel-item">
            <img src="images/images2.jpg" class="d-block w-100" alt="Image 2">
        </div>
        <div class="carousel-item">
            <img src="images/images3.jpg" class="d-block w-100" alt="Image 3">
        </div>
        <div class="carousel-item">
            <img src="images/images4.jpg" class="d-block w-100" alt="Image 3">
        </div>
    </div>
    
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<div class="container mt-5">
    <h2 class="text-center mb-4">Quản Lý Kho</h2>
    <a href="KhoServlet?action=new" class="btn btn-success mb-3">+ Thêm Kho</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>STT</th>
                <th>Mã Xe</th>
                <th>Số Lượng Kho</th>
                <th>Ngày Nhập Kho</th>
                <th>Mã Nhân Viên Nhập</th>
                <th>Hành Động</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Kho> list = (List<Kho>) request.getAttribute("listKho");
                if(list != null && !list.isEmpty()){
                    int i=1;
                    for(Kho k : list){
            %>
            <tr>
                <td><%= i++ %></td>
                <td><%= k.getMaXe() %></td>
                <td><%= k.getSoLuongKho() %></td>
                <td><%= k.getNgayNhapKho() %></td>
                <td><%= k.getMaNhanVienNhap() != null ? k.getMaNhanVienNhap() : "NULL" %></td>
                <td>
                    <a href="KhoServlet?action=edit&maXe=<%= k.getMaXe() %>" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="KhoServlet?action=delete&maXe=<%= k.getMaXe() %>" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa kho này?')">Xóa</a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" class="text-center">Không có bản ghi nào.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
