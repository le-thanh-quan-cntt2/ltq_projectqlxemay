package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.QuanTriDAO;
import model.QuanTri;

@WebServlet("/LTQloginServlet")
public class LTQLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

     
        QuanTriDAO quanTriDAO = new QuanTriDAO();
        QuanTri quanTri = quanTriDAO.getUserByUsername(username);

        if (quanTri != null && quanTri.getMatKhau().equals(password)) {
           
            request.getSession().setAttribute("user", quanTri);

            // Đăng nhập thành công
            response.sendRedirect("XeMayServlet?action=list");
        } else {
            // Đăng nhập thất bại
            response.sendRedirect("login.jsp?error=Tên người dùng hoặc mật khẩu không hợp lệ");
        }
    }
}
