package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public void addItem(XeMay xeMay, int quantity) {
        CartItem item = items.get(xeMay.getMaXe());
        if (item == null) {
            items.put(xeMay.getMaXe(), new CartItem(xeMay, quantity));
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
    }

    public void removeItem(int xeMayId) {
        items.remove(xeMayId);
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items.values()) {
            total += item.getXeMay().getGiaBan() * item.getQuantity();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }
}
