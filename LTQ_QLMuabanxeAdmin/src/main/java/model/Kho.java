package model;

import java.util.Date;

public class Kho {
    private int maXe;
    private int soLuongKho;
    private Date ngayNhapKho;
    private Integer maNhanVienNhap;

    public Kho() {}

    // Constructor bao gồm ngày nhập kho (được lấy tự động)
    public Kho(int maXe, int soLuongKho, Date ngayNhapKho, Integer maNhanVienNhap) {
        this.maXe = maXe;
        this.soLuongKho = soLuongKho;
        this.ngayNhapKho = ngayNhapKho;
        this.maNhanVienNhap = maNhanVienNhap;
    }
    
    // Constructor cho insert (không cần ngày nhập)
    public Kho(int maXe, int soLuongKho, Integer maNhanVienNhap) {
        this.maXe = maXe;
        this.soLuongKho = soLuongKho;
        this.maNhanVienNhap = maNhanVienNhap;
    }

    // Getters và Setters
    public int getMaXe() {
        return maXe;
    }
    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }
    public int getSoLuongKho() {
        return soLuongKho;
    }
    public void setSoLuongKho(int soLuongKho) {
        this.soLuongKho = soLuongKho;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    public Integer getMaNhanVienNhap() {
        return maNhanVienNhap;
    }
    public void setMaNhanVienNhap(Integer maNhanVienNhap) {
        this.maNhanVienNhap = maNhanVienNhap;
    }
}
