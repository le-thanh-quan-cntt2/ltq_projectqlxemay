<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Cart" %>
<%@ page import="model.CartItem" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh Toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">MUAXEMAY.VN</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="XeMayServlet?action=list">Trang Chủ</a></li>
                <li class="nav-item"><a class="nav-link" href="XeMayServlet?action=viewCart">Giỏ Hàng</a></li>
                <li class="nav-item"><a class="nav-link" href="XeMayServlet?action=checkout">Thanh Toán</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Checkout Form -->
<div class="container mt-5">
    <h2 class="text-center mb-4">Thông Tin Thanh Toán</h2>

    <form action="XeMayServlet?action=checkout" method="POST">
        <div class="mb-3">
            <label for="name" class="form-label">Họ và Tên</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Số Điện Thoại</label>
            <input type="text" class="form-control" id="phone" name="phone" required>
        </div>

        <h4>Chi Tiết Đơn Hàng</h4>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Ảnh</th>
                    <th>Tên Xe</th>
                    <th>Loại Xe</th>
                    <th>Giá</th>
                    <th>Số Lượng</th>
                    <th>Tổng Tiền</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart != null && !cart.getItems().isEmpty()) {
                        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                            CartItem item = entry.getValue();
                %>
                <tr>
                    <td><img src="<%= item.getXeMay().getHinhAnh() %>" alt="Xe Máy" style="width: 100px;"></td>
                    <td><%= item.getXeMay().getTenXe() %></td>
                    <td><%= item.getXeMay().getLoaiXe() %></td>
                    <td><%= item.getXeMay().getGiaBan() %> VNĐ</td>
                    <td><%= item.getQuantity() %></td>
                    <td><%= item.getXeMay().getGiaBan() * item.getQuantity() %> VNĐ</td>
                </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>

        <div class="d-flex justify-content-between">
            <h3>Tổng Tiền: <%= cart.getTotalPrice() %> VNĐ</h3>
        </div>

        <button type="submit" class="btn btn-success mt-3">Xác Nhận Đặt Hàng</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
