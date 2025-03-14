<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.XeMay" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Sửa Xe Máy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link href="CSS/editXeMay.css" rel="stylesheet" type="text/css">
    
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Sửa Xe Máy</h2>
    <%
        XeMay xeMay = (XeMay) request.getAttribute("xeMay");
    %>
    <form action="XeMayServlet?action=update" method="post">
        <input type="hidden" name="id" value="<%= xeMay.getMaXe() %>">
        <div class="form-group mb-3">
            <label for="tenXe">Tên Xe:</label>
            <input type="text" id="tenXe" name="tenXe" class="form-control" value="<%= xeMay.getTenXe() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="loaiXe">Loại Xe:</label>
            <input type="text" id="loaiXe" name="loaiXe" class="form-control" value="<%= xeMay.getLoaiXe() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="hangSanXuat">Hãng Sản Xuất:</label>
            <input type="text" id="hangSanXuat" name="hangSanXuat" class="form-control" value="<%= xeMay.getHangSanXuat() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="namSanXuat">Năm Sản Xuất:</label>
            <input type="number" id="namSanXuat" name="namSanXuat" class="form-control" value="<%= xeMay.getNamSanXuat() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="mauSac">Màu Sắc:</label>
            <input type="text" id="mauSac" name="mauSac" class="form-control" value="<%= xeMay.getMauSac() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="giaBan">Giá Bán:</label>
            <input type="number" step="0.01" id="giaBan" name="giaBan" class="form-control" value="<%= xeMay.getGiaBan() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="tinhTrang">Tình Trạng:</label>
            <input type="text" id="tinhTrang" name="tinhTrang" class="form-control" value="<%= xeMay.getTinhTrang() %>" required>
        </div>
        <div class="form-group mb-3">
            <label for="hinhAnh">Hình Ảnh:</label>
            <input type="text" id="hinhAnh" name="hinhAnh" class="form-control" value="<%= xeMay.getHinhAnh() %>" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Cập Nhật</button>
        <a href="XeMayServlet?action=list" class="btn btn-secondary w-100 mt-2">Hủy</a>
    </form>
</div>
</body>
</html>
