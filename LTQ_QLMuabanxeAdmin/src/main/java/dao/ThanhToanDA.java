package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThanhToan;

public class ThanhToanDA {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL = "SELECT * FROM Thanh_Toan";
    private static final String SELECT_BY_ID = "SELECT * FROM Thanh_Toan WHERE Ma_Thanh_Toan = ?";
    private static final String INSERT = "INSERT INTO Thanh_Toan (Ma_Don_Hang, So_Tien, Phuong_Thuc_Thanh_Toan) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE Thanh_Toan SET Ma_Don_Hang = ?, So_Tien = ?, Phuong_Thuc_Thanh_Toan = ? WHERE Ma_Thanh_Toan = ?";
    private static final String DELETE = "DELETE FROM Thanh_Toan WHERE Ma_Thanh_Toan = ?";

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<ThanhToan> selectAll() {
        List<ThanhToan> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThanhToan tt = new ThanhToan(
                    rs.getInt("Ma_Thanh_Toan"),
                    rs.getInt("Ma_Don_Hang"),
                    rs.getDouble("So_Tien"),
                    rs.getString("Phuong_Thuc_Thanh_Toan"),
                    rs.getTimestamp("Ngay_Thanh_Toan")
                );
                list.add(tt);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ThanhToan selectById(int id) {
        ThanhToan tt = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tt = new ThanhToan(
                    rs.getInt("Ma_Thanh_Toan"),
                    rs.getInt("Ma_Don_Hang"),
                    rs.getDouble("So_Tien"),
                    rs.getString("Phuong_Thuc_Thanh_Toan"),
                    rs.getTimestamp("Ngay_Thanh_Toan")
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return tt;
    }

    public void insert(ThanhToan tt) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setInt(1, tt.getMaDonHang());
            ps.setDouble(2, tt.getSoTien());
            ps.setString(3, tt.getPhuongThucThanhToan());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ThanhToan tt) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, tt.getMaDonHang());
            ps.setDouble(2, tt.getSoTien());
            ps.setString(3, tt.getPhuongThucThanhToan());
            ps.setInt(4, tt.getMaThanhToan());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
