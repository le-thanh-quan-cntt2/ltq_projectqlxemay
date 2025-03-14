package dao;

import java.sql.*;

public class ThanhToanDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_PAYMENT = "INSERT INTO Thanh_Toan (Ma_Don_Hang, So_Tien, Phuong_Thuc_Thanh_Toan) VALUES (?, ?, ?)";

    public void insertPayment(int orderId, double totalPrice, String paymentMethod) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.setDouble(2, totalPrice);
            preparedStatement.setString(3, paymentMethod);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
