package controller;

import java.io.IOException;
import java.util.List;

import dao.DonHangDA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DonHang;

@WebServlet("/DonHangServlet")
public class DonHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DonHangDA donHangDAO;

    public void init() {
        donHangDAO = new DonHangDA();
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
                deleteDonHang(request, response);
                break;
            default:
                listDonHang(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertDonHang(request, response);
        } else if ("update".equals(action)) {
            updateDonHang(request, response);
        }
    }

    private void listDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DonHang> listDonHang = donHangDAO.selectAll();
        request.setAttribute("listDonHang", listDonHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listDonHang.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addDonHang.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DonHang donHang = donHangDAO.selectById(id);
        if (donHang != null) {
            request.setAttribute("donHang", donHang);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editDonHang.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("DonHangServlet?action=list");
        }
    }

    private void insertDonHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        String maNhanVienStr = request.getParameter("maNhanVien");
        Integer maNhanVien = (maNhanVienStr != null && !maNhanVienStr.isEmpty()) ? Integer.parseInt(maNhanVienStr) : null;
        int maXe = Integer.parseInt(request.getParameter("maXe"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String trangThaiDon = request.getParameter("trangThaiDon");

        DonHang donHang = new DonHang(maKhachHang, maNhanVien, maXe, soLuong, trangThaiDon);
        donHangDAO.insert(donHang);
        response.sendRedirect("DonHangServlet?action=list");
    }

    private void updateDonHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int maKhachHang = Integer.parseInt(request.getParameter("maKhachHang"));
        String maNhanVienStr = request.getParameter("maNhanVien");
        Integer maNhanVien = (maNhanVienStr != null && !maNhanVienStr.isEmpty()) ? Integer.parseInt(maNhanVienStr) : null;
        int maXe = Integer.parseInt(request.getParameter("maXe"));
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String trangThaiDon = request.getParameter("trangThaiDon");

        DonHang donHang = new DonHang(id, maKhachHang, maNhanVien, maXe, soLuong, null, trangThaiDon);
        donHangDAO.update(donHang);
        response.sendRedirect("DonHangServlet?action=list");
    }

    private void deleteDonHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        donHangDAO.delete(id);
        response.sendRedirect("DonHangServlet?action=list");
    }
}
