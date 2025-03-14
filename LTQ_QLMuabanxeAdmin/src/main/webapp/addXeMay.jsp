<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Xe Máy</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link href="CSS/addXeMay.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Thêm Xe Máy</h2>
    <form action="XeMayServlet?action=insert" method="post">
        <div class="form-group mb-3">
            <label for="tenXe">Tên Xe:</label>
            <input type="text" id="tenXe" name="tenXe" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="loaiXe">Loại Xe:</label>
            <input type="text" id="loaiXe" name="loaiXe" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="hangSanXuat">Hãng Sản Xuất:</label>
            <input type="text" id="hangSanXuat" name="hangSanXuat" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="namSanXuat">Năm Sản Xuất:</label>
            <input type="number" id="namSanXuat" name="namSanXuat" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="mauSac">Màu Sắc:</label>
            <input type="text" id="mauSac" name="mauSac" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="giaBan">Giá Bán:</label>
            <input type="number" step="0.01" id="giaBan" name="giaBan" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="tinhTrang">Tình Trạng:</label>
            <input type="text" id="tinhTrang" name="tinhTrang" class="form-control" required>
        </div>
        <div class="form-group mb-3">
            <label for="hinhAnh">Hình Ảnh:</label>
            <input type="text" id="hinhAnh" name="hinhAnh" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Thêm Xe</button>
        <a href="XeMayServlet?action=list" class="btn btn-secondary w-100 mt-2">Hủy</a>
    </form>
</div>
</body>
</html>
