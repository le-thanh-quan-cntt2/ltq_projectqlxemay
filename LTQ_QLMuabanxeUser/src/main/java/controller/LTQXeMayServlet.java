package controller;

import java.io.IOException;
import java.util.List;

import dao.XeMayDA;
import dao.LTQDonHangDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.XeMay;
import model.Cart;

@WebServlet("/XeMayServlet")
public class LTQXeMayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private XeMayDA xeMayDAO;

    public void init() {
        xeMayDAO = new XeMayDA();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "buyNow":
                buyNow(request, response);
                break;
            case "addToCart":
                addToCart(request, response);
                break;
            case "viewCart":
                viewCart(request, response);
                break;
            case "checkout":
                checkout(request, response);
                break;
            case "removeItem":
                removeItem(request, response);
                break;
            default:
                listXeMay(request, response);
                break;
        }
    }

    private void listXeMay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String searchTenXe = request.getParameter("searchTenXe");
        String searchLoaiXe = request.getParameter("searchLoaiXe");
        String searchHangXe = request.getParameter("searchHangXe");

       
        List<XeMay> listXeMay;
        if (searchTenXe != null && !searchTenXe.isEmpty()) {
            listXeMay = xeMayDAO.searchByName(searchTenXe);
        } else if (searchLoaiXe != null && !searchLoaiXe.isEmpty()) {
            listXeMay = xeMayDAO.searchByType(searchLoaiXe);
        } else if (searchHangXe != null && !searchHangXe.isEmpty()) {
            listXeMay = xeMayDAO.searchByBrand(searchHangXe);
        } else {
            listXeMay = xeMayDAO.selectAll(); 
        }

       
        int pageSize = 6; 
        int currentPage = 1; 

        
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }

        
        int totalPages = (int) Math.ceil(listXeMay.size() / (double) pageSize);
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, listXeMay.size());

        
        List<XeMay> pageList = listXeMay.subList(startIndex, endIndex);

       
        request.setAttribute("listXeMay", pageList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listXeMay.jsp");
        dispatcher.forward(request, response);
    }
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        XeMay xeMay = xeMayDAO.selectById(id);
        int quantity = 1;

        
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(xeMay, quantity);

        response.sendRedirect("XeMayServlet?action=viewCart");
    }

    private void buyNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        XeMay xeMay = xeMayDAO.selectById(id);

     
        Cart cart = new Cart();
        cart.addItem(xeMay, 1);
        request.getSession().setAttribute("cart", cart);

        response.sendRedirect("checkout.jsp");
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        request.setAttribute("cart", cart);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewCart.jsp");
        dispatcher.forward(request, response);
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
         
            response.sendRedirect("XeMayServlet?action=viewCart");
            return;
        }

     
        response.sendRedirect("checkout.jsp");
    }

    private void removeItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.removeItem(id);
        }
        response.sendRedirect("XeMayServlet?action=viewCart");
    }
}
