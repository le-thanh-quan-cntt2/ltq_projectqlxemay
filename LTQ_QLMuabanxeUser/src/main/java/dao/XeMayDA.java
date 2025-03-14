package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.XeMay;

public class XeMayDA {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL = "SELECT * FROM Xe_May";
    private static final String SELECT_BY_ID = "SELECT * FROM Xe_May WHERE Ma_Xe = ?";
    private static final String SEARCH_BY_NAME = "SELECT * FROM Xe_May WHERE Ten_Xe LIKE ?";
    private static final String SEARCH_BY_TYPE = "SELECT * FROM Xe_May WHERE Loai_Xe = ?";
    private static final String SEARCH_BY_BRAND = "SELECT * FROM Xe_May WHERE Hang_San_Xuat = ?";

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<XeMay> selectAll() {
        List<XeMay> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                XeMay xeMay = new XeMay(
                    rs.getInt("Ma_Xe"),
                    rs.getString("Ten_Xe"),
                    rs.getString("Loai_Xe"),
                    rs.getString("Hang_San_Xuat"),
                    rs.getInt("Nam_San_Xuat"),
                    rs.getString("Mau_Sac"),
                    rs.getDouble("Gia_Ban"),
                    rs.getString("Tinh_Trang"),
                    rs.getString("Hinh_Anh")
                );
                list.add(xeMay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Recherche par nom de véhicule
    public List<XeMay> searchByName(String name) {
        List<XeMay> list = new ArrayList<>();
        String query = "%" + name + "%";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                XeMay xeMay = new XeMay(
                    rs.getInt("Ma_Xe"),
                    rs.getString("Ten_Xe"),
                    rs.getString("Loai_Xe"),
                    rs.getString("Hang_San_Xuat"),
                    rs.getInt("Nam_San_Xuat"),
                    rs.getString("Mau_Sac"),
                    rs.getDouble("Gia_Ban"),
                    rs.getString("Tinh_Trang"),
                    rs.getString("Hinh_Anh")
                );
                list.add(xeMay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Recherche par type de véhicule (Sport, Scooter, etc.)
    public List<XeMay> searchByType(String type) {
        List<XeMay> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_TYPE)) {
            preparedStatement.setString(1, type);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                XeMay xeMay = new XeMay(
                    rs.getInt("Ma_Xe"),
                    rs.getString("Ten_Xe"),
                    rs.getString("Loai_Xe"),
                    rs.getString("Hang_San_Xuat"),
                    rs.getInt("Nam_San_Xuat"),
                    rs.getString("Mau_Sac"),
                    rs.getDouble("Gia_Ban"),
                    rs.getString("Tinh_Trang"),
                    rs.getString("Hinh_Anh")
                );
                list.add(xeMay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Recherche par marque de véhicule
    public List<XeMay> searchByBrand(String brand) {
        List<XeMay> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_BRAND)) {
            preparedStatement.setString(1, brand);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                XeMay xeMay = new XeMay(
                    rs.getInt("Ma_Xe"),
                    rs.getString("Ten_Xe"),
                    rs.getString("Loai_Xe"),
                    rs.getString("Hang_San_Xuat"),
                    rs.getInt("Nam_San_Xuat"),
                    rs.getString("Mau_Sac"),
                    rs.getDouble("Gia_Ban"),
                    rs.getString("Tinh_Trang"),
                    rs.getString("Hinh_Anh")
                );
                list.add(xeMay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public XeMay selectById(int id) {
        XeMay xeMay = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                xeMay = new XeMay(
                    rs.getInt("Ma_Xe"),
                    rs.getString("Ten_Xe"),
                    rs.getString("Loai_Xe"),
                    rs.getString("Hang_San_Xuat"),
                    rs.getInt("Nam_San_Xuat"),
                    rs.getString("Mau_Sac"),
                    rs.getDouble("Gia_Ban"),
                    rs.getString("Tinh_Trang"),
                    rs.getString("Hinh_Anh")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xeMay;
    }
}
