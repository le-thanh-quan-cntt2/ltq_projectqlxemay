package dao;

import model.QuanTri;
import java.sql.*;

public class QuanTriDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_USER_BY_USERNAME = 
        "SELECT * FROM QuanTri WHERE TaiKhoan = ?";
    private static final String INSERT_USER = 
        "INSERT INTO QuanTri (TaiKhoan, MatKhau, TrangThai) VALUES (?, ?, ?)";

    // Kiểm tra xem tài khoản đã tồn tại chưa
    public QuanTri getUserByUsername(String username) {
        QuanTri quanTri = null;
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                quanTri = new QuanTri(rs.getInt("id"), rs.getString("TaiKhoan"), rs.getString("MatKhau"), rs.getBoolean("TrangThai"));
            }
        } catch (SQLException e) {
            System.err.println("Error querying the database: " + e.getMessage()); // Add logging for errors
            e.printStackTrace();
        }
        return quanTri;
    }

    // Thêm người dùng mới
    public void addUser(QuanTri quanTri) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, quanTri.getTaiKhoan());
            preparedStatement.setString(2, quanTri.getMatKhau());
            preparedStatement.setBoolean(3, quanTri.isTrangThai());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting into the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
