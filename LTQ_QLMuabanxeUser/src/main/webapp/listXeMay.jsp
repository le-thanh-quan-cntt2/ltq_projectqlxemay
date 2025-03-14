<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.XeMay" %>
<%@ page import="model.QuanTri" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website Bán Xe Máy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
     <link href="CSS/listXeMay.css" rel="stylesheet" type="text/css">

</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">MUAXEMAY.VN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link active" href="listXeMay.jsp">Trang Chủ</a></li>
                <li class="nav-item"><a class="nav-link" href="tintuc.jsp">Tin Tức</a></li>
                <li class="nav-item"><a class="nav-link" href="LTQlienhe.jsp">Liên Hệ</a></li>

                <%-- Kiểm tra người dùng đã đăng nhập chưa --%>
                <%
                    QuanTri user = (QuanTri) session.getAttribute("user");
                    if (user != null) {
                %>
                <li class="nav-item"><a class="nav-link" href="#">Chào mừng, <%= user.getTaiKhoan() %></a></li>
                <li class="nav-item"><a class="nav-link" href="logoutServlet">Đăng Xuất</a></li>
                <% } else { %>
                <li class="nav-item"><a class="nav-link" href="LTQlogin.jsp">Đăng Nhập</a></li>
                <li class="nav-item"><a class="nav-link" href="LTQsignup.jsp">Đăng Ký</a></li>
                <% } %>

                <li class="nav-item"><a class="nav-link" href="viewCart.jsp"><i class="bi bi-cart"></i> Giỏ Hàng</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Tìm kiếm -->
<div class="container mt-4">
    <form action="XeMayServlet" method="get">
    <div class="row">
        <div class="col-md-3">
            <input type="text" name="searchTenXe" class="form-control" placeholder="Tìm tên xe">
        </div>
        <div class="col-md-3">
            <select name="searchLoaiXe" class="form-control">
                <option value="">Chọn loại xe</option>
                <option value="Sport">Sport</option>
                <option value="Scooter">Scooter</option>
                <option value="Underbone">Underbone</option>
                <option value="Naked">Naked</option>
            </select>
        </div>
        <div class="col-md-3">
            <select name="searchHangXe" class="form-control">
                <option value="">Chọn hãng xe</option>
                <option value="Honda">Honda</option>
                <option value="Yamaha">Yamaha</option>
                <option value="Suzuki">Suzuki</option>
                <option value="Kawasaki">Kawasaki</option>
                <option value="Ducati">Ducati</option>
            </select>
        </div>
        <div class="col-md-3">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </div>
    </div>
</form>

</div>
<!-- Carousel (Banner) -->
<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="images/images1.jpg" class="d-block w-100" alt="Image 1">
        </div>
        <div class="carousel-item">
            <img src="images/images2.jpg" class="d-block w-100" alt="Image 2">
        </div>
        <div class="carousel-item">
            <img src="images/images3.jpg" class="d-block w-100" alt="Image 3">
        </div>
        <div class="carousel-item">
            <img src="images/images4.jpg" class="d-block w-100" alt="Image 3">
        </div>
    </div>
    <!-- Thêm các nút điều khiển trước và sau -->
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>


<div class="container mt-5">
    <h2 class="text-center mb-4">Danh Sách Xe Máy</h2>
    <div class="row">
        <% 
            List<XeMay> pageList = (List<XeMay>) request.getAttribute("listXeMay");
            if (pageList != null && !pageList.isEmpty()) {
                for (XeMay xeMay : pageList) { 
        %>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="<%= xeMay.getHinhAnh() %>" class="card-img-top" alt="Hình ảnh xe máy">
                <div class="card-body">
                    <h5 class="card-title"><%= xeMay.getTenXe() %></h5>
                    <p class="card-text"><strong>Loại Xe:</strong> <%= xeMay.getLoaiXe() %></p>
                    <p class="card-text"><strong>Giá:</strong> <%= xeMay.getGiaBan() %> VNĐ</p>
                    <div class="action-buttons">
                        <% if (session.getAttribute("user") == null) { %>
                        <a href="LTQlogin.jsp" class="btn btn-primary btn-sm">Mua Ngay</a>
                        <a href="LTQlogin.jsp" class="btn btn-info btn-sm">Thêm vào Giỏ Hàng</a>
                        <% } else { %>
                        <a href="XeMayServlet?action=buyNow&id=<%= xeMay.getMaXe() %>" class="btn btn-primary btn-sm">Mua Ngay</a>
                        <a href="XeMayServlet?action=addToCart&id=<%= xeMay.getMaXe() %>" class="btn btn-info btn-sm">Thêm vào Giỏ Hàng</a>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
        <% 
                }
            } else { 
        %>
        <div class="col-12 text-center">
            <p class="text-muted">Không có xe máy nào trong danh sách.</p>
        </div>
        <% 
            } 
        %>
    </div>

    <!-- Pagination -->
    <div class="row">
    <div class="col-12 text-center">
        <ul class="pagination">
            <% 
                
                Integer totalPages = (Integer) request.getAttribute("totalPages");
                Integer currentPage = (Integer) request.getAttribute("currentPage");

               
                if (totalPages != null && currentPage != null) { 
            %>
            <% if (currentPage > 1) { %>
                <li class="page-item"><a class="page-link" href="?page=<%= currentPage - 1 %>">Trước</a></li>
            <% } else { %>
                <li class="page-item disabled"><a class="page-link" href="#">Sau</a></li>
            <% } %>

            <% for (int i = 1; i <= totalPages; i++) { %>
                <li class="page-item <%= (i == currentPage) ? "active" : "" %>">
                    <a class="page-link" href="?page=<%= i %>"><%= i %></a>
                </li>
            <% } %>

            <% if (currentPage < totalPages) { %>
                <li class="page-item"><a class="page-link" href="?page=<%= currentPage + 1 %>">Tiếp theo</a></li>
            <% } else { %>
                <li class="page-item disabled"><a class="page-link" href="#">Tiếp theo</a></li>
            <% } %>
            <% } %>
        </ul>
    </div>
</div>

</div>

<!-- Footer -->
<footer class="text-center py-3 mt-5">
    <div class="container">
        <h5 class="text-white">NHỮNG THƯƠNG HIỆU HÀNG ĐẦU</h5>
        <p class="text-muted">Những thương hiệu hàng đầu</p>
        <div class="row justify-content-center">
            <div class="col-md-2">
                <img src="images/honda-logo.jpg" alt="Honda" class="img-fluid" style="max-height: 50px;">
            </div>
            <div class="col-md-2">
                <img src="images/yamaha-logo.jpg" alt="Yamaha" class="img-fluid" style="max-height: 50px;">
            </div>
            <div class="col-md-2">
                <img src="images/piaggio-logo.jpg" alt="Piaggio" class="img-fluid" style="max-height: 50px;">
            </div>
            <div class="col-md-2">
                <img src="images/sym-logo.jpg" alt="SYM" class="img-fluid" style="max-height: 50px;">
            </div>
            
            <div class="col-md-2">
                <img src="images/suzuki-logo.jpg" alt="Suzuki" class="img-fluid" style="max-height: 50px;">
            </div>
        </div>
    </div>
    <p>&copy; 2025 MUAXEMAY.VN. </p>
</footer>
</body>
</html>
