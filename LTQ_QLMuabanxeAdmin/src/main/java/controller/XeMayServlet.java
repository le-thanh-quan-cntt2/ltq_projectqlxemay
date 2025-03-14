package controller;

import java.io.IOException;
import java.util.List;

import dao.XeMayDA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.XeMay;

@WebServlet("/XeMayServlet")
public class XeMayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private XeMayDA xeMayDAO;

    public void init() {
        xeMayDAO = new XeMayDA();
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
                deleteXeMay(request, response);
                break;
            default:
                listXeMay(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertXeMay(request, response);
        } else if ("update".equals(action)) {
            updateXeMay(request, response);
        }
    }

    private void listXeMay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        String page = request.getParameter("page");
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        int offset = (currentPage - 1) * XeMayDA.ITEMS_PER_PAGE;

        List<XeMay> listXeMay = xeMayDAO.selectPage(offset, XeMayDA.ITEMS_PER_PAGE);
        int totalItems = xeMayDAO.countItems();
        int totalPages = (int) Math.ceil((double) totalItems / XeMayDA.ITEMS_PER_PAGE);

        request.setAttribute("listXeMay", listXeMay);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listXeMay.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addXeMay.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        XeMay xeMay = xeMayDAO.selectById(id);
        request.setAttribute("xeMay", xeMay);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editXeMay.jsp");
        dispatcher.forward(request, response);
    }

    private void insertXeMay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tenXe = request.getParameter("tenXe");
        String loaiXe = request.getParameter("loaiXe");
        String hangSanXuat = request.getParameter("hangSanXuat");
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        String mauSac = request.getParameter("mauSac");
        double giaBan = Double.parseDouble(request.getParameter("giaBan"));
        String tinhTrang = request.getParameter("tinhTrang");
        String hinhAnh = request.getParameter("hinhAnh");

        XeMay xeMay = new XeMay(0, tenXe, loaiXe, hangSanXuat, namSanXuat, mauSac, giaBan, tinhTrang, hinhAnh);
        xeMayDAO.insert(xeMay);
        response.sendRedirect("XeMayServlet?action=list");
    }

    private void updateXeMay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenXe = request.getParameter("tenXe");
        String loaiXe = request.getParameter("loaiXe");
        String hangSanXuat = request.getParameter("hangSanXuat");
        int namSanXuat = Integer.parseInt(request.getParameter("namSanXuat"));
        String mauSac = request.getParameter("mauSac");
        double giaBan = Double.parseDouble(request.getParameter("giaBan"));
        String tinhTrang = request.getParameter("tinhTrang");
        String hinhAnh = request.getParameter("hinhAnh");

        XeMay xeMay = new XeMay(id, tenXe, loaiXe, hangSanXuat, namSanXuat, mauSac, giaBan, tinhTrang, hinhAnh);
        xeMayDAO.update(xeMay);
        response.sendRedirect("XeMayServlet?action=list");
    }

    private void deleteXeMay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        xeMayDAO.delete(id);
        response.sendRedirect("XeMayServlet?action=list");
    }
}
