package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.QuanTriDAO;
import model.QuanTri;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        
        if (!password.equals(confirmPassword)) {
            
            response.sendRedirect("signup.jsp?error=M%E1%BB%99t%20kh%E1%BA%A9u%20kh%C3%B4ng%20kh%C3%B3p");
            return;
        }

        QuanTriDAO quanTriDAO = new QuanTriDAO();

        
        if (quanTriDAO.getUserByUsername(username) != null) {
            
            response.sendRedirect("signup.jsp?error=T%C3%A0i%20kh%C3%B3an%20%C4%91%C3%A3%20t%E1%BB%93n%20t%E1%BA%A1i");
            return;
        }

        
        QuanTri newUser = new QuanTri(0, username, password, true);

       
        quanTriDAO.addUser(newUser);

        
        response.sendRedirect("LTQlogin.jsp");
    }
}