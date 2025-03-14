package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

public class KhachHangDA {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL = "SELECT * FROM Khach_Hang";
    private static final String INSERT = "INSERT INTO Khach_Hang (Ho_Ten, Dia_Chi, So_Dien_Thoai, Email) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM Khach_Hang WHERE Ma_Khach_Hang = ?";
    private static final String UPDATE = "UPDATE Khach_Hang SET Ho_Ten = ?, Dia_Chi = ?, So_Dien_Thoai = ?, Email = ? WHERE Ma_Khach_Hang = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Khach_Hang WHERE Ma_Khach_Hang = ?";

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<KhachHang> selectAll() {
        List<KhachHang> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                list.add(new KhachHang(
                    rs.getInt("Ma_Khach_Hang"),
                    rs.getString("Ho_Ten"),
                    rs.getString("Dia_Chi"),
                    rs.getString("So_Dien_Thoai"),
                    rs.getString("Email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(KhachHang khachHang) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, khachHang.getHoTen());
            preparedStatement.setString(2, khachHang.getDiaChi());
            preparedStatement.setString(3, khachHang.getSoDienThoai());
            preparedStatement.setString(4, khachHang.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(KhachHang khachHang) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, khachHang.getHoTen());
            preparedStatement.setString(2, khachHang.getDiaChi());
            preparedStatement.setString(3, khachHang.getSoDienThoai());
            preparedStatement.setString(4, khachHang.getEmail());
            preparedStatement.setInt(5, khachHang.getMaKhachHang());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public KhachHang selectById(int id) {
        KhachHang khachHang = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                khachHang = new KhachHang(
                    rs.getInt("Ma_Khach_Hang"),
                    rs.getString("Ho_Ten"),
                    rs.getString("Dia_Chi"),
                    rs.getString("So_Dien_Thoai"),
                    rs.getString("Email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}
