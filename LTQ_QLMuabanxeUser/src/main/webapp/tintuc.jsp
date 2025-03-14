<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.TinTuc" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tin Tức - Website Bán Xe Máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/tintuc.css">
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
                <li class="nav-item"><a class="nav-link" href="listXeMay.jsp">Trang Chủ</a></li>
                <li class="nav-item"><a class="nav-link active" href="tintuc.jsp">Tin Tức</a></li>
                <li class="nav-item"><a class="nav-link" href="lienhe.jsp">Liên Hệ</a></li>
                <li class="nav-item"><a class="nav-link" href="viewCart.jsp">Giỏ Hàng</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Tin Tức Section -->
<div class="container news-container">
    <div class="section-header">
        <p>TIN MỚI</p>
    </div>

    <div class="row mt-4">
        <% 
            List<TinTuc> listTinTuc = (List<TinTuc>) request.getAttribute("listTinTuc");
            if (listTinTuc != null && !listTinTuc.isEmpty()) {
                for (TinTuc tinTuc : listTinTuc) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="<%= tinTuc.getHinhAnh() %>" class="card-img-top" alt="Hình ảnh tin tức">
                <div class="card-body">
                    <h5 class="card-title"><%= tinTuc.getTieuDe() %></h5>
                    <p class="card-text"><%= tinTuc.getMoTa() %></p>
                    <a href="tintucDetail.jsp?id=<%= tinTuc.getId() %>" class="btn btn-info btn-sm">Đọc thêm</a>
                </div>
            </div>
        </div>
        <% 
                }
            } else { 
        %>
        <div class="col-12 text-center">
            <p class="text-muted">Không có tin tức nào để hiển thị.</p>
        </div>
        <% 
            } 
        %>
    </div>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2025 MUAXEMAY.VN.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
