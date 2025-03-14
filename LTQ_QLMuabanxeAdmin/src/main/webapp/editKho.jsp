<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Kho" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Kho</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Sửa Kho</h2>
    <%
        Kho kho = (Kho) request.getAttribute("kho");
    %>
    <form action="KhoServlet?action=update" method="post">
        <!-- Mã Xe không được sửa nên để hidden -->
        <input type="hidden" name="maXe" value="<%= kho.getMaXe() %>">
        <div class="mb-3">
            <label for="soLuongKho" class="form-label">Số Lượng Kho</label>
            <input type="number" class="form-control" id="soLuongKho" name="soLuongKho" value="<%= kho.getSoLuongKho() %>" required>
        </div>
        <div class="mb-3">
            <label for="maNhanVienNhap" class="form-label">Mã Nhân Viên Nhập (nếu có)</label>
            <input type="number" class="form-control" id="maNhanVienNhap" name="maNhanVienNhap" value="<%= kho.getMaNhanVienNhap() != null ? kho.getMaNhanVienNhap() : "" %>">
        </div>
        <button type="submit" class="btn btn-primary">Cập Nhật</button>
        <a href="KhoServlet?action=list" class="btn btn-secondary">Hủy</a>
    </form>
</div>
</body>
</html>
