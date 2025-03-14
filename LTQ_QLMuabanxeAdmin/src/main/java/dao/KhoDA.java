package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Kho;

public class KhoDA {
    private String jdbcURL = "jdbc:mysql://localhost:3306/LTQ_QuanLyBanXe57";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_ALL = "SELECT * FROM Kho";
    private static final String SELECT_BY_ID = "SELECT * FROM Kho WHERE Ma_Xe = ?";
    private static final String INSERT = "INSERT INTO Kho (Ma_Xe, So_Luong_Kho, Ma_Nhan_Vien_Nhap) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE Kho SET So_Luong_Kho = ?, Ma_Nhan_Vien_Nhap = ? WHERE Ma_Xe = ?";
    private static final String DELETE = "DELETE FROM Kho WHERE Ma_Xe = ?";

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

    public List<Kho> selectAll() {
        List<Kho> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Kho kho = new Kho(
                    rs.getInt("Ma_Xe"),
                    rs.getInt("So_Luong_Kho"),
                    rs.getTimestamp("Ngay_Nhap_Kho"),
                    rs.getObject("Ma_Nhan_Vien_Nhap") != null ? rs.getInt("Ma_Nhan_Vien_Nhap") : null
                );
                list.add(kho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Kho selectById(int maXe) {
        Kho kho = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, maXe);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                kho = new Kho(
                    rs.getInt("Ma_Xe"),
                    rs.getInt("So_Luong_Kho"),
                    rs.getTimestamp("Ngay_Nhap_Kho"),
                    rs.getObject("Ma_Nhan_Vien_Nhap") != null ? rs.getInt("Ma_Nhan_Vien_Nhap") : null
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return kho;
    }

    public void insert(Kho kho) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setInt(1, kho.getMaXe());
            ps.setInt(2, kho.getSoLuongKho());
            if(kho.getMaNhanVienNhap() != null){
                ps.setInt(3, kho.getMaNhanVienNhap());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Kho kho) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, kho.getSoLuongKho());
            if(kho.getMaNhanVienNhap() != null){
                ps.setInt(2, kho.getMaNhanVienNhap());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            ps.setInt(3, kho.getMaXe());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int maXe) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, maXe);
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
