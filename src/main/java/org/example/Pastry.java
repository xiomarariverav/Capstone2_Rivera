package org.example;

import java.math.BigDecimal;

public class Pastry implements OrderItem {

    private String pastryType;
    private BigDecimal price;

    public Pastry(String pastryType) {
        this.pastryType = pastryType;
        this.price = new BigDecimal("1.50");
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getDetails() {
        return pastryType + " Pastry Price: $" + price;
    }

    public String getPastryType() {
        return pastryType;
    }
}