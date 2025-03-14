package controller;

import java.io.IOException;
import java.util.List;

import dao.KhoDA;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Kho;

@WebServlet("/KhoServlet")
public class KhoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private KhoDA khoDAO;

    public void init() {
        khoDAO = new KhoDA();
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
                deleteKho(request, response);
                break;
            default:
                listKho(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("insert".equals(action)) {
            insertKho(request, response);
        } else if("update".equals(action)) {
            updateKho(request, response);
        }
    }

    private void listKho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Kho> listKho = khoDAO.selectAll();
        request.setAttribute("listKho", listKho);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listKho.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addKho.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maXe = Integer.parseInt(request.getParameter("maXe"));
        Kho kho = khoDAO.selectById(maXe);
        if(kho != null) {
            request.setAttribute("kho", kho);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editKho.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("KhoServlet?action=list");
        }
    }

    private void insertKho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maXe = Integer.parseInt(request.getParameter("maXe"));
        int soLuongKho = Integer.parseInt(request.getParameter("soLuongKho"));
        String maNhanVienNhapStr = request.getParameter("maNhanVienNhap");
        Integer maNhanVienNhap = (maNhanVienNhapStr != null && !maNhanVienNhapStr.isEmpty()) ? Integer.parseInt(maNhanVienNhapStr) : null;
        Kho kho = new Kho(maXe, soLuongKho, maNhanVienNhap);
        khoDAO.insert(kho);
        response.sendRedirect("KhoServlet?action=list");
    }

    private void updateKho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maXe = Integer.parseInt(request.getParameter("maXe"));
        int soLuongKho = Integer.parseInt(request.getParameter("soLuongKho"));
        String maNhanVienNhapStr = request.getParameter("maNhanVienNhap");
        Integer maNhanVienNhap = (maNhanVienNhapStr != null && !maNhanVienNhapStr.isEmpty()) ? Integer.parseInt(maNhanVienNhapStr) : null;
        Kho kho = new Kho(maXe, soLuongKho, null, maNhanVienNhap);
        khoDAO.update(kho);
        response.sendRedirect("KhoServlet?action=list");
    }

    private void deleteKho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int maXe = Integer.parseInt(request.getParameter("maXe"));
        khoDAO.delete(maXe);
        response.sendRedirect("KhoServlet?action=list");
    }
}
