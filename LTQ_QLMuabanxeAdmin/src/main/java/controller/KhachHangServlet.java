package controller;

import java.io.IOException;
import java.util.List;

import dao.KhachHangDA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;

@WebServlet("/KhachHangServlet")
public class KhachHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private KhachHangDA khachHangDAO;

    public void init() {
        khachHangDAO = new KhachHangDA();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteKhachHang(request, response);
                break;
            default:
                listKhachHang(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertKhachHang(request, response);
        } else if ("update".equals(action)) {
            updateKhachHang(request, response);
        }
    }

    private void listKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> listKhachHang = khachHangDAO.selectAll();
        request.setAttribute("listKhachHang", listKhachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listKhachHang.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addKhachHang.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang khachHang = khachHangDAO.selectById(id); // Ensure this method returns a valid KhachHang object

        if (khachHang != null) {
            request.setAttribute("khachHang", khachHang); // Set the attribute correctly
            RequestDispatcher dispatcher = request.getRequestDispatcher("editKhachHang.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("KhachHangServlet?action=list"); // Redirect to list if the customer doesn't exist
        }
    }


    private void insertKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        KhachHang khachHang = new KhachHang(0, hoTen, diaChi, soDienThoai, email);
        khachHangDAO.insert(khachHang);
        response.sendRedirect("KhachHangServlet?action=list");
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        KhachHang khachHang = new KhachHang(id, hoTen, diaChi, soDienThoai, email);
        khachHangDAO.update(khachHang);
        response.sendRedirect("KhachHangServlet?action=list");
    }

    private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        khachHangDAO.delete(id);
        response.sendRedirect("KhachHangServlet?action=list");
    }
}
