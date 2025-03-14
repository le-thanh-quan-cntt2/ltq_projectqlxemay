package model;

public class CartItem {
    private XeMay xeMay;
    private int quantity;

    public CartItem(XeMay xeMay, int quantity) {
        this.xeMay = xeMay;
        this.quantity = quantity;
    }

    public XeMay getXeMay() {
        return xeMay;
    }

    public void setXeMay(XeMay xeMay) {
        this.xeMay = xeMay;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
