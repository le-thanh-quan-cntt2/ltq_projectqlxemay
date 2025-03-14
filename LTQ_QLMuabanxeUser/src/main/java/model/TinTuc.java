package model;

public class TinTuc {
    private int id;
    private String tieuDe;
    private String moTa;
    private String hinhAnh;

    // Constructor, getters, and setters
    public TinTuc(int id, String tieuDe, String moTa, String hinhAnh) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
