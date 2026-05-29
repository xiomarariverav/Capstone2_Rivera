package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    //This class is responsible for storing ordered items, adding new items and calculating the total cost

    private ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    //adds a new item to the order
    public void addItem(OrderItem item) {
        // newest item first
        items.add(0, item);
    }

    //calculates the total price of the order
    public BigDecimal getTotal() {
        //start Total at 0
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : items) {
            // add each coffee's price to the total
            total = total.add(item.getPrice());
        }

        return total;
    }

    //allows other classes to access the order’s items.
    public ArrayList<OrderItem> getItems() {
        return items;
    }
}