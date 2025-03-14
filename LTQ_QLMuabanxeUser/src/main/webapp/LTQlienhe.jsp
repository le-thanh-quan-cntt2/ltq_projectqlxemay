<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liên Hệ - Website Bán Xe Máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
     <link rel="stylesheet" href="CSS/LienHe.css">
   
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
                <li class="nav-item"><a class="nav-link" href="tintuc.jsp">Tin Tức</a></li>
                <li class="nav-item"><a class="nav-link active" href="lienhe.jsp">Liên Hệ</a></li>
                <li class="nav-item"><a class="nav-link" href="viewCart.jsp">Giỏ Hàng</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Contact Information Section -->
<div class="container mt-5">
    <h2 class="text-center mb-4">Liên Hệ Với Chúng Tôi</h2>

    <div class="contact-info">
        <h4>Thông Tin Liên Hệ</h4>
        <p><strong>Siêu Thị Xe Máy </strong></p>
        <p><strong>Cơ sở 1:</strong> Số 52 Phố Chùa Hà - Cầu Giấy - Hà Nội</p>
        <p><strong>Cơ sở 2:</strong> Số 62 Phố Chùa Hà - Cầu Giấy - Hà Nội</p>
        <p><strong>Cơ sở 3:</strong> Số 64 Phố Chùa Hà - Cầu Giấy - Hà Nội</p>
        <p><strong>Điện thoại:</strong> <a href="tel:0976555223" class="phone">0976.555.223</a> (call/zalo/sms)</p>
        <p><strong>Email:</strong> <a href="mailto:quanlekrn01@gmail.com" class="email">quanlekrn01@gmail.com</a></p>
    </div>

    <!-- Liên Hệ Form -->
    <h3 class="text-center mt-5 mb-4">Hoặc Gửi Lời Nhắn Cho Chúng Tôi</h3>
    <form action="LienHeServlet" method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="name" class="form-label">Họ và Tên</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
            </div>
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Lời Nhắn</label>
            <textarea class="form-control" id="message" name="message" rows="4" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Gửi</button>
    </form>
</div>

<!-- Footer -->
<footer class="footer text-center py-3 mt-5">
    <p>&copy; 2025 MUAXEMAY.VN</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
