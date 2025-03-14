package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.XeMay;

public class XeMayDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL = "SELECT * FROM Xe_May";
    private static final String INSERT = "INSERT INTO Xe_May (Ten_Xe, Loai_Xe, Hang_San_Xuat, Nam_San_Xuat, Mau_Sac, Gia_Ban, Tinh_Trang, Hinh_Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM Xe_May WHERE Ma_Xe = ?";
    private static final String UPDATE = "UPDATE Xe_May SET Ten_Xe = ?, Loai_Xe = ?, Hang_San_Xuat = ?, Nam_San_Xuat = ?, Mau_Sac = ?, Gia_Ban = ?, Tinh_Trang = ?, Hinh_Anh = ? WHERE Ma_Xe = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Xe_May WHERE Ma_Xe = ?";

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
                list.add(new XeMay(
                    rs.getInt("Ma_Xe"),
                    rs.getString("Ten_Xe"),
                    rs.getString("Loai_Xe"),
                    rs.getString("Hang_San_Xuat"),
                    rs.getInt("Nam_San_Xuat"),
                    rs.getString("Mau_Sac"),
                    rs.getDouble("Gia_Ban"),
                    rs.getString("Tinh_Trang"),
                    rs.getString("Hinh_Anh")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(XeMay xeMay) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, xeMay.getTenXe());
            preparedStatement.setString(2, xeMay.getLoaiXe());
            preparedStatement.setString(3, xeMay.getHangSanXuat());
            preparedStatement.setInt(4, xeMay.getNamSanXuat());
            preparedStatement.setString(5, xeMay.getMauSac());
            preparedStatement.setDouble(6, xeMay.getGiaBan());
            preparedStatement.setString(7, xeMay.getTinhTrang());
            preparedStatement.setString(8, xeMay.getHinhAnh());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(XeMay xeMay) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, xeMay.getTenXe());
            preparedStatement.setString(2, xeMay.getLoaiXe());
            preparedStatement.setString(3, xeMay.getHangSanXuat());
            preparedStatement.setInt(4, xeMay.getNamSanXuat());
            preparedStatement.setString(5, xeMay.getMauSac());
            preparedStatement.setDouble(6, xeMay.getGiaBan());
            preparedStatement.setString(7, xeMay.getTinhTrang());
            preparedStatement.setString(8, xeMay.getHinhAnh());
            preparedStatement.setInt(9, xeMay.getMaXe());
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
