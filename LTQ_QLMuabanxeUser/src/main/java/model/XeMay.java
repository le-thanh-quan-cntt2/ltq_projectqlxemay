package model;

public class XeMay {
    private int maXe;
    private String tenXe;
    private String loaiXe;
    private String hangSanXuat;
    private int namSanXuat;
    private String mauSac;
    private double giaBan;
    private String tinhTrang;
    private String hinhAnh;

    public XeMay() {}

    public XeMay(int maXe, String tenXe, String loaiXe, String hangSanXuat, int namSanXuat, String mauSac, double giaBan, String tinhTrang, String hinhAnh) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.loaiXe = loaiXe;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.mauSac = mauSac;
        this.giaBan = giaBan;
        this.tinhTrang = tinhTrang;
        this.hinhAnh = hinhAnh;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}