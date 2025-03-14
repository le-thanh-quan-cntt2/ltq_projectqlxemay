<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/login.css">
</head>
<body>
    <section>
        <div class="login-container">
            <h1>Đăng Nhập</h1>
            <form action="loginServlet" method="POST">
                <div class="inputBox">
                    <input type="text" id="username" name="username" required>
                    <label for="username">Tài khoản</label>
                </div>
                <div class="inputBox">
                    <input type="password" id="password" name="password" required>
                    <label for="password">Mật khẩu</label>
                </div>
                <div class="forget">
                    <label for="rememberMe">
                        <input type="checkbox" id="rememberMe">Ghi nhớ
                    </label>
                    <a href="#">Quên mật khẩu?</a>
                </div>
                <button type="submit">Đăng Nhập</button>
            </form>
            <% if (request.getParameter("error") != null) { %>
                <div class="alert alert-danger mt-3">Tên đăng nhập hoặc mật khẩu không chính xác.</div>
            <% } %>
            <div class="register">
                <p>Chưa có tài khoản? <a href="LTQsignup.jsp">Đăng ký</a></p>
            </div>
        </div>
    </section>
</body>
</html>
