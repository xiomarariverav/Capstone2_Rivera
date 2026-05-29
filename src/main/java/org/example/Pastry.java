package org.example;

import java.math.BigDecimal;

public class Pastry implements OrderItem {
    //MUST have: getPrice() and getDetails()

    private String pastryType;
    private BigDecimal price;

    public Pastry(String pastryType) {
        this.pastryType = pastryType;
        this.price = new BigDecimal("1.50");
    }

    @Override
    //Returns the pastry price
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    //Returns a formatted description of the pastry
    public String getDetails() {
        return pastryType + " Pastry Price: $" + price;
    }

    //Allows other classes to read the pastry type
    public String getPastryType() {
        return pastryType;
    }
}