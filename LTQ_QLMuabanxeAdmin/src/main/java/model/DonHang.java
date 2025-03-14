package model;

import java.util.Date;

public class DonHang {
    private int maDonHang;
    private int maKhachHang;
    private Integer maNhanVien; // có thể null
    private int maXe;
    private int soLuong;
    private Date ngayDatHang;
    private String trangThaiDon;

    public DonHang() {}

    // Constructor cho select (bao gồm id và ngày đặt hàng)
    public DonHang(int maDonHang, int maKhachHang, Integer maNhanVien, int maXe, int soLuong, Date ngayDatHang, String trangThaiDon) {
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maXe = maXe;
        this.soLuong = soLuong;
        this.ngayDatHang = ngayDatHang;
        this.trangThaiDon = trangThaiDon;
    }

    // Constructor cho insert (không cần id, ngày đặt hàng tự động)
    public DonHang(int maKhachHang, Integer maNhanVien, int maXe, int soLuong, String trangThaiDon) {
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maXe = maXe;
        this.soLuong = soLuong;
        this.trangThaiDon = trangThaiDon;
    }

    // Getters và Setters
    public int getMaDonHang() {
        return maDonHang;
    }
    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }
    public int getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public Integer getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public int getMaXe() {
        return maXe;
    }
    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public Date getNgayDatHang() {
        return ngayDatHang;
    }
    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }
    public String getTrangThaiDon() {
        return trangThaiDon;
    }
    public void setTrangThaiDon(String trangThaiDon) {
        this.trangThaiDon = trangThaiDon;
    }
}
