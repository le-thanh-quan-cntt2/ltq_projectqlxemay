<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ThanhToan" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Thanh Toán</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Sửa Thanh Toán</h2>
    <%
        ThanhToan tt = (ThanhToan) request.getAttribute("thanhToan");
    %>
    <form action="ThanhToanServlet?action=update" method="post">
        <input type="hidden" name="id" value="<%= tt.getMaThanhToan() %>">
        <div class="mb-3">
            <label for="maDonHang" class="form-label">Mã Đơn Hàng</label>
            <input type="number" class="form-control" id="maDonHang" name="maDonHang" value="<%= tt.getMaDonHang() %>" required>
        </div>
        <div class="mb-3">
            <label for="soTien" class="form-label">Số Tiền</label>
            <input type="number" step="0.01" class="form-control" id="soTien" name="soTien" value="<%= tt.getSoTien() %>" required>
        </div>
        <div class="mb-3">
            <label for="phuongThucThanhToan" class="form-label">Phương Thức Thanh Toán</label>
            <input type="text" class="form-control" id="phuongThucThanhToan" name="phuongThucThanhToan" value="<%= tt.getPhuongThucThanhToan() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="ThanhToanServlet?action=list" class="btn btn-secondary">Hủy</a>
    </form>
</div>
</body>
</html>
