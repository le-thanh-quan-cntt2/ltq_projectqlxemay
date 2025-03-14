<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Đơn Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Thêm Đơn Hàng</h2>
    <form action="DonHangServlet?action=insert" method="post">
        <div class="mb-3">
            <label for="maKhachHang" class="form-label">Mã Khách Hàng</label>
            <input type="number" class="form-control" id="maKhachHang" name="maKhachHang" required>
        </div>
        <div class="mb-3">
            <label for="maNhanVien" class="form-label">Mã Nhân Viên (nếu có)</label>
            <input type="number" class="form-control" id="maNhanVien" name="maNhanVien">
        </div>
        <div class="mb-3">
            <label for="maXe" class="form-label">Mã Xe</label>
            <input type="number" class="form-control" id="maXe" name="maXe" required>
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">Số Lượng</label>
            <input type="number" class="form-control" id="soLuong" name="soLuong" required>
        </div>
        <div class="mb-3">
            <label for="trangThaiDon" class="form-label">Trạng Thái Đơn</label>
            <input type="text" class="form-control" id="trangThaiDon" name="trangThaiDon" required>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="DonHangServlet?action=list" class="btn btn-secondary">Hủy</a>
    </form>
</div>
</body>
</html>
