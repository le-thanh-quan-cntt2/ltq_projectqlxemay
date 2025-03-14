<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/signup.css">
</head>
<body>
    <section>
        <div class="register-container">
            <h2>Đăng Ký</h2>
            <form action="registerServlet" method="POST">
                <div class="inputBox">
                    <input type="text" id="username" name="username" required>
                    <label for="username">Tài Khoản</label>
                </div>
                <div class="inputBox">
                    <input type="password" id="password" name="password" required>
                    <label for="password">Mật Khẩu</label>
                </div>
                <div class="inputBox">
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                    <label for="confirmPassword">Xác Nhận Mật Khẩu</label>
                </div>
                <button type="submit">Đăng Ký</button>
            </form>

            <% if (request.getParameter("error") != null) { %>
                <div class="alert alert-danger">
                    <%= request.getParameter("error") %>
                </div>
            <% } %>

            <div class="register-footer">
                <a href="listXeMay.jsp" class="btn btn-outline-secondary">Quay lại</a>
            </div>
        </div>
    </section>
</body>
</html>
