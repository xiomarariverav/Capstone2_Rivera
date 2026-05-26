package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {

    private ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        // newest item first
        items.add(0, item);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : items) {
            // add each coffee's price to the total
            total = total.add(item.getPrice());
        }

        return total;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }
}