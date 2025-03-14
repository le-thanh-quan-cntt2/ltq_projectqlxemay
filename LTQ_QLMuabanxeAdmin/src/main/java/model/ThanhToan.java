package model;

import java.util.Date;

public class ThanhToan {
    private int maThanhToan;
    private int maDonHang;
    private double soTien;
    private String phuongThucThanhToan;
    private Date ngayThanhToan;

    public ThanhToan() {}

    // Constructor cho select (bao gồm id và ngày thanh toán)
    public ThanhToan(int maThanhToan, int maDonHang, double soTien, String phuongThucThanhToan, Date ngayThanhToan) {
        this.maThanhToan = maThanhToan;
        this.maDonHang = maDonHang;
        this.soTien = soTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ngayThanhToan = ngayThanhToan;
    }

    // Constructor cho insert
    public ThanhToan(int maDonHang, double soTien, String phuongThucThanhToan) {
        this.maDonHang = maDonHang;
        this.soTien = soTien;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    // Getters và Setters
    public int getMaThanhToan() {
        return maThanhToan;
    }
    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }
    public int getMaDonHang() {
        return maDonHang;
    }
    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }
    public double getSoTien() {
        return soTien;
    }
    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }
    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }
    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }
    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
}
