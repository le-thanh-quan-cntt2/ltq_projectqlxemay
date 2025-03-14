package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DonHang;

public class DonHangDA {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL = "SELECT * FROM Don_Hang";
    private static final String SELECT_BY_ID = "SELECT * FROM Don_Hang WHERE Ma_Don_Hang = ?";
    private static final String INSERT = "INSERT INTO Don_Hang (Ma_Khach_Hang, Ma_Nhan_Vien, Ma_Xe, So_Luong, Trang_Thai_Don) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Don_Hang SET Ma_Khach_Hang = ?, Ma_Nhan_Vien = ?, Ma_Xe = ?, So_Luong = ?, Trang_Thai_Don = ? WHERE Ma_Don_Hang = ?";
    private static final String DELETE = "DELETE FROM Don_Hang WHERE Ma_Don_Hang = ?";

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<DonHang> selectAll() {
        List<DonHang> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DonHang donHang = new DonHang(
                    rs.getInt("Ma_Don_Hang"),
                    rs.getInt("Ma_Khach_Hang"),
                    rs.getObject("Ma_Nhan_Vien") != null ? rs.getInt("Ma_Nhan_Vien") : null,
                    rs.getInt("Ma_Xe"),
                    rs.getInt("So_Luong"),
                    rs.getTimestamp("Ngay_Dat_Hang"),
                    rs.getString("Trang_Thai_Don")
                );
                list.add(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public DonHang selectById(int id) {
        DonHang donHang = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                donHang = new DonHang(
                    rs.getInt("Ma_Don_Hang"),
                    rs.getInt("Ma_Khach_Hang"),
                    rs.getObject("Ma_Nhan_Vien") != null ? rs.getInt("Ma_Nhan_Vien") : null,
                    rs.getInt("Ma_Xe"),
                    rs.getInt("So_Luong"),
                    rs.getTimestamp("Ngay_Dat_Hang"),
                    rs.getString("Trang_Thai_Don")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donHang;
    }

    public void insert(DonHang donHang) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, donHang.getMaKhachHang());
            if (donHang.getMaNhanVien() != null) {
                preparedStatement.setInt(2, donHang.getMaNhanVien());
            } else {
                preparedStatement.setNull(2, Types.INTEGER);
            }
            preparedStatement.setInt(3, donHang.getMaXe());
            preparedStatement.setInt(4, donHang.getSoLuong());
            preparedStatement.setString(5, donHang.getTrangThaiDon());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(DonHang donHang) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, donHang.getMaKhachHang());
            if (donHang.getMaNhanVien() != null) {
                preparedStatement.setInt(2, donHang.getMaNhanVien());
            } else {
                preparedStatement.setNull(2, Types.INTEGER);
            }
            preparedStatement.setInt(3, donHang.getMaXe());
            preparedStatement.setInt(4, donHang.getSoLuong());
            preparedStatement.setString(5, donHang.getTrangThaiDon());
            preparedStatement.setInt(6, donHang.getMaDonHang());
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
}
