package dao;

import model.Cart;
import model.CartItem;
import model.XeMay;

import java.sql.*;
import java.util.Map;

public class LTQDonHangDAO {
    private static final String INSERT_ORDER = "INSERT INTO Don_Hang (Ma_Khach_Hang, Ma_Nhan_Vien, So_Luong, Ma_Xe, Trang_Thai_Don) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_PAYMENT = "INSERT INTO Thanh_Toan (Ma_Don_Hang, So_Tien, Phuong_Thuc_Thanh_Toan) VALUES (?, ?, ?)";
    private static final String INSERT_INVOICE = "INSERT INTO Hoa_Don (Ma_Don_Hang, So_Tien, Thue) VALUES (?, ?, ?)";

    public int insertOrder(int customerId, int employeeId, Cart cart, double totalPrice, String orderStatus) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57", "root", "");
             PreparedStatement orderStmt = conn.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {

            // Insert the order
            orderStmt.setInt(1, customerId);
            orderStmt.setInt(2, employeeId);
            orderStmt.setInt(3, cart.getItems().size());
            orderStmt.setInt(4, cart.getItems().keySet().iterator().next()); // Using one XeMay for simplicity
            orderStmt.setString(5, orderStatus);

            int affectedRows = orderStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = orderStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);

                    // Insert payment details (payment method could be determined based on user selection)
                    try (PreparedStatement paymentStmt = conn.prepareStatement(INSERT_PAYMENT)) {
                        paymentStmt.setInt(1, orderId);
                        paymentStmt.setDouble(2, totalPrice);
                        paymentStmt.setString(3, "Credit Card");
                        paymentStmt.executeUpdate();
                    }

                    // Insert invoice
                    try (PreparedStatement invoiceStmt = conn.prepareStatement(INSERT_INVOICE)) {
                        invoiceStmt.setInt(1, orderId);
                        invoiceStmt.setDouble(2, totalPrice);
                        invoiceStmt.setDouble(3, totalPrice * 0.1); // Assume a 10% tax
                        invoiceStmt.executeUpdate();
                    }

                    return orderId;
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; // Failure case
    }
}