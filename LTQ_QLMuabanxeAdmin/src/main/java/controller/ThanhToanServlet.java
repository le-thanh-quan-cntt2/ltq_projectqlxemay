package controller;

import java.io.IOException;
import java.util.List;

import dao.ThanhToanDA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ThanhToan;

@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ThanhToanDA thanhToanDAO;

    public void init() {
        thanhToanDAO = new ThanhToanDA();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) action = "list";
        switch(action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteThanhToan(request, response);
                break;
            default:
                listThanhToan(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("insert".equals(action)) {
            insertThanhToan(request, response);
        } else if("update".equals(action)) {
            updateThanhToan(request, response);
        }
    }

    private void listThanhToan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThanhToan> listThanhToan = thanhToanDAO.selectAll();
        request.setAttribute("listThanhToan", listThanhToan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listThanhToan.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addThanhToan.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ThanhToan tt = thanhToanDAO.selectById(id);
        if(tt != null) {
            request.setAttribute("thanhToan", tt);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editThanhToan.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("ThanhToanServlet?action=list");
        }
    }

    private void insertThanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
        double soTien = Double.parseDouble(request.getParameter("soTien"));
        String phuongThucThanhToan = request.getParameter("phuongThucThanhToan");

        ThanhToan tt = new ThanhToan(maDonHang, soTien, phuongThucThanhToan);
        thanhToanDAO.insert(tt);
        response.sendRedirect("ThanhToanServlet?action=list");
    }

    private void updateThanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
        double soTien = Double.parseDouble(request.getParameter("soTien"));
        String phuongThucThanhToan = request.getParameter("phuongThucThanhToan");

        ThanhToan tt = new ThanhToan(id, maDonHang, soTien, phuongThucThanhToan, null);
        thanhToanDAO.update(tt);
        response.sendRedirect("ThanhToanServlet?action=list");
    }

    private void deleteThanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        thanhToanDAO.delete(id);
        response.sendRedirect("ThanhToanServlet?action=list");
    }
}
