<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.KhachHang" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/editKhachHang.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Sửa Khách Hàng</h2>

    <form action="KhachHangServlet?action=update" method="POST">
        <%-- Cast the 'khachHang' object to the correct type --%>
        <input type="hidden" name="id" value="<%= ((KhachHang) request.getAttribute("khachHang")).getMaKhachHang() %>">
        
        <div class="mb-3">
            <label for="hoTen" class="form-label">Họ Tên</label>
            <input type="text" class="form-control" id="hoTen" name="hoTen" 
                value="<%= ((KhachHang) request.getAttribute("khachHang")).getHoTen() %>" required>
        </div>
        
        <div class="mb-3">
            <label for="diaChi" class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" 
                value="<%= ((KhachHang) request.getAttribute("khachHang")).getDiaChi() %>" required>
        </div>
        
        <div class="mb-3">
            <label for="soDienThoai" class="form-label">Số Điện Thoại</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" 
                value="<%= ((KhachHang) request.getAttribute("khachHang")).getSoDienThoai() %>" required>
        </div>
        
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" 
                value="<%= ((KhachHang) request.getAttribute("khachHang")).getEmail() %>">
        </div>

        <button type="submit" class="btn btn-success">Cập Nhật</button>
        <a href="KhachHangServlet?action=list" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
