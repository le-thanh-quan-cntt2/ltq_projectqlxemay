<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Kho</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Thêm Kho</h2>
    <form action="KhoServlet?action=insert" method="post">
        <div class="mb-3">
            <label for="maXe" class="form-label">Mã Xe</label>
            <input type="number" class="form-control" id="maXe" name="maXe" required>
        </div>
        <div class="mb-3">
            <label for="soLuongKho" class="form-label">Số Lượng Kho</label>
            <input type="number" class="form-control" id="soLuongKho" name="soLuongKho" required>
        </div>
        <div class="mb-3">
            <label for="maNhanVienNhap" class="form-label">Mã Nhân Viên Nhập (nếu có)</label>
            <input type="number" class="form-control" id="maNhanVienNhap" name="maNhanVienNhap">
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="KhoServlet?action=list" class="btn btn-secondary">Hủy</a>
    </form>
</div>
</body>
</html>
